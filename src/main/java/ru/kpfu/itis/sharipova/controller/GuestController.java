package ru.kpfu.itis.sharipova.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.sharipova.model.Guest;
import ru.kpfu.itis.sharipova.service.BookingService;
import ru.kpfu.itis.sharipova.service.GuestService;
import ru.kpfu.itis.sharipova.util.SecurityUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lia on 05.05.16.
 */
@Controller
//@RequestMapping(value = "/guest")

public class GuestController {
    @Autowired
    GuestService guestService;

    @Autowired
    BookingService bookingService;

    @RequestMapping("/profile")
    public String getProfilePage(Model model, @RequestParam(value = "message", required = false) String message){
        if(message!=null){
            model.addAttribute("message", message);
        }
        Guest guest= guestService.getByCredentials(SecurityUtil.getCurrentUser());
        model.addAttribute("guest", guest);
        model.addAttribute("bookings", bookingService.getFutureBookingsForGuest(guest));
//        model.addAttribute("room")
        return "profile";
    }

    @RequestMapping(value = "/cancelBooking/{id}", method = RequestMethod.POST)
    public String cancelBooking(@PathVariable("id") Long id, HttpServletRequest request){
        bookingService.deleteBooking(id);
        request.setAttribute("message", "Booking is cancelled");
        return "redirect:/profile";
    }
}
