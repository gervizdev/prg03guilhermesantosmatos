/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.atividade18.aluno.controller;

import br.com.ifba.atividade18.aluno.entity.AlunoA18;
import java.util.List;

/**
 *
 * @author gerviz
 */
public interface AlunoIController {

  public AlunoA18 save(AlunoA18 aluno) throws RuntimeException;

  public AlunoA18 update(AlunoA18 aluno) throws RuntimeException;

  public void delete(AlunoA18 aluno) throws RuntimeException;

  public AlunoA18 findById(Long id) throws RuntimeException;

  public List<AlunoA18> findByNome(String nome) throws RuntimeException;
}
