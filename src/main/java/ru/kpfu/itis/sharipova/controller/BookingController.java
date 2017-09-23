package ru.kpfu.itis.sharipova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.sharipova.model.Room;
import ru.kpfu.itis.sharipova.model.enums.Role;
import ru.kpfu.itis.sharipova.service.BookingService;
import ru.kpfu.itis.sharipova.service.RoomService;
import ru.kpfu.itis.sharipova.util.DateUtil;
import ru.kpfu.itis.sharipova.util.SecurityUtil;

import javax.servlet.http.HttpServletRequest;
import java.security.Security;

/**
 * Created by lia on 29.05.16.
 */
@Controller
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    RoomService roomService;

    @Autowired
    BookingService bookingService;

    @RequestMapping(value = "/process", method = RequestMethod.GET)
    public String confirmBooking(Model model, HttpServletRequest request
//                                @CookieValue(value = "check_in", defaultValue = "none") String checkIn,
//                                @CookieValue(value = "check_out", defaultValue = "none") String checkOut
//                                 @RequestParam("checkIn") String checkIn,
//                                 @RequestParam("checkOut") String checkOut
    ) {
        if (request.isUserInRole("ROLE_USER")) {
            String checkIn = (String) request.getSession().getAttribute("checkIn");
            String checkOut = (String) request.getSession().getAttribute("checkOut");

//            Room room= roomService.getRoomById((Long) request.getSession().getAttribute("room_id"));
            model.addAttribute("room", roomService.getRoomById((Long) request.getSession().getAttribute("room_id")));
            model.addAttribute("check_in", checkIn);
            model.addAttribute("check_out", checkOut);
            model.addAttribute("days", DateUtil.getDateDifference(checkIn, checkOut));
            return "confirmBooking";
        } else if (request.isUserInRole("ROLE_HOTEL_ADMIN")) {
            return "redirect:/";
        } else return "redirect:/login";
    }

    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public String createBooking(HttpServletRequest request) {
//                                @CookieValue(value = "check_in", defaultValue = "none") String checkIn,
//                                @CookieValue(value = "check_out", defaultValue = "none") String checkOut)

        String checkIn = (String) request.getSession().getAttribute("checkIn");
        String checkOut = (String) request.getSession().getAttribute("checkOut");
        bookingService.createBooking(checkIn, checkOut, (Long) request.getSession().getAttribute("room_id"));
        return "redirect:/profile";
    }
}
