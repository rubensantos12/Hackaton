package org.canonymous.chat.services;

import org.canonymous.chat.command.dto.RoomDto;

import java.util.List;

public class RoomServiceImpl implements RoomService{

    RoomDao roomDao;



    public void setRoomDao(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    public RoomDao getRoomDao() {
        return roomDao;
    }

    @Override
    public Room get(Integer id) {
        return null;
    }

    @Override
    public Room save(Room room) {
        return null;
    }

    @Override
    public void delete(Room room) {

    }

    @Override
    public List<Room> listRooms() {
        return null;
    }
}
