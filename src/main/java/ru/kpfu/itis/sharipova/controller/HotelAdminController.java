package ru.kpfu.itis.sharipova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.sharipova.service.BookingService;
import ru.kpfu.itis.sharipova.service.GuestService;
import ru.kpfu.itis.sharipova.service.OrderService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lia on 05.05.16.
 */
@Controller
@RequestMapping("/admin")
public class HotelAdminController {
    @Autowired
    GuestService guestService;

    @Autowired
    BookingService bookingService;

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/createOrder", method = RequestMethod.GET)
    public String getBookings(Model model, @RequestParam(value = "message", required = false) String message) {
        if (message != null) {
            model.addAttribute("message", message);
        }
        return "/createOrder";

    }

    @RequestMapping(value = "/createOrder", method = RequestMethod.POST)
    public String createOrder(@RequestParam("booking") Long id, HttpServletRequest request) {
        orderService.createOrder(id);
        request.setAttribute("message", "Order is successfully created");
        return "createOrder";
    }



}
