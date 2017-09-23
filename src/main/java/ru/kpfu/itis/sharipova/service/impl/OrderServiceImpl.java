package ru.kpfu.itis.sharipova.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.sharipova.model.Booking;
import ru.kpfu.itis.sharipova.model.Order;
import ru.kpfu.itis.sharipova.repository.BookingRepository;
import ru.kpfu.itis.sharipova.repository.HotelAdminRepository;
import ru.kpfu.itis.sharipova.repository.OrderRepository;
import ru.kpfu.itis.sharipova.service.OrderService;
import ru.kpfu.itis.sharipova.util.DateUtil;
import ru.kpfu.itis.sharipova.util.SecurityUtil;

/**
 * Created by lia on 30.05.16.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    HotelAdminRepository hotelAdminRepository;

    @Override
    public void createOrder(Long bookingId) {
        Booking booking = bookingRepository.findOne(bookingId);
        Order order = new Order(booking.getCheckIn(),
                                booking.getCheckOut(),
                                booking.getRoom().getRoomType().getPrice()* DateUtil.getDateDifference(booking.getCheckIn(),booking.getCheckOut()),
                                booking.getRoom(),
                                hotelAdminRepository.findByCredentials(SecurityUtil.getCurrentUser()),
                                booking.getGuest()
                        );
        bookingRepository.delete(booking);
        orderRepository.save(order);
    }

}
