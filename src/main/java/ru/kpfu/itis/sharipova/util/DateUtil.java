package ru.kpfu.itis.sharipova.util;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by lia on 28.05.16.
 */
public class DateUtil {
    public static int getDateDifference(String date1, String date2) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return Days.daysBetween(new DateTime(format.parse(date1)), new DateTime(format.parse(date2))).getDays();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int getDateDifference(Date date1, Date date2) {
        return Days.daysBetween(new DateTime(date1), new DateTime(date2)).getDays();
    }

    public static Set<LocalDate> getDatesBetween(Date date1, Date date2) {
        Set<LocalDate> roomsBookedDates = new HashSet<LocalDate>();
        LocalDate checkIn = new LocalDate(date1);
        LocalDate checkOut = new LocalDate(date2);
        for (LocalDate date = checkIn; date.isBefore(checkOut); date = date.plusDays(1)) {
            roomsBookedDates.add(date);
        }
        return roomsBookedDates;
    }

    public static List<String> getStringFormatDates(Collection<LocalDate> localDates) {
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");
        List<String> dates = new ArrayList<String>();
        for (LocalDate localDate : localDates) {
            dates.add(localDate.toString(fmt));
        }
        return dates;
    }
}
