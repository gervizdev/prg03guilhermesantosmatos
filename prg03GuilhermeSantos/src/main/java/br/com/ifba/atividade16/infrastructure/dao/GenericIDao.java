/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.atividade16.infrastructure.dao;

import br.com.ifba.atividade16.infrastructure.entity.PersistenceEntity;
import java.util.List;

/**
 *
 * @author gerviz
 */
public interface GenericIDao<Entity extends PersistenceEntity> {

  public abstract Entity save(Entity obj);

  /**
   * Update an instance of the persistent entity in the system.
   */
  public abstract Entity update(Entity obj);

  /**
   * Remove an instance of the persistent entity in the system database.
   *
   * @param obj The instance that is updated
   */
  public abstract void delete(Entity obj);

  /**
   * Retrieve all instances of the entity in the database.
   *
   * @return a {@link List} with the results.
   */
  public abstract List<Entity> findAll();

  /**
   * Find an entity by primary key.
   *
   * @param id
   * @return the entity.
   */
  public abstract Entity findById(Long id);
}
