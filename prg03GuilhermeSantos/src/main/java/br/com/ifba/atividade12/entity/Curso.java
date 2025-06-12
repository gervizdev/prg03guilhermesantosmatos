/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade12.entity;

import jakarta.persistence.Entity;

/**
 *
 * @author gerviz
 */
@Entity
public class Curso {

  private String nome;
  private int quantidade;
  private String descricao;
  private String fornecedor;

  public Curso() {
  }

  public Curso(String nome, int quantidade, String descricao, String fornecedor) {
    this.nome = nome;
    this.quantidade = quantidade;
    this.descricao = descricao;
    this.fornecedor = fornecedor;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getFornecedor() {
    return fornecedor;
  }

  public void setFornecedor(String fornecedor) {
    this.fornecedor = fornecedor;
  }
  
  

}
