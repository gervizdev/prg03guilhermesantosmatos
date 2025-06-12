/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade12.util;

import br.com.ifba.atividade12.entity.Curso;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gerviz
 */
public class CursoSave {

  private List<Curso> allCursos;

  public void saveCurso(Curso curso) {
    EntityManager em = null;
    EntityTransaction transaction = null;

    try {
      em = utilConnection.getEM();

      transaction = em.getTransaction();
      transaction.begin();
      em.persist(curso);
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null && transaction.isActive()) {
        transaction.rollback();
      }
      System.err.println("Erro ao salvar curso: " + e.getMessage()); // Loga o erro no terminal
      e.printStackTrace(); // Imprime o stack trace completo
      throw e; // Joga a exceção pra cima pra quem chamou saber que deu erro
    } finally {
      if (em != null && em.isOpen()) {
        em.close();
      }
    }
  }

  public List<Curso> getAllCursos() {
    
    return allCursos;
  }

  public void setAllCursos(List<Curso> allCursos) {
    if (this.allCursos != null && !this.allCursos.isEmpty()) {
      for (Curso curso : this.allCursos) {
        try {
          saveCurso(curso);
          System.out.println(" Curso '" + curso.getNome() + "' salvo com sucesso!");
        } catch (Exception e) {
          System.err.println("Erro ao salvar o curso '" + curso.getNome() + "': " + e.getMessage());
          e.printStackTrace();
        }
      }
    } else {
      System.out.println("Nenhum curso na lista para salvar.");
    }
  }
}
