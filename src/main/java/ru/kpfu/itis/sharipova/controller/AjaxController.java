package ru.kpfu.itis.sharipova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.itis.sharipova.model.Booking;
import ru.kpfu.itis.sharipova.model.Guest;
import ru.kpfu.itis.sharipova.service.BookingService;
import ru.kpfu.itis.sharipova.service.GuestService;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

/**
 * Created by lia on 30.05.16.
 */
@Controller
public class AjaxController {

    @Autowired
    GuestService guestService;

    @Autowired
    BookingService bookingService;

    @RequestMapping(value = "/ajax/getBookings", method = RequestMethod.GET)
    public String returnSecondResultPage(Model model,
                                 @RequestParam String login) throws IOException {
//        return bookingService.getFutureBookingsForGuest(guestService.getGuestByLogin(login));
        Guest guest = guestService.getGuestByLogin(login);
        if(guest!=null) {
            model.addAttribute("bookings", bookingService.getFutureBookingsForGuest(guest));
        }
        return "bookingsAjax";
    }
}
