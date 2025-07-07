/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.atividade15.curso.controller;

import br.com.ifba.atividade15.curso.entity.CursoA15;
import java.util.List;

/**
 *
 * @author gerviz
 */
public interface CursoIController {

  public CursoA15 save(CursoA15 curso) throws RuntimeException;

  public CursoA15 update(CursoA15 curso) throws RuntimeException;

  public void delete(CursoA15 curso) throws RuntimeException;

  public CursoA15 findById(Long id) throws RuntimeException;

  public List<CursoA15> findByNome(String nome) throws RuntimeException;
}
