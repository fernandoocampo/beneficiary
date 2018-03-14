/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beneficiary.mediation.storage.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * base layer for all the DAOs – an abstract class using generics and designed
 * to be extended.
 *
 * @author fernando.ocampo
 */
public abstract class AbstractJpaDAO< T extends Serializable> {

    /**
     * Persistence entity type.
     */
    private Class< T> clazz;

    @PersistenceContext
    EntityManager entityManager;

    public final void setClazz(Class< T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    public T findOne(Long id) {
        return entityManager.find(clazz, id);
    }

    public List< T> findAll() {
        return entityManager.createQuery("from " + clazz.getName())
                .getResultList();
    }

    public void create(T entity) {
        entityManager.persist(entity);
    }

    public T update(T entity) {
        return entityManager.merge(entity);
    }

    public void delete(T entity) {
        entityManager.remove(entity);
    }

    public void deleteById(Long entityId) {
        T entity = findOne(entityId);
        delete(entity);
    }
}