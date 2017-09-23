package ru.kpfu.itis.sharipova.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.sharipova.model.Room;
import ru.kpfu.itis.sharipova.model.RoomType;
import ru.kpfu.itis.sharipova.model.enums.RoomClass;
import ru.kpfu.itis.sharipova.repository.RoomTypeRepository;
import ru.kpfu.itis.sharipova.service.RoomTypeService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lia on 22.05.16.
 */
@Service
public class RoomTypeServiceImpl implements RoomTypeService {
    @Autowired
    RoomTypeRepository roomTypeRepository;

    @Override
    public RoomType getRoomTypeById(Long id) {
        return roomTypeRepository.findById(id);
    }

    @Override
    public List<RoomType> getStandartRooms() {
        return roomTypeRepository.findByRoomClass(RoomClass.STANDART);
    }

    @Override
    public List<RoomType> getLuxRooms() {
        return roomTypeRepository.findByRoomClass(RoomClass.LUX);
    }

    @Override
    public List<RoomType> getApartRooms() {
        return roomTypeRepository.findByRoomClass(RoomClass.APARTMENTS);

    }

    @Override
    public Set<RoomType> getRoomTypeOfRooms(List<Room> rooms) {
        Set<RoomType> roomTypes = new HashSet<RoomType>(roomTypeRepository.findByRoomsIn(rooms));
        return roomTypes;
    }

}
