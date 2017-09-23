package ru.kpfu.itis.sharipova.service;

import org.springframework.stereotype.Service;

/**
 * Created by lia on 30.05.16.
 */
@Service
public interface OrderService {
    void createOrder(Long bookingId);
}
