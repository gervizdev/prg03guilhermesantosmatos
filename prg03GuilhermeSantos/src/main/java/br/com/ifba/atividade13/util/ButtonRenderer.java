package br.com.ifba.atividade13.util;

import java.awt.Component;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import java.awt.Image;

public class ButtonRenderer extends JPanel implements TableCellRenderer {

  private JButton button;

  // Define o tamanho desejado para os ícones
  private static final int ICON_SIZE = 20;

  private static final ImageIcon REMOVER_ICON;
  private static final ImageIcon EDITAR_ICON;

  static {
    // Carrega e redimensiona o ícone da lixeira
    ImageIcon originalRemoverIcon = new ImageIcon(ButtonRenderer.class.getResource("/br/com/ifba/atividade12/util/images/bin.png")); // Seu caminho
    Image scaledRemoverImage = originalRemoverIcon.getImage().getScaledInstance(ICON_SIZE, ICON_SIZE, Image.SCALE_SMOOTH);
    REMOVER_ICON = new ImageIcon(scaledRemoverImage);

    // Carrega e redimensiona o ícone do lápis
    ImageIcon originalEditarIcon = new ImageIcon(ButtonRenderer.class.getResource("/br/com/ifba/atividade12/util/images/pen.png")); // Seu caminho
    Image scaledEditarImage = originalEditarIcon.getImage().getScaledInstance(ICON_SIZE, ICON_SIZE, Image.SCALE_SMOOTH);
    EDITAR_ICON = new ImageIcon(scaledEditarImage);
  }

  public ButtonRenderer() {
    setLayout(new BorderLayout());
    button = new JButton();
    button.setOpaque(true);
    add(button, BorderLayout.CENTER);
    button.setBorderPainted(false);
    button.setFocusPainted(false);
  }

  @Override
  public Component getTableCellRendererComponent(JTable table, Object value,
      boolean isSelected, boolean hasFocus, int row, int column) {
    if (isSelected) {
      button.setForeground(table.getSelectionForeground());
      button.setBackground(table.getSelectionBackground());
      this.setBackground(table.getSelectionBackground());
    } else {
      button.setForeground(table.getForeground());

      button.setBackground(new Color(204, 204, 204));

      this.setBackground(table.getBackground());
    }

    // Define o ícone e o texto
    switch (table.getColumnName(column)) {
      case "REMOVER" -> {
        button.setIcon(REMOVER_ICON);
        button.setText(""); // Remove o texto
      }
      case "EDITAR" -> {
        button.setIcon(EDITAR_ICON);
        button.setText(""); // Remove o texto
      }
    }

    setOpaque(true); // Garante que o JPanel de fundo seja pintado

    return this; // Retorna o painel com o botão
  }
}
