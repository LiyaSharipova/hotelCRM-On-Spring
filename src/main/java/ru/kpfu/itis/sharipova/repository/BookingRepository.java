package ru.kpfu.itis.sharipova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.sharipova.model.Booking;

import java.util.Date;
import java.util.List;

/**
 * Created by lia on 06.05.16.
 */
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    //    @Query("select b from Booking b where b.checkIn>=:check_in and b.checkOut<:check_out")
//    List<Booking> findBookingsBetweenGivenDates(@Param("check_in") Date checkIn,
//                                                @Param("check_out") Date checkOut);
    @Query("select b from Booking b where (b.checkIn<=:check_in and b.checkOut>= :check_in) " +
            "or b.checkIn<= :check_out and b.checkOut>= :check_out")
    List<Booking> findBookingsBetweenGivenDates(@Param("check_in") Date checkIn,
                                                @Param("check_out") Date checkOut);

    void delete(Booking booking);
}
