package org.canonymous.chat.persistence.dao.jpa;

import org.canonymous.chat.persistence.dao.Dao;
import org.canonymous.chat.persistence.model.Room;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class RoomDao extends GenericJpaDao<Room> implements org.canonymous.chat.persistence.dao.RoomDao {

    public RoomDao() {
        super(Room.class);
    }

}
