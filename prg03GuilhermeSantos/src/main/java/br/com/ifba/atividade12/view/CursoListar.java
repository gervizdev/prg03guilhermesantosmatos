/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.ifba.atividade12.view;

import br.com.ifba.atividade12.model.TableCursoModel;
import br.com.ifba.atividade12.entity.Curso;
import br.com.ifba.atividade12.util.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gerviz
 */
public class CursoListar extends javax.swing.JFrame {

  CursoSave manager = new CursoSave();
  AddOrEditCurso addCurso = new AddOrEditCurso(this, true, false, null);
  public TableCursoModel tableModel;

  /**
   * Creates new form MainFrame
   */
  public CursoListar() {
    tableModel = new TableCursoModel(manager.getAllCursos());

    initComponents();
    tblCursos.setModel(tableModel);

    // Configura o Renderizador e Editor para as colunas de "Remover" e "Editar"
    // Coluna "REMOVER" (índice 4)
    tblCursos.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer());
    // Passa 'this' (a própria CursoListar) para o ButtonEditor poder chamar os métodos
    tblCursos.getColumnModel().getColumn(4).setCellEditor(new ButtonEditor(new javax.swing.JCheckBox(), this));

    // Coluna "EDITAR" (índice 5)
    tblCursos.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
    tblCursos.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(new javax.swing.JCheckBox(), this));

    //faz uma simulação de um placeholder
    txtSearch.setText("Procurar...");
    txtSearch.setForeground(java.awt.Color.GRAY); // Cor da fonte
    txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
      @Override
      public void focusGained(java.awt.event.FocusEvent evt) {
        if (txtSearch.getText().equals("Procurar...")) {
          txtSearch.setText("");
          txtSearch.setForeground(java.awt.Color.BLACK); // Cor da fonte normal
        }
      }

      @Override
      public void focusLost(java.awt.event.FocusEvent evt) {
        if (txtSearch.getText().isEmpty()) {
          txtSearch.setText("Procurar...");
          txtSearch.setForeground(java.awt.Color.GRAY);
        }
      }
    });
  }

  public void removerCursoDaTabela(int rowIndex) {
    Curso cursoParaRemover = tableModel.getCursoAt(rowIndex);

    if (cursoParaRemover != null) {
      String nomeCurso = cursoParaRemover.getNome();

      int confirm = JOptionPane.showConfirmDialog(this,
          "Tem certeza que deseja excluir o curso: " + nomeCurso + "?",
          "Confirmar Exclusão",
          JOptionPane.YES_NO_OPTION,
          JOptionPane.WARNING_MESSAGE);

      if (confirm == JOptionPane.YES_OPTION) {
        try {
          manager.deleteCurso(cursoParaRemover);

          // sincroniza a tabela
          tableModel.setDados(manager.getAllCursos());

          JOptionPane.showMessageDialog(this, "Curso '" + nomeCurso + "' removido com sucesso!");

        } catch (Exception e) {
          // Se der erro na exclusão do banco, avisa o usuário.
          JOptionPane.showMessageDialog(this, "Erro ao remover curso: " + e.getMessage(), "Erro de Exclusão", JOptionPane.ERROR_MESSAGE);
          e.printStackTrace();
        }
      }
    } else {
      // Se o curso na linha era nulo por algum motivo.
      JOptionPane.showMessageDialog(this, "Erro: Curso não encontrado na linha selecionada.", "Erro", JOptionPane.ERROR_MESSAGE);
      System.err.println("Tentativa de remover curso nulo ou inexistente na linha: " + rowIndex);
    }
  }

  // Método para editar um curso da tabela
  public void editarCursoDaTabela(int rowIndex) {
    Curso cursoParaEditar = tableModel.getCursoAt(rowIndex);
    AddOrEditCurso editCurso = new AddOrEditCurso(this, true, true, cursoParaEditar);
    editCurso.setVisible(true);
  }

  private void realizaBusca(String termoBusca) {
    List<Curso> resultados = new ArrayList<>();
    String termoLowerCase = termoBusca.toLowerCase().trim(); // Converte para minúsculas e remove espaços

    if (termoLowerCase.isEmpty()) {
      // Se o campo de busca estiver vazio, mostra todos os cursos originais
      resultados.addAll(manager.getAllCursos());
    } else {
      // Filtra a lista de cursos original
      for (Curso curso : manager.getAllCursos()) {
        // Verifica se o termo de busca está no nome, codigo ou id
        try {
          if (curso.getNome().toLowerCase().contains(termoLowerCase)
              || curso.getCodigoCurso().toLowerCase().contains(termoLowerCase)
              || curso.getId() == Integer.parseInt(termoBusca)) {
            resultados.add(curso);
          }
        } catch (NumberFormatException e) {
          //so pra n retornar erro
        }
      }
    }
    // Atualiza o modelo da tabela com os resultados (filtrados ou todos)
    tableModel.setDados(resultados);
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jScrollPane1 = new javax.swing.JScrollPane();
    tblCursos = new javax.swing.JTable();
    txtSearch = new javax.swing.JTextField();
    btnRefresh = new javax.swing.JButton();
    btnAddCurso = new javax.swing.JButton();
    btnHome = new javax.swing.JButton();
    lblBackground = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("cursos");
    setPreferredSize(new java.awt.Dimension(740, 480));
    setResizable(false);
    setSize(new java.awt.Dimension(740, 480));
    getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    tblCursos.setBackground(new java.awt.Color(204, 204, 204));
    tblCursos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
    tblCursos.setForeground(new java.awt.Color(0, 0, 0));
    tblCursos.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {

      }
    ));
    tblCursos.setSelectionBackground(new java.awt.Color(102, 102, 255));
    tblCursos.setSelectionForeground(new java.awt.Color(204, 204, 204));
    tblCursos.setShowGrid(false);
    tblCursos.getTableHeader().setResizingAllowed(false);
    tblCursos.getTableHeader().setReorderingAllowed(false);
    jScrollPane1.setViewportView(tblCursos);
    tblCursos.getTableHeader().setResizingAllowed(true);
    tblCursos.setRowHeight(35);
    tblCursos.getTableHeader().setBackground(Color.DARK_GRAY);

    getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 50, 720, -1));
    jScrollPane1.getViewport().setBackground(new java.awt.Color(40, 60, 80));
    jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder());

    txtSearch.setText("jTextField1");
    txtSearch.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        txtSearchActionPerformed(evt);
      }
    });
    getContentPane().add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 20, 82, -1));

    btnRefresh.setText("Refresh");
    btnRefresh.setToolTipText("refresh the tabel with the Data Base data ");
    btnRefresh.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnRefreshActionPerformed(evt);
      }
    });
    getContentPane().add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 20, 82, -1));

    btnAddCurso.setText("+");
    btnAddCurso.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnAddCursoActionPerformed(evt);
      }
    });
    getContentPane().add(btnAddCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 20, 82, -1));

    btnHome.setText("Home");
    btnHome.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnHomeActionPerformed(evt);
      }
    });
    getContentPane().add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(519, 20, 82, -1));

    lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ifba/atividade12/view/images/backgroung.png"))); // NOI18N
    getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, -1));

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
    realizaBusca(txtSearch.getText());
  }//GEN-LAST:event_txtSearchActionPerformed

  private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
    this.dispose();
  }//GEN-LAST:event_btnHomeActionPerformed

  private void btnAddCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCursoActionPerformed
    addCurso.setVisible(true);
  }//GEN-LAST:event_btnAddCursoActionPerformed

  private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
    tableModel.setDados(manager.getAllCursos());
  }//GEN-LAST:event_btnRefreshActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
      javax.swing.UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatDarculaLaf());
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(CursoListar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(() -> {
      new CursoListar().setVisible(true);
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnAddCurso;
  private javax.swing.JButton btnHome;
  private javax.swing.JButton btnRefresh;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JLabel lblBackground;
  private javax.swing.JTable tblCursos;
  private javax.swing.JTextField txtSearch;
  // End of variables declaration//GEN-END:variables
}
