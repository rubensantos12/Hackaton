package org.canonymous.chat.persistence.dao.jpa;

import org.canonymous.chat.persistence.dao.Dao;
import org.canonymous.chat.persistence.model.Room;

import java.util.List;

public class RoomDao extends GenericJpaDao implements org.canonymous.chat.persistence.dao.RoomDao {

    public RoomDao() {
        super(Room.class);
    }

}
