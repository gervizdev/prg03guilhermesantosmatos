/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade15.curso.service;

import br.com.ifba.atividade15.curso.dao.CursoDao;
import br.com.ifba.atividade15.curso.dao.CursoIDao;
import br.com.ifba.atividade15.curso.entity.CursoA15;
import java.util.List;

/**
 *
 * @author gerviz
 */
public class CursoService implements CursoIService {
  //--------- OBJETO ---------

  private final CursoIDao cursoDao = new CursoDao();

  //--------- MÉTODOS ---------
  
  @Override
  public CursoA15 save(CursoA15 curso) throws RuntimeException {
      // Verifica se o curso é nulo
      if (curso == null) {
          throw new RuntimeException("Dados do curso não preenchidos");
      } 
      // Verifica se o curso já possui ID (existe no banco)
      else if (curso.getId() != null) {
          throw new RuntimeException("Curso já existente no banco de dados");
      }
      // Salva e retorna o curso
      return cursoDao.save(curso);
  }

  @Override
  public CursoA15 update(CursoA15 curso) throws RuntimeException {
      // Verifica se o curso é válido e possui ID para atualizar
      if (curso == null || curso.getId() == null) {
          throw new RuntimeException("Curso inválido para atualização");
      }
      // Atualiza e retorna o curso
      return cursoDao.update(curso);
  }

  @Override
  public void delete(CursoA15 curso) throws RuntimeException {
      // Verifica se o curso é válido e possui ID para excluir
      if (curso == null || curso.getId() == null) {
          throw new RuntimeException("Curso inválido para exclusão");
      }
      // Exclui o curso
      cursoDao.delete(curso);
  }

  @Override
  public CursoA15 findById(Long id) throws RuntimeException {
      // Verifica se o ID não é nulo
      if (id == null) {
          throw new RuntimeException("ID inválido");
      }
      // Busca e retorna o curso pelo ID
      return cursoDao.findById(id);
  }

  @Override
  public List<CursoA15> findByNome(String nome) throws RuntimeException {
      // Verifica se o nome é válido (não nulo e não vazio)
      if (nome == null || nome.trim().isEmpty()) {
          throw new RuntimeException("Nome inválido");
      }
      // Busca e retorna lista de cursos que contenham o nome
      return cursoDao.findByNome(nome);
  }
}
