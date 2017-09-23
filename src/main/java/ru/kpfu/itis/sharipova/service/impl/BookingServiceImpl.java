package ru.kpfu.itis.sharipova.service.impl;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.sharipova.forms.BookingForm;
import ru.kpfu.itis.sharipova.forms.RoomSearchForm;
import ru.kpfu.itis.sharipova.model.Booking;
import ru.kpfu.itis.sharipova.model.Guest;
import ru.kpfu.itis.sharipova.model.Room;
import ru.kpfu.itis.sharipova.model.RoomType;
import ru.kpfu.itis.sharipova.repository.*;
import ru.kpfu.itis.sharipova.service.BookingService;
import ru.kpfu.itis.sharipova.util.DateUtil;
import ru.kpfu.itis.sharipova.util.SecurityUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by lia on 25.05.16.
 */
@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    RoomTypeRepository roomTypeRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    GuestRepository guestRepository;


    @Override
    public List<Room> getAvailableRooms(RoomSearchForm form) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date checkIn = null;
        Date checkOut = null;
        try {
            checkIn = format.parse(form.getCheckIn());
            checkOut = format.parse(form.getCheckOut());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<RoomType> roomTypes = roomTypeRepository.findByAdultsAndKids(form.getAdults(), form.getKids());
        List<Booking> bookings = bookingRepository.findBookingsBetweenGivenDates(checkIn, checkOut);
        List<Room> rooms = roomRepository.findByRoomTypeIn(roomTypes);
        if (bookings.size() != 0) {
            rooms.removeAll(roomRepository.findByBookingsIn(bookings));
        }
        return rooms;
    }

    @Override
    public List<Room> getAvailableRooms(BookingForm form, Long roomTypeId) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date checkIn = null;
        Date checkOut = null;
        try {
            checkIn = format.parse(form.getCheckIn());
            checkOut = format.parse(form.getCheckOut());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<Room> rooms= roomRepository.findByRoomType(roomTypeRepository.findById(roomTypeId));
        List<Booking> bookings = bookingRepository.findBookingsBetweenGivenDates(checkIn, checkOut);
        if (bookings.size() != 0) {
            rooms.removeAll(roomRepository.findByBookingsIn(bookings));
        }
        return rooms;
    }


    @Override
    public List<String> getUnAvailableDates(Long roomTypeid) {
        RoomType roomType= roomTypeRepository.findById(roomTypeid);
        List<Room> rooms = roomRepository.findByRoomType(roomType);
        List<LocalDate> localDates = new ArrayList<LocalDate>();
        for (Room room : rooms) {
            Set<LocalDate> roomsBookedDates = new HashSet<LocalDate>();
            for (Booking booking : room.getBookings()) {
               roomsBookedDates.addAll( DateUtil.getDatesBetween(booking.getCheckIn(), booking.getCheckOut()));
            }
            if(localDates.size()==0){
                localDates.addAll(roomsBookedDates);
            }
            else {
                localDates.retainAll(roomsBookedDates);
            }

        }
        return DateUtil.getStringFormatDates(localDates);
    }

    @Override
    public void createBooking(String checkIn, String checkOut, Long room_id) {
        Booking booking = new Booking();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            booking.setCheckIn(format.parse(checkIn));
            booking.setCheckOut(format.parse(checkOut));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        booking.setRoom(roomRepository.findById(room_id));
        booking.setGuest(guestRepository.findByCredentials(SecurityUtil.getCurrentUser()));
        bookingRepository.save(booking);
    }

    @Override
    public Set<Booking> getFutureBookingsForGuest(Guest guest) {
        Date today= new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Set<Booking> bookings = new HashSet<Booking>();
        for (Booking booking : guest.getBookings()) {
            if(!booking.getCheckIn().before(today)||booking.getCheckIn().equals(format.format(today))){
//                bookings.remove(booking);
                bookings.add(booking);
            }
        }
        return bookings;
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.delete(bookingRepository.findOne(id));
    }
}
