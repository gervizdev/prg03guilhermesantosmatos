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

  // EntityManager compartilhado para operações de persistência
  protected static EntityManager entityManager;

  // Inicialização estática do EntityManager com persistence unit "myDB"
  static {
    EntityManagerFactory factory = Persistence
        .createEntityManagerFactory("myDB");
    entityManager = factory.createEntityManager();
  }

  @Override
  public Entity save(Entity entity) {
    // Inicia transação, persiste entidade e comita
    entityManager.getTransaction().begin();
    entityManager.persist(entity);
    entityManager.getTransaction().commit();
    return entity;
  }

  @Override
  public Entity update(Entity entity) {
    // Inicia transação, atualiza entidade e comita
    entityManager.getTransaction().begin();
    entityManager.merge(entity);
    entityManager.getTransaction().commit();
    return entity;
  }

  @Override
  public void delete(Entity entity) {
    // Busca a entidade pelo ID para garantir que está gerenciada
    entity = findById(entity.getId());
    entityManager.getTransaction().begin();
    entityManager.remove(entity);
    entityManager.getTransaction().commit();
  }

  @Override
  public List<Entity> findAll() {
    // Busca todas as entidades do tipo usando JPQL dinâmico
    return entityManager.createQuery("from "
        + getTypeClass().getName()).getResultList();
  }

  @Override
  public Entity findById(Long id) {
    // Busca entidade por ID
    return (Entity) entityManager.find(getTypeClass(), id);
  }

  // Obtém a classe concreta do tipo genérico usado no DAO
  protected Class<?> getTypeClass() {
    Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
        .getGenericSuperclass())
        .getActualTypeArguments()[0];
    return clazz;
  }

}
