/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.atividade17.curso.controller;

import br.com.ifba.atividade17.curso.entity.CursoA17;
import java.util.List;

/**
 *
 * @author gerviz
 */
public interface CursoIController {

  public CursoA17 save(CursoA17 curso) throws RuntimeException;

  public CursoA17 update(CursoA17 curso) throws RuntimeException;

  public void delete(CursoA17 curso) throws RuntimeException;

  public CursoA17 findById(Long id) throws RuntimeException;

  public List<CursoA17> findByNome(String nome) throws RuntimeException;
}
