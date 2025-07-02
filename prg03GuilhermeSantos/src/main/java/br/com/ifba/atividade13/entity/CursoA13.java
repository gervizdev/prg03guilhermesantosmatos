/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade13.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

/**
 *
 * @author gerviz
 */
@Entity
@Table(name = "cursos")
public class CursoA13 {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "nome", nullable = false)
  private String nome;
  @Column(name = "codigo_curso", nullable = false, unique = true, length = 255)
  private String codigoCurso;
  private boolean ativo;

  public CursoA13() {
  }

  public CursoA13(long id, String nome, String codigoCurso, boolean ativo) {
    this.id = id;
    this.nome = nome;
    this.codigoCurso = codigoCurso;
    this.ativo = ativo;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCodigoCurso() {
    return codigoCurso;
  }

  public void setCodigoCurso(String codigoCurso) {
    this.codigoCurso = codigoCurso;
  }

  public boolean isAtivo() {
    return ativo;
  }

  public void setAtivo(boolean ativo) {
    this.ativo = ativo;
  }

}
