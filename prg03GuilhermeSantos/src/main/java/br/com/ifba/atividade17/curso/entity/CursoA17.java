/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade17.curso.entity;

import br.com.ifba.atividade17.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

/**
 *
 * @author gerviz
 */
@Entity
@Table(name = "cursos")
public class CursoA17 extends PersistenceEntity {

  // Nome do curso, campo obrigatório
  @Column(name = "nome", nullable = false)
  private String nome;

  // Código único do curso, obrigatório, com limite de 255 caracteres
  @Column(name = "codigo_curso", nullable = false, unique = true, length = 255)
  private String codigoCurso;

  // Indica se o curso está ativo ou não
  private boolean ativo;

  public CursoA17() {
  }

  // Construtor com parâmetros para facilitar criação de objetos
  public CursoA17(long id, String nome, String codigoCurso, boolean ativo) {
    this.nome = nome;
    this.codigoCurso = codigoCurso;
    this.ativo = ativo;
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
