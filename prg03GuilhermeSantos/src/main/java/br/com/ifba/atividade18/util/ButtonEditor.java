package br.com.ifba.atividade18.util;

import br.com.ifba.atividade18.view.AlunoListar;
import br.com.ifba.atividade18.view.CursoListar;
import java.awt.Component;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.Image;

public class ButtonEditor extends DefaultCellEditor {

  private JButton button;
  private String label;
  private JTable table;
  private boolean isPushed;
  private int currentRow;
  private int currentColumn;
  private CursoListar CursoFrame;
  private AlunoListar AlunoFrame;

  private static final int ICON_SIZE = 20;

  private static final ImageIcon REMOVER_ICON;
  private static final ImageIcon EDITAR_ICON;

  static {
    ImageIcon originalRemoverIcon = new ImageIcon(ButtonEditor.class.getResource("/br/com/ifba/atividade18/util/images/bin.png"));
    Image scaledRemoverImage = originalRemoverIcon.getImage().getScaledInstance(ICON_SIZE, ICON_SIZE, Image.SCALE_SMOOTH);
    REMOVER_ICON = new ImageIcon(scaledRemoverImage);

    ImageIcon originalEditarIcon = new ImageIcon(ButtonEditor.class.getResource("/br/com/ifba/atividade18/util/images/pen.png"));
    Image scaledEditarImage = originalEditarIcon.getImage().getScaledInstance(ICON_SIZE, ICON_SIZE, Image.SCALE_SMOOTH);
    EDITAR_ICON = new ImageIcon(scaledEditarImage);
  }

  public ButtonEditor(JCheckBox checkBox, CursoListar mainFrame) {
    super(checkBox);
    this.CursoFrame = mainFrame;
    button = new JButton();
    button.setOpaque(true);
    button.setBorderPainted(false);
    button.setFocusPainted(false);
    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

        fireEditingStopped();

        //usa current colum para saber qual botão foi apertado
        if (table.getColumnName(currentColumn).equals("REMOVER")) {
          mainFrame.removerCursoDaTabela(currentRow);

        } else if (table.getColumnName(currentColumn).equals("EDITAR")) { 
          mainFrame.editarCursoDaTabela(currentRow);
        }
      }
    });
  }
  
  public ButtonEditor(JCheckBox checkBox, AlunoListar mainFrame) {
    super(checkBox);
    this.AlunoFrame = mainFrame;
    button = new JButton();
    button.setOpaque(true);
    button.setBorderPainted(false);
    button.setFocusPainted(false);
    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

        fireEditingStopped();

        //usa current colum para saber qual botão foi apertado
        if (table.getColumnName(currentColumn).equals("REMOVER")) {
          mainFrame.removerAlunoDaTabela(currentRow);

        } else if (table.getColumnName(currentColumn).equals("EDITAR")) {
          mainFrame.editarAlunoDaTabela(currentRow);
        }
      }
    });
  }

  @Override
  public Component getTableCellEditorComponent(JTable table, Object value,
      boolean isSelected, int row, int column) {
    this.table = table;
    this.currentRow = row;
    this.currentColumn = column;

    if (isSelected) {
      button.setForeground(table.getSelectionForeground());
      button.setBackground(table.getSelectionBackground());
    } else {
      button.setForeground(table.getForeground());
      button.setBackground(new Color(70, 90, 110));
    }

    label = (value == null) ? "" : value.toString();

    if (table.getColumnName(column).equals("REMOVER")) {
      button.setIcon(REMOVER_ICON);
      button.setText("");
    } else if (table.getColumnName(column).equals("EDITAR")) {
      button.setIcon(EDITAR_ICON);
      button.setText("");
    } else {
      button.setIcon(null);
      button.setText(label);
    }

    isPushed = true;
    return button;
  }

  @Override
  public Object getCellEditorValue() {
    isPushed = false;
    return label;
  }

  @Override
  public boolean stopCellEditing() {
    isPushed = false;
    return super.stopCellEditing();
  }

  @Override
  protected void fireEditingStopped() {
    super.fireEditingStopped();
  }
}
