package ru.kpfu.itis.sharipova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.sharipova.forms.GuestRegistrationForm;
import ru.kpfu.itis.sharipova.service.GuestService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by lia on 05.05.16.
 */
@Controller
public class Authcontroller {
    @Autowired
    GuestService guestService;

    @Qualifier("guestRegistrationFormValidator")
    @Autowired
    Validator validator;

    @RequestMapping(value = "/login")
    public String login(@RequestParam(value = "error", required = false) Boolean error,
                        Model model) {
        if (Boolean.TRUE.equals(error)) {
            model.addAttribute("error", error);
        }
        return "login";
    }


    @RequestMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request) {
        if (request.isUserInRole("ROLE_HOTEL_ADMIN")) {
            return "redirect:/admin/createOrder";
        }
        if (request.isUserInRole("ROLE_USER")) {
            if(request.getSession().getAttribute("room_id")!=null){
                return "redirect:/booking/process";
            }
            return "redirect:/profile";
        }
        return null;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getRegistrationPage(Model model) {
        model.addAttribute("userform", new GuestRegistrationForm());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("userform") @Valid GuestRegistrationForm form, BindingResult result,
                               HttpServletRequest request) {
        validator.validate(form, result);
        if (result.hasErrors()) {
            return "registration";
        }
        guestService.saveNewGuest(form);
        if(request.getSession().getAttribute("room_id")!=null){
            return "redirect:/booking/process";
        }
        return "redirect:/";
    }

//    @RequestMapping(value = "/")
//    public String home(Model model) {
//        return "home";
//    }
}
