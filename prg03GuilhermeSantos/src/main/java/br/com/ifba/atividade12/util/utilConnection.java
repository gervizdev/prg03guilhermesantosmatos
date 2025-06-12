/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade12.util;

import jakarta.persistence.*;
/**
 *
 * @author gerviz
 */
public class utilConnection {
  private static EntityManagerFactory fac;
  private static EntityManager em;

  private utilConnection() {
  }
  
   public static EntityManagerFactory getEMF() {
        if (fac == null) {
            fac = Persistence.createEntityManagerFactory("myDB");
        }
        return fac; 
    }
   
   public static void closeEMF() {
     if (fac != null && fac.isOpen()) {
            fac.close();
            fac = null; // Zera pra futuras inicializações se necessário
        }
   }
   
   public static EntityManager getEM() {
        return getEMF().createEntityManager();
    }  
}
