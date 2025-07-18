/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade18.aluno.entity;

import br.com.ifba.atividade18.curso.entity.CursoA18;
import br.com.ifba.atividade18.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.*;
import lombok.*;

/**
 *
 * @author gerviz
 */
@Entity
@Table(name = "alunos")
@Data
@EqualsAndHashCode(callSuper=false)
public class AlunoA18 extends PersistenceEntity {
  @Column(name = "nome", nullable = false)
  private String nome;
  @Column(name = "matricula", nullable = false, unique = true, length = 15)
  private String matricula;
  @Column(name = "cpf", nullable = false, unique = true, length = 15)
  private String cpf;
  @ManyToOne
  @JoinColumn(name = "curso_FK")
  private CursoA18 curso;
  private boolean ativo;
}
