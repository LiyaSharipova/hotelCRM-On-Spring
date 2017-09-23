package ru.kpfu.itis.sharipova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.sharipova.model.Booking;
import ru.kpfu.itis.sharipova.model.Room;
import ru.kpfu.itis.sharipova.model.RoomType;

import java.util.List;

/**
 * Created by lia on 25.05.16.
 */
@Repository
public interface RoomRepository extends JpaRepository <Room, Long> {
//    List<Room> findByRoomTypeInAndBookingsNotIn(List<RoomType> roomTypes, List<Booking> bookings);
    List<Room> findByRoomTypeIn(List<RoomType> roomTypes);
    List<Room> findByBookingsIn(List<Booking> bookings);
    List<Room> findByRoomType(RoomType roomType);
    List<Room> findByIdIn(List<Long> id);
    Room findById(Long id);
}
