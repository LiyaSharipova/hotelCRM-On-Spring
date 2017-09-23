package ru.kpfu.itis.sharipova.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.sharipova.model.Room;
import ru.kpfu.itis.sharipova.model.RoomType;
import ru.kpfu.itis.sharipova.repository.RoomRepository;
import ru.kpfu.itis.sharipova.repository.RoomTypeRepository;
import ru.kpfu.itis.sharipova.service.RoomService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lia on 29.05.16.
 */
@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    RoomRepository roomRepository;

    @Autowired
    RoomTypeRepository roomTypeRepository;

    @Override
    public Room getRoomById(Long id) {
        return roomRepository.findById(id);
    }

    @Override
    public List<Long> getRoomsIds(List<Room> rooms) {
        List<Long> ids = new ArrayList<Long>();
        for (Room room : rooms) {
            ids.add(room.getId());
        }
        return ids;
    }

    @Override
    public List<Room> getRoomsByIds(List<Long> ids) {
        return roomRepository.findByIdIn(ids);
    }

    @Override
    public Room getRoomByRoomType(Long roomTypeId) {
        return roomTypeRepository.findById(roomTypeId).getRooms().get(0);
    }

    @Override
    public Room getRoomByRoomTypeFromRooms(List<Room> rooms, Long roomTypeId) {
//        RoomType roomType = roomTypeRepository.findById(roomTypeId);
        for (Room room : rooms) {
            if (room.getRoomType().getId()==roomTypeId){
                return room;
            }
        }
        return null;
    }
}
