/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade16.curso.service;

import br.com.ifba.atividade16.curso.dao.CursoIDao;
import br.com.ifba.atividade16.curso.entity.CursoA16;
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
  private final CursoIDao cursoDao;

  
  //--------- construtor ---------
  public CursoService(CursoIDao cursoDao) {
    this.cursoDao = cursoDao;
  }

  
  
  //--------- MÉTODOS ---------
  
  @Override
  public CursoA16 save(CursoA16 curso) throws RuntimeException {
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
        return cursoDao.save(curso);
    } catch (Exception e) {
        String msg = e.getMessage();
        if (msg != null && msg.contains("duplicate key")) {
            throw new RuntimeException("Código do curso já existe!");
        }
        throw new RuntimeException("Erro ao salvar o curso: " + msg);
    }
  }

  @Override
  public CursoA16 update(CursoA16 curso) throws RuntimeException {
      // Verifica se o curso é válido e possui ID para atualizar
      if (curso == null || curso.getId() == null) {
          throw new RuntimeException("Curso inválido para atualização");
      }
      // O método save do JpaRepository faz update se o ID existir
      return cursoDao.save(curso);
  }

  @Override
  public void delete(CursoA16 curso) throws RuntimeException {
      // Verifica se o curso é válido e possui ID para excluir
      if (curso == null || curso.getId() == null) {
          throw new RuntimeException("Curso inválido para exclusão");
      }
      // Exclui o curso
      cursoDao.delete(curso);
  }

  @Override
  public CursoA16 findById(Long id) throws RuntimeException {
      // Verifica se o ID não é nulo
      if (id == null) {
          throw new RuntimeException("ID inválido");
      }
      // O método findById retorna Optional, então usamos orElse(null)
      return cursoDao.findById(id).orElse(null);
  }

  @Override
  public List<CursoA16> findByNome(String nome) throws RuntimeException {
      // Verifica se o nome é válido (não nulo e não vazio)
      if (nome == null || nome.trim().isEmpty()) {
          throw new RuntimeException("Nome inválido");
      }
      // Busca e retorna lista de cursos que contenham o nome
      return cursoDao.findByNome(nome);
  }

  @Override
  public List<CursoA16> findAll() throws RuntimeException {
    return cursoDao.findAll();
  }
}
