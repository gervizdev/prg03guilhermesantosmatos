/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade15.curso.dao;

import br.com.ifba.atividade15.curso.entity.CursoA15;
import br.com.ifba.atividade15.infrastructure.dao.GenericDao;
import java.util.List;

/**
 *
 * @author gerviz
 */
public class CursoDao extends GenericDao<CursoA15> implements CursoIDao {

  @Override
  public List<CursoA15> findByNome(String nome) {
    // Busca lista de cursos cujo nome contenha a string passada (LIKE %nome%)
    String jpql = "SELECT c FROM CursoA15 c WHERE c.nome LIKE :nome";
    return entityManager.createQuery(jpql, CursoA15.class)
        .setParameter("nome", "%" + nome + "%")
        .getResultList();
  }

}
