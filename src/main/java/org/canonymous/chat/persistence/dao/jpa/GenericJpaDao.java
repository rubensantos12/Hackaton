package org.canonymous.chat.persistence.dao.jpa;

import org.canonymous.chat.persistence.dao.Dao;
import org.canonymous.chat.persistence.model.Model;
import org.canonymous.chat.persistence.model.Room;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class GenericJpaDao<T extends Model> implements Dao<T> {

    protected Class<T> modelType;

    public GenericJpaDao(Class<T> modelType) {
        this.modelType = modelType;
    }

    public Class<T> getModelType() {
        return modelType;
    }

    public void setModelType(Class<T> modelType) {
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
    public T get(Integer id) {
        return em.find(modelType, id);
    }

    @Override
    public T save(T modelObject) {
        return em.merge(modelObject);
    }

    @Override
    public void delete(int id) {
        em.remove(em.find(modelType, id));

    }

    @Override
    public List<T> listRooms() {

        CriteriaQuery<T> criteriaQuery = em.getCriteriaBuilder().createQuery(modelType);
        Root<T> root = criteriaQuery.from(modelType);
        return em.createQuery(criteriaQuery).getResultList();
    }
}
