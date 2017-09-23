package ru.kpfu.itis.sharipova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.sharipova.forms.BookingForm;
import ru.kpfu.itis.sharipova.forms.RoomSearchForm;
import ru.kpfu.itis.sharipova.service.BookingService;
import ru.kpfu.itis.sharipova.service.RoomService;
import ru.kpfu.itis.sharipova.service.RoomTypeService;
import ru.kpfu.itis.sharipova.util.DateUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by lia on 22.05.16.
 */
@Controller
@RequestMapping(value = "/rooms")
public class RoomController {

    @Autowired
    @Qualifier("bookingFormValidator")
    Validator validator;

    @Autowired
    RoomTypeService roomTypeService;

    @Autowired
    BookingService bookingService;

    @Autowired
    RoomService roomService;

    @RequestMapping(value = "/standart")
    public String getStandartRooms(Model model) {
        model.addAttribute("rooms", roomTypeService.getStandartRooms());
        model.addAttribute("class", "standart");
        return "/roomsType";
    }

    @RequestMapping(value = "/lux")
    public String getLuxRooms(Model model) {
        model.addAttribute("rooms", roomTypeService.getLuxRooms());
        model.addAttribute("class", "lux");
        return "/roomsType";
    }

    @RequestMapping(value = "/apartments")
    public String getApartmentsRooms(Model model) {
        model.addAttribute("rooms", roomTypeService.getApartRooms());
        model.addAttribute("class", "apartments");
        return "/roomsType";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getRoomDataPage(@PathVariable("id") Long id, Model model, HttpServletRequest request) {
        model.addAttribute("room", roomTypeService.getRoomTypeById(id));
        model.addAttribute("bookingForm", new BookingForm());
        List<String> disableDays= bookingService.getUnAvailableDates(id);
        if(disableDays.size()!=0) {
            model.addAttribute("disableDays", bookingService.getUnAvailableDates(id));
        }
        return "roomDataPage";
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String bookRoom(@PathVariable("id") Long id, Model model,
                           @ModelAttribute("bookingForm") @Valid BookingForm form, BindingResult result,
                           HttpServletResponse response, HttpServletRequest request){
        form.setRoomTypeId(id);
        validator.validate(form, result);
        if (result.hasErrors()) {
            model.addAttribute("bookingForm", form);
            model.addAttribute("room", roomTypeService.getRoomTypeById(id));
            List<String> disableDays= bookingService.getUnAvailableDates(id);
            if(disableDays.size()!=0) {
                model.addAttribute("disableDays", bookingService.getUnAvailableDates(id));
            }
            return "/roomDataPage";
        }
//        response.addCookie(new Cookie("check_in", form.getCheckIn()));
//        response.addCookie(new Cookie("check_out", form.getCheckOut()));
        request.getSession().setAttribute("checkIn", form.getCheckIn());
        request.getSession().setAttribute("checkOut", form.getCheckOut());
        if(bookingService.getAvailableRooms(form, id).size()!=0){
            request.getSession().setAttribute("room_id", bookingService.getAvailableRooms(form, id).get(0).getId());
        }
//        return "redirect:/rooms/"+id+"/process";
        return "redirect:/booking/process";

    }

    @RequestMapping(value = "/{id}/process")
    public String bookRoomProcess(@RequestParam("checkIn") String checkIn,
                                  @RequestParam("checkOut") String checkOut,
                                   HttpServletResponse response){
        response.addCookie(new Cookie("check_in", checkIn));
        response.addCookie(new Cookie("check_out", checkOut));
        return "redirect:/booking/process";

    }
}
