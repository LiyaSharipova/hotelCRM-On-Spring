package ru.kpfu.itis.sharipova.service;

import ru.kpfu.itis.sharipova.model.Room;
import ru.kpfu.itis.sharipova.model.RoomType;

import java.util.List;

/**
 * Created by lia on 29.05.16.
 */
public interface RoomService {
    Room getRoomById(Long id);
    List<Long> getRoomsIds(List<Room> rooms);
    List<Room> getRoomsByIds(List<Long> ids);
    Room getRoomByRoomType(Long roomTypeId);
    Room getRoomByRoomTypeFromRooms(List<Room> rooms, Long roomTypeId);
}
