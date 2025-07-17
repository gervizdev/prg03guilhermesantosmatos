/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade18.tableModel;

import br.com.ifba.atividade18.curso.entity.CursoA18;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gerviz
 */
public class TableCursoModel extends AbstractTableModel {

  // Nomes das colunas que vão aparecer na tabela
  private final String[] colunas = {"ID", "NOME", "CODIGO", "ATIVO", "REMOVER", "EDITAR"};

  private List<CursoA18> dados;

  public TableCursoModel(List<CursoA18> dadosIniciais) {
    // Cria uma nova ArrayList para não mexer diretamente na lista original
    this.dados = new ArrayList<>(dadosIniciais);
  }

  @Override
  public int getRowCount() {
    return dados.size();
  }

  @Override
  public int getColumnCount() {
    return colunas.length;
  }

  @Override
  public String getColumnName(int column) {
    return colunas[column];
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    CursoA18 curso = dados.get(rowIndex); // Pega o objeto CursoA18 da linha atual

    switch (columnIndex) {
      case 0:
        return curso.getId();
      case 1:
        return curso.getNome();
      case 2:
        return curso.getCodigoCurso();
      case 3:
        return curso.isAtivo();
      case 4:
        return "Remover";
      case 5:
        return "Editar";
      default:
        return null;
    }
  }

  public void addCurso(CursoA18 curso) {
    this.dados.add(curso);
    // Avisa a tabela que uma nova linha foi inserida
    fireTableRowsInserted(dados.size() - 1, dados.size() - 1);
  }

  public void removeCurso(int rowIndex) {
    if (rowIndex >= 0 && rowIndex < dados.size()) {
      this.dados.remove(rowIndex);
      // Avisa a tabela que uma linha foi removida
      fireTableRowsDeleted(rowIndex, rowIndex);
    }
  }

  public CursoA18 getCursoAt(int rowIndex) {
    if (rowIndex >= 0 && rowIndex < dados.size()) {
      return dados.get(rowIndex);
    }
    return null;
  }

  // Método para atualizar a lista completa de dados da tabela 
  public void setDados(List<CursoA18> novosDados) {
    this.dados = new ArrayList<>(novosDados);
    fireTableDataChanged();
  }

  @Override
  public boolean isCellEditable(int rowIndex, int columnIndex) {
    // As duas últimas colunas (REMOVER e EDITAR) são editáveis para permitir o clique nos botões
    return columnIndex == getColumnCount() - 1 || columnIndex == getColumnCount() - 2;
  }

}
