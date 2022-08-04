package org.canonymous.chat.persistence.dao.jpa;

import org.canonymous.chat.persistence.dao.Dao;
import org.canonymous.chat.persistence.model.Room;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class GenericJpaDao implements Dao {

    protected Class<Room> modelType;

    public GenericJpaDao(Class<Room> modelType) {
        this.modelType = modelType;
    }

    public Class<Room> getModelType() {
        return modelType;
    }

    public void setModelType(Class<Room> modelType) {
        this.modelType = modelType;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @PersistenceContext
    protected EntityManager em;

    @Override
    public Room get(Integer id) {
        return em.find(modelType, id);
    }

    @Override
    public Room save(Room room) {
        return em.merge(room);
    }

    @Override
    public void delete(int id) {
        em.remove(em.find(modelType, id));

    }

    @Override
    public List<Room> listRooms() {

        CriteriaQuery<Room> criteriaQuery = em.getCriteriaBuilder().createQuery(modelType);
        Root<Room> root = criteriaQuery.from(modelType);
        return em.createQuery(criteriaQuery).getResultList();
    }
}
