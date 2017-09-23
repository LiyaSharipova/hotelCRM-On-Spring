package ru.kpfu.itis.sharipova.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.sharipova.model.Credentials;
import ru.kpfu.itis.sharipova.model.enums.Role;
import ru.kpfu.itis.sharipova.repository.CredentialsRepository;

/**
 * Created by lia on 08.05.16.
 */
@Component
public class CredentialsCreator {

    static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    CredentialsRepository credentialsRepository;

    public Credentials createAndSaveCredentialsForUser(String password, String login, String email, Role role) {

        Credentials credentials = new Credentials();
        credentials.setPassword(encoder.encode(password));
        credentials.setRole(role);
        credentials.setLogin(login);
        credentials.setEmail(email);
        credentialsRepository.save(credentials);
        return credentials;
    }

}
