package ru.kpfu.itis.sharipova.service;

import ru.kpfu.itis.sharipova.model.Room;
import ru.kpfu.itis.sharipova.model.RoomType;

import java.util.List;
import java.util.Set;

/**
 * Created by lia on 06.05.16.
 */
public interface RoomTypeService {
    RoomType getRoomTypeById(Long id);
    List<RoomType> getStandartRooms();
    List<RoomType> getLuxRooms();
    List<RoomType> getApartRooms();
    Set<RoomType> getRoomTypeOfRooms(List<Room> rooms);
}
