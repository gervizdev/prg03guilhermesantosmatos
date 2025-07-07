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
        if (curso == null) {
            throw new RuntimeException("Dados do curso não preenchidos");
        } else if (curso.getId() != null) {
            throw new RuntimeException("Curso já existente no banco de dados");
        }
        return cursoDao.save(curso);
    }

    @Override
    public CursoA15 update(CursoA15 curso) throws RuntimeException {
        if (curso == null || curso.getId() == null) {
            throw new RuntimeException("Curso inválido para atualização");
        }
        return cursoDao.update(curso);
    }

    @Override
    public void delete(CursoA15 curso) throws RuntimeException {
        if (curso == null || curso.getId() == null) {
            throw new RuntimeException("Curso inválido para exclusão");
        }
        cursoDao.delete(curso);
    }

    @Override
    public CursoA15 findById(Long id) throws RuntimeException {
        if (id == null) {
            throw new RuntimeException("ID inválido");
        }
        return cursoDao.findById(id);
    }

    @Override
    public List<CursoA15> findByNome(String nome) throws RuntimeException {
        if (nome == null || nome.trim().isEmpty()) {
            throw new RuntimeException("Nome inválido");
        }
        return cursoDao.findByNome(nome);
    }
}

