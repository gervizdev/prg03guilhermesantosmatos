/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade15.infrastructure.dao;

import br.com.ifba.atividade15.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.*;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 *
 * @author gerviz
 */
public class GenericDao<Entity extends PersistenceEntity> implements GenericIDao<Entity> {

  protected static EntityManager entityManager;

  static {
    EntityManagerFactory factory = Persistence
        .createEntityManagerFactory("myDB");
    entityManager = factory.createEntityManager();
  }

  @Override
  public Entity save(Entity entity) {
    entityManager.getTransaction().begin();
    entityManager.persist(entity);
    entityManager.getTransaction().commit();
    return entity;
  }

  @Override
  public Entity update(Entity entity) {
    entityManager.getTransaction().begin();
    entityManager.merge(entity);
    entityManager.getTransaction().commit();
    return entity;
  }

  @Override
  public void delete(Entity entity) {
    entity = findById(entity.getId());
    entityManager.getTransaction().begin();
    entityManager.remove(entity);
    entityManager.getTransaction().commit();
  }

  @Override
  public List<Entity> findAll() {
    return entityManager.createQuery("from "
        + getTypeClass().getName()).getResultList();
  }

  @Override
  public Entity findById(Long id) {
    return (Entity) entityManager.find(getTypeClass(), id);
  }

  protected Class<?> getTypeClass() {
    Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
        .getGenericSuperclass())
        .getActualTypeArguments()[0];
    return clazz;
  }

}
