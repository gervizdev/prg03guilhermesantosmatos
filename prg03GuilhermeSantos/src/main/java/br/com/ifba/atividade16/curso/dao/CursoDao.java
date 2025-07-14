/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade16.curso.dao;

import br.com.ifba.atividade16.curso.entity.CursoA16;
import br.com.ifba.atividade16.infrastructure.dao.GenericDao;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gerviz
 */
@Repository
public class CursoDao extends GenericDao<CursoA16> implements CursoIDao {

  @Override
  public List<CursoA16> findByNome(String nome) {
    // Busca lista de cursos cujo nome contenha a string passada (LIKE %nome%)
    String jpql = "SELECT c FROM CursoA16 c WHERE c.nome LIKE :nome";
    return entityManager.createQuery(jpql, CursoA16.class)
        .setParameter("nome", "%" + nome + "%")
        .getResultList();
  }

}
