package ru.kpfu.itis.sharipova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.sharipova.model.Credentials;
import ru.kpfu.itis.sharipova.model.Guest;

/**
 * Created by lia on 06.05.16.
 */
@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
    Guest findByCredentials (Credentials credentials);
}
