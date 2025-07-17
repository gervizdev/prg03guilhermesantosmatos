/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade18.curso.controller;

import br.com.ifba.atividade18.curso.entity.CursoA18;
import br.com.ifba.atividade18.curso.service.CursoIService;
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
  private CursoIService cursoIService;

  public CursoController(CursoIService cursoIService) {
    this.cursoIService = cursoIService;
  }

  public CursoController() {
    
  }

  @Override
  public CursoA18 save(CursoA18 curso) throws RuntimeException {
    // Salvar o curso recebido no sistema e retornar o curso salvo
    return cursoIService.save(curso);
  }

  @Override
  public CursoA18 update(CursoA18 curso) throws RuntimeException {
    // Atualizar o curso existente com os dados recebidos e retornar o curso atualizado
    return cursoIService.update(curso);
  }

  @Override
  public void delete(CursoA18 curso) throws RuntimeException {
    // Remover o curso recebido do sistema
    cursoIService.delete(curso);
  }

  @Override
  public CursoA18 findById(Long id) throws RuntimeException {
    // Buscar e retornar o curso com o ID informado
    return cursoIService.findById(id);
  }

  @Override
  public List<CursoA18> findByNome(String nome) throws RuntimeException {
    // Buscar e retornar uma lista de cursos cujo nome contenha o parâmetro informado
    return cursoIService.findByNome(nome);
  }

  public List<CursoA18> findAll() throws RuntimeException {
    //retorna todos os cursos
    return cursoIService.findAll();
  }
}
