package org.canonymous.chat.persistence.dao;

import org.canonymous.chat.persistence.model.Room;

import java.util.List;

public interface Dao {

    Room get(Integer id);

    Room save(Room room);

    void delete(int id);

    List<Room> listRooms();

}

