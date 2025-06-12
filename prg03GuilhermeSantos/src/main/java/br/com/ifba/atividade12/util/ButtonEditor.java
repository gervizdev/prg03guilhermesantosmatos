package br.com.ifba.atividade12.util; // <<-- AJUSTE SEU PACOTE AQUI!

import br.com.ifba.atividade12.entity.Curso;
import br.com.ifba.atividade12.view.CursoListar; // Importe sua CursoListar se ButtonEditor não está nela
import java.awt.Component;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.Image; // <<< ADICIONE ESTE IMPORT <<<

public class ButtonEditor extends DefaultCellEditor {

    private JButton button;
    private String label; // O texto "Remover" ou "Editar"
    private boolean isPushed;
    private JTable table;
    private int currentRow;
    private CursoListar mainFrame; // Referência à CursoListar

    // Define o tamanho desejado para os ícones (mesmo do ButtonRenderer)
    private static final int ICON_SIZE = 20;

    // O ideal é ter os Icones carregados uma vez só (static final)
    private static final ImageIcon REMOVER_ICON;
    private static final ImageIcon EDITAR_ICON;

    // >>> ESTE BLOCO STATIC PRECISA ESTAR AQUI, ANTES DO CONSTRUTOR <<<
    static {
        // Carrega e redimensiona o ícone da lixeira
        ImageIcon originalRemoverIcon = new ImageIcon(ButtonEditor.class.getResource("/br/com/ifba/atividade12/util/images/bin.png")); // <<-- AJUSTE SEU CAMINHO!
        Image scaledRemoverImage = originalRemoverIcon.getImage().getScaledInstance(ICON_SIZE, ICON_SIZE, Image.SCALE_SMOOTH);
        REMOVER_ICON = new ImageIcon(scaledRemoverImage);

        // Carrega e redimensiona o ícone do lápis
        ImageIcon originalEditarIcon = new ImageIcon(ButtonEditor.class.getResource("/br/com/ifba/atividade12/util/images/pen.png")); // <<-- AJUSTE SEU CAMINHO!
        Image scaledEditarImage = originalEditarIcon.getImage().getScaledInstance(ICON_SIZE, ICON_SIZE, Image.SCALE_SMOOTH);
        EDITAR_ICON = new ImageIcon(scaledEditarImage);
    }
    // FIM DO BLOCO STATIC

    public ButtonEditor(JCheckBox checkBox, CursoListar mainFrame) {
        super(checkBox);
        this.mainFrame = mainFrame;
        button = new JButton();
        button.setOpaque(true);
        button.setBorderPainted(false); // Opcional: Remover bordas e foco
        button.setFocusPainted(false);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {
        this.table = table;
        this.currentRow = row;

        // Cores do botão
        if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        } else {
            button.setForeground(table.getForeground());
            button.setBackground(new Color(70, 90, 110)); // Exemplo de cor para botões
        }
        
        label = (value == null) ? "" : value.toString();

        // Define o ícone e o texto
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
        if (isPushed) {
            // Lógica do que acontece ao clicar
            if (table.getColumnName(table.getEditingColumn()).equals("REMOVER")) { // Verifica a coluna pelo nome no momento da edição
                int confirm = JOptionPane.showConfirmDialog(table, 
                                                            "Tem certeza que deseja excluir o curso: " + 
                                                            mainFrame.tableModel.getCursoAt(currentRow).getNome() + "?", 
                                                            "Confirmar Exclusão", 
                                                            JOptionPane.YES_NO_OPTION,
                                                            JOptionPane.WARNING_MESSAGE);
                if (confirm == JOptionPane.YES_OPTION) {
                    mainFrame.removerCursoDaTabela(currentRow);
                }
            } else if (table.getColumnName(table.getEditingColumn()).equals("EDITAR")) { // Verifica a coluna pelo nome
                mainFrame.editarCursoDaTabela(currentRow);
            }
        }
        isPushed = false;
        return new String(label); // Retorna o label original (texto)
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