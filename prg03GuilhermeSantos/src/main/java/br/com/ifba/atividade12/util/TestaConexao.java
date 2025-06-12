package br.com.ifba.atividade12.util;

import jakarta.persistence.*;
import javax.swing.JOptionPane;

public class TestaConexao {
    public static void main(String[] args) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("myDB");
            EntityManager em = emf.createEntityManager();
            
            JOptionPane.showMessageDialog(null, "Conectado com sucesso!", "Status da Conexão", JOptionPane.INFORMATION_MESSAGE);
            
            em.close();
            emf.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar: \n" + e.getMessage(), "Status da Conexão", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}