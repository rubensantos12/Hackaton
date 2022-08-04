package org.canonymous.chat.services;

import org.canonymous.chat.command.dto.RoomDto;
import org.canonymous.chat.persistence.model.Room;

import java.util.List;

public interface RoomService {

    Room get(Integer id);

    Room save(Room room);

    void delete(int id);

    List<Room> listRooms();



}
