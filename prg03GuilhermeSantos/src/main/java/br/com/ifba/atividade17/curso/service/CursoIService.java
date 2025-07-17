/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.atividade17.curso.service;

import br.com.ifba.atividade17.curso.entity.CursoA17;
import java.util.List;

/**
 *
 * @author gerviz
 */
public interface CursoIService {

  CursoA17 save(CursoA17 curso) throws RuntimeException;

  CursoA17 update(CursoA17 curso) throws RuntimeException;

  void delete(CursoA17 curso) throws RuntimeException;

  CursoA17 findById(Long id) throws RuntimeException;

  List<CursoA17> findByNome(String nome) throws RuntimeException;
  
  List<CursoA17> findAll() throws RuntimeException;
}
