package org.canonymous.chat.persistence.dao;

import org.canonymous.chat.persistence.model.Model;
import org.canonymous.chat.persistence.model.Room;

import java.util.List;

public interface Dao<T extends Model> {

    T get(Integer id);

    T save(T modelObject);

    void delete(int id);

    List<T> listRooms();

}

