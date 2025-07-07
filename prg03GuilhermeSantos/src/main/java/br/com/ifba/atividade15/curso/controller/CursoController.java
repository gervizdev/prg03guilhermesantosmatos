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
    // Salvar o curso recebido no sistema e retornar o curso salvo
    return cursoIService.save(curso);
  }

  @Override
  public CursoA15 update(CursoA15 curso) throws RuntimeException {
    // Atualizar o curso existente com os dados recebidos e retornar o curso atualizado
    return cursoIService.update(curso);
  }

  @Override
  public void delete(CursoA15 curso) throws RuntimeException {
    // Remover o curso recebido do sistema
    cursoIService.delete(curso);
  }

  @Override
  public CursoA15 findById(Long id) throws RuntimeException {
    // Buscar e retornar o curso com o ID informado
    return cursoIService.findById(id);
  }

  @Override
  public List<CursoA15> findByNome(String nome) throws RuntimeException {
    // Buscar e retornar uma lista de cursos cujo nome contenha o parâmetro informado
    return cursoIService.findByNome(nome);
  }

}
