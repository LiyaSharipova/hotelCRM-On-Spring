package ru.kpfu.itis.sharipova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.sharipova.model.Hotel;

import java.util.List;

/**
 * Created by lia on 06.05.16.
 */
@Repository
interface HotelRepository extends JpaRepository<Hotel, Long> {
    Hotel findByName(String name);
    List<Hotel> findByCity (String city);
}
