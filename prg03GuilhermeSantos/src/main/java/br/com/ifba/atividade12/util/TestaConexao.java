package br.com.ifba.atividade12.util;

import jakarta.persistence.*;

public class TestaConexao {
  public static void main(String[] args) {
    try {
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("myDB");
      EntityManager em = emf.createEntityManager();
      System.out.println("✅ Conectado com sucesso!");
      em.close();
      emf.close();
    } catch (Exception e) {
      System.out.println("❌ Erro ao conectar:");
      e.printStackTrace();
    }
  }
}
