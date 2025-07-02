/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade13.util;

import br.com.ifba.atividade13.entity.CursoA13;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gerviz
 */
public class CursoSave {

  public void saveCurso(CursoA13 curso) {
    EntityManager em = null;
    EntityTransaction transaction = null;

    try {
      em = utilConnection.getEM();

      transaction = em.getTransaction();
      transaction.begin();
      em.merge(curso);
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null && transaction.isActive()) {
        transaction.rollback();
      }
      System.err.println("Erro ao salvar curso: " + e.getMessage()); // joga o erro no terminal
      e.printStackTrace();
      throw e;
    } finally {
      if (em != null && em.isOpen()) {
        em.close();
      }
    }
  }

  public void deleteCurso(CursoA13 curso) {
    //tenta deletar, se der erro nao crasha e depois que termina fecha o entity manager
    EntityManager em = null;
    EntityTransaction transaction = null;

    try {
      em = utilConnection.getEM();

      transaction = em.getTransaction();
      transaction.begin();
      CursoA13 cursoD = em.merge(curso);
      em.remove(cursoD);
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null && transaction.isActive()) {
        transaction.rollback();
      }
      System.err.println("Erro ao deletar curso: " + e.getMessage()); // joga o erro no terminal
      e.printStackTrace();
      throw e;
    } finally {
      if (em != null && em.isOpen()) {
        em.close();
      }
    }
  }

  public List<CursoA13> getAllCursos() {
    EntityManager em = null;
    List<CursoA13> cursos = new ArrayList<>();
    //tenta salvar, se der erro nao crasha e depois que termina fecha o entity manager
    try {

      em = utilConnection.getEM();

      String jpql = "SELECT c FROM CursoA13 c";
      TypedQuery<CursoA13> query = em.createQuery(jpql, CursoA13.class);
      cursos = query.getResultList();

    } catch (Exception e) {
      System.err.println(" Erro ao buscar cursos: " + e.getMessage());
      throw new RuntimeException("Erro ao buscar cursos.", e);
    } finally {
      if (em != null && em.isOpen()) {
        em.close();
      }
    }
    return cursos;
  }

  public void saveAllCursos(List<CursoA13> allCursos) {
    if (allCursos != null && !allCursos.isEmpty()) {
      for (CursoA13 curso : allCursos) {
        try {
          saveCurso(curso);
          System.out.println(" Curso '" + curso.getNome() + "' salvo com sucesso!");
        } catch (Exception e) {
          System.err.println("Erro ao salvar o curso '" + curso.getNome() + "': " + e.getMessage());
        }
      }
    } else {
      System.out.println("Nenhum curso na lista para salvar.");
    }
  }
}
