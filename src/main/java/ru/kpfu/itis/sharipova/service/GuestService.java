package ru.kpfu.itis.sharipova.service;

import ru.kpfu.itis.sharipova.forms.GuestRegistrationForm;
import ru.kpfu.itis.sharipova.model.Booking;
import ru.kpfu.itis.sharipova.model.Credentials;
import ru.kpfu.itis.sharipova.model.Guest;

import java.util.Set;

/**
 * Created by lia on 05.05.16.
 */
public interface GuestService {
    void saveNewGuest(GuestRegistrationForm form);
    Guest getByCredentials(Credentials credentials);
    Guest getGuestByLogin(String login);
}
