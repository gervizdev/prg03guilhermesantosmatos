/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.atividade16.curso.service;

import br.com.ifba.atividade16.curso.entity.CursoA16;
import java.util.List;

/**
 *
 * @author gerviz
 */
public interface CursoIService {

  CursoA16 save(CursoA16 curso) throws RuntimeException;

  CursoA16 update(CursoA16 curso) throws RuntimeException;

  void delete(CursoA16 curso) throws RuntimeException;

  CursoA16 findById(Long id) throws RuntimeException;

  List<CursoA16> findByNome(String nome) throws RuntimeException;
}
