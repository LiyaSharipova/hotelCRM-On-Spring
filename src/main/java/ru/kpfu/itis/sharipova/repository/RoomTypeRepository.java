package ru.kpfu.itis.sharipova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.sharipova.model.Room;
import ru.kpfu.itis.sharipova.model.RoomType;
import ru.kpfu.itis.sharipova.model.enums.RoomClass;

import java.util.List;

/**
 * Created by lia on 06.05.16.
 */
@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {
    RoomType findById(Long id);

    List<RoomType> findByRoomClass (RoomClass roomClass);
    List<RoomType> findByAdultsAndKids (Integer adults, Integer kids);
    List<RoomType> findByRoomsIn (List<Room> rooms);
}
