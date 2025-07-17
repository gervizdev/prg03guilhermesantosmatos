/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.atividade18.curso.controller;

import br.com.ifba.atividade18.curso.entity.CursoA18;
import java.util.List;

/**
 *
 * @author gerviz
 */
public interface CursoIController {

  public CursoA18 save(CursoA18 curso) throws RuntimeException;

  public CursoA18 update(CursoA18 curso) throws RuntimeException;

  public void delete(CursoA18 curso) throws RuntimeException;

  public CursoA18 findById(Long id) throws RuntimeException;

  public List<CursoA18> findByNome(String nome) throws RuntimeException;
}
