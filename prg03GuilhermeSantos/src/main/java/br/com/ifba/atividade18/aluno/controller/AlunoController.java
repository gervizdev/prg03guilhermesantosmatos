/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade18.aluno.controller;

import br.com.ifba.atividade18.aluno.entity.AlunoA18;
import br.com.ifba.atividade18.aluno.service.AlunoIService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author gerviz
 */
@Controller
public class AlunoController implements AlunoIController {

  @Autowired
  private AlunoIService alunoIService;

  public AlunoController(AlunoIService alunoIService) {
    this.alunoIService = alunoIService;
  }

  public AlunoController() {
    
  }

  @Override
  public AlunoA18 save(AlunoA18 aluno) throws RuntimeException {
    // Salvar o aluno recebido no sistema e retornar o aluno salvo
    return alunoIService.save(aluno);
  }

  @Override
  public AlunoA18 update(AlunoA18 aluno) throws RuntimeException {
    // Atualizar o aluno existente com os dados recebidos e retornar o aluno atualizado
    return alunoIService.update(aluno);
  }

  @Override
  public void delete(AlunoA18 aluno) throws RuntimeException {
    // Remover o aluno recebido do sistema
    alunoIService.delete(aluno);
  }

  @Override
  public AlunoA18 findById(Long id) throws RuntimeException {
    // Buscar e retornar o aluno com o ID informado
    return alunoIService.findById(id);
  }

  @Override
  public List<AlunoA18> findByNome(String nome) throws RuntimeException {
    // Buscar e retornar uma lista de alunos cujo nome contenha o parâmetro informado
    return alunoIService.findByNome(nome);
  }

  public List<AlunoA18> findAll() throws RuntimeException {
    //retorna todos os alunos
    return alunoIService.findAll();
  }
}
