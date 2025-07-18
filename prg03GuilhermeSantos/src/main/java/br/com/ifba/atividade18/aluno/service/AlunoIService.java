/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.atividade18.aluno.service;

import br.com.ifba.atividade18.aluno.entity.AlunoA18;
import java.util.List;

/**
 *
 * @author gerviz
 */
public interface AlunoIService {

  AlunoA18 save(AlunoA18 aluno) throws RuntimeException;

  AlunoA18 update(AlunoA18 aluno) throws RuntimeException;

  void delete(AlunoA18 aluno) throws RuntimeException;

  AlunoA18 findById(Long id) throws RuntimeException;

  List<AlunoA18> findByNome(String nome) throws RuntimeException;
  
  List<AlunoA18> findAll() throws RuntimeException;
}
