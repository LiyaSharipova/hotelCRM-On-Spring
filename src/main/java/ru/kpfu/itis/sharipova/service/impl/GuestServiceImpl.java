package ru.kpfu.itis.sharipova.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.sharipova.forms.GuestRegistrationForm;
import ru.kpfu.itis.sharipova.model.Booking;
import ru.kpfu.itis.sharipova.model.Credentials;
import ru.kpfu.itis.sharipova.model.Guest;
import ru.kpfu.itis.sharipova.repository.CredentialsRepository;
import ru.kpfu.itis.sharipova.repository.GuestRepository;
import ru.kpfu.itis.sharipova.service.GuestService;

import java.util.Set;
import java.util.function.Function;

/**
 * Created by lia on 08.05.16.
 */
@Service
public class GuestServiceImpl implements GuestService {
    @Autowired
    Function<GuestRegistrationForm, Guest> guestFunction;

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    CredentialsRepository credentialsRepository;

    @Transactional
    @Override
    public void saveNewGuest(GuestRegistrationForm form) {
        Guest guest = guestFunction.apply(form);
        guestRepository.save(guest);
    }

    @Override
    public Guest getByCredentials(Credentials credentials) {
        return guestRepository.findByCredentials(credentials);
    }

    @Override
    public Guest getGuestByLogin(String login) {
        Guest guest = guestRepository.findByCredentials(credentialsRepository.findOneByLogin(login));
        return guest;

    }


}
