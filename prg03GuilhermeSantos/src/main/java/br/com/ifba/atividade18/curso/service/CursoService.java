/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade18.curso.service;

import br.com.ifba.atividade18.curso.entity.CursoA18;
import br.com.ifba.atividade18.curso.repository.CursoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gerviz
 */
@Service
public class CursoService implements CursoIService {
  //--------- OBJETO ---------

  @Autowired
  private final CursoRepository cursoRepository;

  
  //--------- construtor ---------
  public CursoService(CursoRepository cursoRepository) {
    this.cursoRepository = cursoRepository;
  }

  
  
  //--------- MÉTODOS ---------
  
  @Override
  public CursoA18 save(CursoA18 curso) throws RuntimeException {
      // Verifica se o curso é nulo
      if (curso == null) {
          throw new RuntimeException("Dados do curso não preenchidos");
      } 
      // Verifica se o curso já possui ID (existe no banco)
      else if (curso.getId() != null) {
          throw new RuntimeException("Curso já existente no banco de dados");
      }
      // Salva e retorna o curso
      try {
        return cursoRepository.save(curso);
    } catch (Exception e) {
        String msg = e.getMessage();
        if (msg != null && msg.contains("duplicate key")) {
            throw new RuntimeException("Código do curso já existe!");
        }
        throw new RuntimeException("Erro ao salvar o curso: " + msg);
    }
  }

  @Override
  public CursoA18 update(CursoA18 curso) throws RuntimeException {
      // Verifica se o curso é válido e possui ID para atualizar
      if (curso == null || curso.getId() == null) {
          throw new RuntimeException("Curso inválido para atualização");
      }
      // O método save do JpaRepository faz update se o ID existir
      return cursoRepository.save(curso);
  }

  @Override
  public void delete(CursoA18 curso) throws RuntimeException {
      // Verifica se o curso é válido e possui ID para excluir
      if (curso == null || curso.getId() == null) {
          throw new RuntimeException("Curso inválido para exclusão");
      }
      // Exclui o curso
      cursoRepository.delete(curso);
  }

  @Override
  public CursoA18 findById(Long id) throws RuntimeException {
      // Verifica se o ID não é nulo
      if (id == null) {
          throw new RuntimeException("ID inválido");
      }
      // O método findById retorna Optional, então usamos orElse(null)
      return cursoRepository.findById(id).orElse(null);
  }

  @Override
  public List<CursoA18> findByNome(String nome) throws RuntimeException {
      // Verifica se o nome é válido (não nulo e não vazio)
      if (nome == null) {
          throw new RuntimeException("Nome inválido");
      }
      if(nome.trim().isEmpty()){
      return cursoRepository.findAll();
      }
      // Busca e retorna lista de cursos que contenham o nome
      return cursoRepository.findByNomeContainingIgnoreCase(nome);
  }

  @Override
  public List<CursoA18> findAll() throws RuntimeException {
    return cursoRepository.findAll();
  }
}
