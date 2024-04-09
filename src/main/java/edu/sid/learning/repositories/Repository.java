package edu.sid.learning.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Optional;

public abstract class Repository<E, ID> {

    @PersistenceContext(unitName = "pu1")
    protected EntityManager entityManager;


    @SuppressWarnings("unchecked")
    private Class<E> entityClazz() {
        return (Class<E>)
                ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Collection<E> findAll() {
        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<E> criteriaQuery = criteriaBuilder.createQuery(this.entityClazz());
        Root<E> root = criteriaQuery.from(this.entityClazz());
        return this.entityManager.createQuery(criteriaQuery).getResultList();
    }

    public Optional<E> findById(ID id) {
        try {
            return Optional.of(this.entityManager.find(this.entityClazz(), id));
        } catch (NoResultException ignored) {
        }
        return Optional.empty();
    }

    public E save(E entity) {
        if (this.entityManager.contains(entity)) {
            return this.entityManager.merge(entity);
        }
        this.entityManager.persist(entity);
        return entity;
    }

    public void delete(ID id) {
        this.findById(id).ifPresent(e -> entityManager.remove(e));
    }
}