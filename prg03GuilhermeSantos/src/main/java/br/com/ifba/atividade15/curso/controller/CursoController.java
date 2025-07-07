/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade15.curso.controller;

import br.com.ifba.atividade15.curso.entity.CursoA15;
import br.com.ifba.atividade15.curso.service.CursoIService;
import br.com.ifba.atividade15.curso.service.CursoService;
import java.util.List;

/**
 *
 * @author gerviz
 */
public class CursoController implements CursoIController {

  private final CursoIService cursoIService = new CursoService();

  @Override
public CursoA15 save(CursoA15 curso) throws RuntimeException {
    return cursoIService.save(curso);
}

@Override
public CursoA15 update(CursoA15 curso) throws RuntimeException {
    return cursoIService.update(curso);
}

@Override
public void delete(CursoA15 curso) throws RuntimeException {
    cursoIService.delete(curso);
}

@Override
public CursoA15 findById(Long id) throws RuntimeException {
    return cursoIService.findById(id);
}

@Override
public List<CursoA15> findByNome(String nome) throws RuntimeException {
    return cursoIService.findByNome(nome);
}


}
