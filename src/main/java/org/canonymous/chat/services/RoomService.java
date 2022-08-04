package org.canonymous.chat.services;

import org.canonymous.chat.command.dto.RoomDto;

import java.util.List;

public interface RoomService {

    Room get(Integer id);

    Room save(Room room);

    void delete(Room room);

    List<Room> listRooms();



}
