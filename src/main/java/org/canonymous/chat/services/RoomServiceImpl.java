package org.canonymous.chat.services;

import org.canonymous.chat.persistence.dao.jpa.RoomDao;
import org.canonymous.chat.persistence.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class RoomServiceImpl implements RoomService{

    private RoomDao roomDao;

    @Autowired
    public void setRoomDao(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    public RoomDao getRoomDao() {
        return roomDao;
    }
    @Transactional
    @Override
    public Room get(Integer id) {
        return roomDao.get(id);
    }
    @Transactional
    @Override
    public Room save(Room room) {
        return roomDao.save(room);
    }

    @Transactional
    @Override
    public void delete(int id) {
        roomDao.delete(id);
    }


    @Override
    public List<Room> listRooms() {
        return roomDao.listRooms();
    }
}
