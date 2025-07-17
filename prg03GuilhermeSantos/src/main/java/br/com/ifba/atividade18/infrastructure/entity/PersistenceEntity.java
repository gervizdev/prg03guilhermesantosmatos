/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade18.infrastructure.entity;

import jakarta.persistence.*;

/**
 *
 * @author gerviz
 */
@MappedSuperclass
public class PersistenceEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  public Long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
}
