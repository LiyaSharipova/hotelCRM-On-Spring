package ru.kpfu.itis.sharipova.util.transformers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.sharipova.forms.GuestRegistrationForm;
import ru.kpfu.itis.sharipova.model.Guest;
import ru.kpfu.itis.sharipova.model.enums.Role;
import ru.kpfu.itis.sharipova.repository.CredentialsRepository;
import ru.kpfu.itis.sharipova.util.CredentialsCreator;

import java.util.function.Function;


/**
 * Created by lia on 08.05.16.
 */
@Component
public class GuestRegistrationFormTransformer implements Function<GuestRegistrationForm, Guest> {

    @Autowired
    CredentialsCreator credentialsCreator;


    @Override
    public Guest apply(GuestRegistrationForm form) {
        Guest guest = new Guest();
        guest.setCredentials(credentialsCreator.createAndSaveCredentialsForUser(
                form.getPassword(),
                form.getLogin(),
                form.getEmail(),
                Role.ROLE_USER
        ));
        guest.setName(form.getName());
        guest.setPhoneNumber(form.getPhoneNumber());
        return guest;
    }
}
