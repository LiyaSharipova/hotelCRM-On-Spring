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
import ru.kpfu.itis.sharipova.model.Room;
import ru.kpfu.itis.sharipova.model.RoomType;
import ru.kpfu.itis.sharipova.service.BookingService;
import ru.kpfu.itis.sharipova.service.RoomService;
import ru.kpfu.itis.sharipova.service.RoomTypeService;
import ru.kpfu.itis.sharipova.util.DateUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;

/**
 * Created by lia on 14.05.16.
 */
@Controller
//@RequestMapping("/search")
public class SearchController {

    @Autowired
    RoomService roomService;

    @Autowired
    BookingService bookingService;

    @Autowired
    RoomTypeService roomTypeService;

    @Qualifier("roomSearchFormValidator")
    @Autowired
    Validator validator;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHomePage(Model model) {
        model.addAttribute("roomSearchForm", new RoomSearchForm());
        return "home";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String roomSearch(@ModelAttribute("roomSearchForm") @Valid RoomSearchForm form, BindingResult result,
                             HttpServletResponse response, HttpServletRequest request) {
        validator.validate(form, result);
        if (result.hasErrors()) {
            return "home";
        }

        response.addCookie(new Cookie("check_in", form.getCheckIn()));
        response.addCookie(new Cookie("check_out", form.getCheckOut()));
        List<Room> rooms = bookingService.getAvailableRooms(form);
        request.getSession().setAttribute("rooms", roomService.getRoomsIds(rooms));
        return "redirect:/search/results";
    }

    @RequestMapping(value = "search/results")
    public String searchResults(Model model, HttpServletRequest request,
                                @CookieValue(value = "check_in", defaultValue = "none") String checkIn,
                                @CookieValue(value = "check_out", defaultValue = "none") String checkOut) {
        List<Room> rooms = roomService.getRoomsByIds((List<Long>) request.getSession().getAttribute("rooms"));//TODO get it from ids
        Set<RoomType> roomTypes = roomTypeService.getRoomTypeOfRooms(rooms);
        model.addAttribute("days", DateUtil.getDateDifference(checkIn, checkOut));
        model.addAttribute("roomTypes", roomTypes);
        return "searchResults";
    }

    @RequestMapping(value = "search/results/room/{id}", method = RequestMethod.GET)
    public String getRoomDataPage(@PathVariable("id") Long id, Model model,
                                  HttpServletRequest request,
                                  @CookieValue(value = "check_in", defaultValue = "none") String checkIn,
                                  @CookieValue(value = "check_out", defaultValue = "none") String checkOut) {
        if (!checkIn.equals("none") && !checkOut.equals("none")) {
            model.addAttribute("checkIn", checkIn);
            model.addAttribute("checkOut", checkOut);
            model.addAttribute("days", DateUtil.getDateDifference(checkIn, checkOut));
            request.getSession().setAttribute("checkIn", checkIn);
            request.getSession().setAttribute("checkOut", checkOut);
        }

        model.addAttribute("room", roomTypeService.getRoomTypeById(id));
//        model.addAttribute("bookingForm", new BookingForm());
        return "roomDataPage";
    }

    @RequestMapping(value = "search/results/room/{id}", method = RequestMethod.POST)
    public String bookRoom(HttpServletRequest request, @PathVariable("id") Long id) {
        List<Room> rooms = roomService.getRoomsByIds((List<Long>) request.getSession().getAttribute("rooms"));
        request.getSession().setAttribute("room_id", (roomService.getRoomByRoomTypeFromRooms(rooms, id)).getId());
        return "redirect:/booking/process";
    }
}
