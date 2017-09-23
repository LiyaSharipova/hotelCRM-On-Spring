package ru.kpfu.itis.sharipova.util.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.kpfu.itis.sharipova.forms.RoomSearchForm;
import ru.kpfu.itis.sharipova.repository.BookingRepository;
import ru.kpfu.itis.sharipova.service.BookingService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by lia on 14.05.16.
 */
@Component
public class RoomSearchFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return RoomSearchForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        Date checkIn = null;
        Date checkOut = null;
        RoomSearchForm form = (RoomSearchForm) o;
        if (form.getCheckIn().equals("") || form.getCheckOut().equals("")) {
            errors.rejectValue("checkIn", "", "fill in check in and check out fields");
        } else {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            try {
                checkIn = format.parse(form.getCheckIn());
                checkOut = format.parse(form.getCheckOut());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (checkIn.after(checkOut) || checkIn.equals(checkOut)) {
                errors.rejectValue("checkIn", "", "Check in date can not be the same or earlier than check out");
            }
        }

    }
}
