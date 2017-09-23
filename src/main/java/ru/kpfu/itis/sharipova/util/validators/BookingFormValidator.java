package ru.kpfu.itis.sharipova.util.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.kpfu.itis.sharipova.forms.BookingForm;
import ru.kpfu.itis.sharipova.forms.RoomSearchForm;
import ru.kpfu.itis.sharipova.service.BookingService;
import ru.kpfu.itis.sharipova.util.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by lia on 26.05.16.
 */
@Component
public class BookingFormValidator implements Validator {
    @Autowired
    BookingService bookingService;

    @Override
    public boolean supports(Class<?> aClass) {
        return BookingForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        BookingForm form= (BookingForm) o;
        if(form.getCheckIn().equals("")|| form.getCheckOut().equals("")){
            errors.rejectValue("checkIn", "", "fill in check in and check out fields");
        }
        else {
            Date checkIn = null;
            Date checkOut = null;
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
            List<String> bookDays = DateUtil.getStringFormatDates(DateUtil.getDatesBetween(checkIn, checkOut));
            if (bookingService.getUnAvailableDates(form.getRoomTypeId()).removeAll(bookDays)) {
                errors.rejectValue("checkIn", "", "These dates are already booked");
            }
            if(bookingService.getAvailableRooms(form, form.getRoomTypeId()).size()==0){
                errors.rejectValue("checkIn", "", "Sorry, room isn't available for these dates. Try shorter period");
            }
        }

    }
}
