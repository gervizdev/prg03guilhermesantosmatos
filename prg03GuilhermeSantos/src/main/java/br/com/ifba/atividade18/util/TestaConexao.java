package br.com.ifba.atividade18.util;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import javax.swing.JOptionPane;


public class TestaConexao implements CommandLineRunner {

    @Autowired
    private EntityManager em;

    @Override
    public void run(String... args) throws Exception {
        try {
            if (em.isOpen()) {
                JOptionPane.showMessageDialog(null, "Conectado com sucesso!", "Status da Conexão", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Falha na conexão!", "Status da Conexão", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar: \n" + e.getMessage(), "Status da Conexão", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
