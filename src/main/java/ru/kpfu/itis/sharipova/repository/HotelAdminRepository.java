package ru.kpfu.itis.sharipova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.sharipova.model.Credentials;
import ru.kpfu.itis.sharipova.model.HotelAdmin;

/**
 * Created by lia on 30.05.16.
 */
@Repository
public interface HotelAdminRepository extends JpaRepository<HotelAdmin, Long> {
    HotelAdmin findByCredentials(Credentials credentials);
}
