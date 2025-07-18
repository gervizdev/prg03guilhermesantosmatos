/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade18.aluno.service;

import br.com.ifba.atividade18.aluno.entity.AlunoA18;
import br.com.ifba.atividade18.aluno.repository.AlunoRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author gerviz
 */
@Service
@RequiredArgsConstructor
public class AlunoService implements AlunoIService {
  //--------- OBJETO ---------

  private final AlunoRepository alunoRepository;
  
  //--------- MÉTODOS ---------
  
  @Override
  public AlunoA18 save(AlunoA18 aluno) throws RuntimeException {
      // Verifica se o aluno é nulo
      if (aluno == null) {
          throw new RuntimeException("Dados do aluno não preenchidos");
      } 
      // Verifica se o aluno já possui ID (existe no banco)
      else if (aluno.getId() != null) {
          throw new RuntimeException("Aluno já existente no banco de dados");
      }
      // Salva e retorna o aluno
      try {
        return alunoRepository.save(aluno);
    } catch (Exception e) {
        String msg = e.getMessage();
        if (msg != null && msg.contains("duplicate key")) {
            throw new RuntimeException("Código do aluno já existe!");
        }
        throw new RuntimeException("Erro ao salvar o aluno: " + msg);
    }
  }

  @Override
  public AlunoA18 update(AlunoA18 aluno) throws RuntimeException {
      // Verifica se o aluno é válido e possui ID para atualizar
      if (aluno == null || aluno.getId() == null) {
          throw new RuntimeException("Aluno inválido para atualização");
      }
      // O método save do JpaRepository faz update se o ID existir
      return alunoRepository.save(aluno);
  }

  @Override
  public void delete(AlunoA18 aluno) throws RuntimeException {
      // Verifica se o aluno é válido e possui ID para excluir
      if (aluno == null || aluno.getId() == null) {
          throw new RuntimeException("Aluno inválido para exclusão");
      }
      // Exclui o aluno
      alunoRepository.delete(aluno);
  }

  @Override
  public AlunoA18 findById(Long id) throws RuntimeException {
      // Verifica se o ID não é nulo
      if (id == null) {
          throw new RuntimeException("ID inválido");
      }
      // O método findById retorna Optional, então usamos orElse(null)
      return alunoRepository.findById(id).orElse(null);
  }

  @Override
  public List<AlunoA18> findByNome(String nome) throws RuntimeException {
      // Verifica se o nome é válido (não nulo e não vazio)
      if (nome == null) {
          throw new RuntimeException("Nome inválido");
      }
      if(nome.trim().isEmpty()){
      return alunoRepository.findAll();
      }
      // Busca e retorna lista de alunos que contenham o nome
      return alunoRepository.findByNomeContainingIgnoreCase(nome);
  }

  @Override
  public List<AlunoA18> findAll() throws RuntimeException {
    return alunoRepository.findAll();
  }
}
