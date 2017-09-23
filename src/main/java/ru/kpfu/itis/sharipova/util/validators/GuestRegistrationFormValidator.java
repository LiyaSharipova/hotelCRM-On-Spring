package ru.kpfu.itis.sharipova.util.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.kpfu.itis.sharipova.forms.GuestRegistrationForm;
import ru.kpfu.itis.sharipova.repository.CredentialsRepository;

/**
 * Created by lia on 07.05.16.
 */
@Component
//@Qualifier("guestValidator")
public class GuestRegistrationFormValidator implements Validator {
    @Autowired
    CredentialsRepository credentialsRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return GuestRegistrationForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        GuestRegistrationForm form = (GuestRegistrationForm) o;
        if (credentialsRepository.findOneByLogin(form.getLogin()) != null) {
            errors.rejectValue("login", "", "user with that login already exists");
        }
        if (credentialsRepository.findOneByEmail(form.getEmail()) != null) {
            errors.rejectValue("email", "", "user with that password exits");
        }
        if (!form.getPassword().equals(form.getRepassword())) {
            errors.rejectValue("repassword", "", "password is not confirmed");
        }

    }
}
