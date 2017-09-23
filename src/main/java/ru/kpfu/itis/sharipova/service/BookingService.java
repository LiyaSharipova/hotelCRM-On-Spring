package ru.kpfu.itis.sharipova.service;

import ru.kpfu.itis.sharipova.forms.BookingForm;
import ru.kpfu.itis.sharipova.forms.RoomSearchForm;
import ru.kpfu.itis.sharipova.model.Booking;
import ru.kpfu.itis.sharipova.model.Guest;
import ru.kpfu.itis.sharipova.model.Room;
import ru.kpfu.itis.sharipova.model.RoomType;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by lia on 06.05.16.
 */
public interface BookingService {
    List<Room> getAvailableRooms(RoomSearchForm form);
    List<Room> getAvailableRooms(BookingForm form, Long roomTypeId);
    List<String> getUnAvailableDates(Long roomTypeId);
    void createBooking(String checkIn, String checkOut, Long room_id);
    Set<Booking> getFutureBookingsForGuest(Guest guest);
    void deleteBooking(Long id);
}

