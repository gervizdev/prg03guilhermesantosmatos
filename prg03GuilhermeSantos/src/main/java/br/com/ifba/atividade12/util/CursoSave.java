/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade12.util;

import br.com.ifba.atividade12.entity.Curso;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gerviz
 */
public class CursoSave {

  public void saveCurso(Curso curso) {
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

  public void deleteCurso(Curso curso) {
    //tenta deletar, se der erro nao crasha e depois que termina fecha o entity manager
    EntityManager em = null;
    EntityTransaction transaction = null;

    try {
      em = utilConnection.getEM();

      transaction = em.getTransaction();
      transaction.begin();
      Curso cursoD = em.merge(curso);
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

  public List<Curso> getAllCursos() {
    EntityManager em = null;
    List<Curso> cursos = new ArrayList<>();
    //tenta salvar, se der erro nao crasha e depois que termina fecha o entity manager
    try {

      em = utilConnection.getEM();

      String jpql = "SELECT c FROM Curso c";
      TypedQuery<Curso> query = em.createQuery(jpql, Curso.class);
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

  public void saveAllCursos(List<Curso> allCursos) {
    if (allCursos != null && !allCursos.isEmpty()) {
      for (Curso curso : allCursos) {
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
