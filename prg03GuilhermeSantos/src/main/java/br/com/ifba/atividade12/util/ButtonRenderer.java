package br.com.ifba.atividade12.util;

import java.awt.Component;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;
import java.awt.Image;

public class ButtonRenderer extends JPanel implements TableCellRenderer {

    private JButton button;

    // Define o tamanho desejado para os ícones
    private static final int ICON_SIZE = 20; // Por exemplo, 20x20 pixels

    private static final ImageIcon REMOVER_ICON;
    private static final ImageIcon EDITAR_ICON;

    // >>> ESTE BLOCO STATIC PRECISA ESTAR AQUI, ANTES DO CONSTRUTOR <<<
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
    // FIM DO BLOCO STATIC

    public ButtonRenderer() {
        setLayout(new BorderLayout());
        button = new JButton();
        button.setOpaque(true);
        add(button, BorderLayout.CENTER);
        // Opcional: Remover bordas e foco para o FlatLaf deixar o botão mais clean
        button.setBorderPainted(false);
        button.setFocusPainted(false);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {
        // Cores de fundo e foreground do botão baseado na seleção da célula
        if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
            this.setBackground(table.getSelectionBackground()); // Fundo do JPanel do renderizador
        } else {
            button.setForeground(table.getForeground()); // Cor do texto da tabela (geralmente branco)
            // Use uma cor de fundo para o botão que combine com o tema escuro
            button.setBackground(new Color(204, 204, 204)); // Exemplo de cor para botões

            // Fundo do JPanel do renderizador (que é a célula)
            this.setBackground(table.getBackground()); // Cor de fundo da tabela (geralmente escuro)
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
            default -> {
                // Este renderizador não deveria ser usado para outras colunas,
                // mas se for por engano, ele não mostra nada ou o valor.
                // Para ter certeza, você pode esconder o botão
                button.setIcon(null);
                button.setText((value != null) ? value.toString() : ""); // Se for usado em coluna de texto
                // Mas o ideal é que esse renderizador só seja usado nas colunas de botão.
            }
        }

        setOpaque(true); // Garante que o JPanel de fundo seja pintado

        return this; // Retorna o painel com o botão
    }
}