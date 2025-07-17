/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade18.curso.entity;

import br.com.ifba.atividade18.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.*;

/**
 *
 * @author gerviz
 */
@Entity
@Table(name = "cursos")
@Data
public class CursoA18 extends PersistenceEntity {
  @Column(name = "nome", nullable = false)
  private String nome;
  @Column(name = "codigo_curso", nullable = false, unique = true, length = 6)
  private String codigoCurso;
  private boolean ativo;
}
