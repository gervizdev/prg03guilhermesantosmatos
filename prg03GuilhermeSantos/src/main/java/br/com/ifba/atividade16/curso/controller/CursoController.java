/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade16.curso.controller;

import br.com.ifba.atividade16.curso.entity.CursoA16;
import br.com.ifba.atividade16.curso.service.CursoIService;
import br.com.ifba.atividade16.curso.service.CursoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author gerviz
 */
@Controller
public class CursoController implements CursoIController {

  @Autowired
  private final CursoIService cursoIService;

  public CursoController(CursoIService cursoIService) {
    this.cursoIService = cursoIService;
  }

  @Override
  public CursoA16 save(CursoA16 curso) throws RuntimeException {
    // Salvar o curso recebido no sistema e retornar o curso salvo
    return cursoIService.save(curso);
  }

  @Override
  public CursoA16 update(CursoA16 curso) throws RuntimeException {
    // Atualizar o curso existente com os dados recebidos e retornar o curso atualizado
    return cursoIService.update(curso);
  }

  @Override
  public void delete(CursoA16 curso) throws RuntimeException {
    // Remover o curso recebido do sistema
    cursoIService.delete(curso);
  }

  @Override
  public CursoA16 findById(Long id) throws RuntimeException {
    // Buscar e retornar o curso com o ID informado
    return cursoIService.findById(id);
  }

  @Override
  public List<CursoA16> findByNome(String nome) throws RuntimeException {
    // Buscar e retornar uma lista de cursos cujo nome contenha o parâmetro informado
    return cursoIService.findByNome(nome);
  }

}
