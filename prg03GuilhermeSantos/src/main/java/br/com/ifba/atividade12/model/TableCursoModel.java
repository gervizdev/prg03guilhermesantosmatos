/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade12.model;

import br.com.ifba.atividade12.entity.Curso;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gerviz
 */
public class TableCursoModel extends AbstractTableModel {

  // Nomes das colunas que vão aparecer na sua tabela
  private final String[] colunas = {"ID", "NOME", "CODIGO", "ATIVO", "REMOVER", "EDITAR"};

  // Lista onde vamos guardar os objetos Curso
  private List<Curso> dados;

  // Construtor: ele recebe a lista inicial de cursos para a tabela
  public TableCursoModel(List<Curso> dadosIniciais) {
    // Criamos uma nova ArrayList para não mexer diretamente na lista original
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
    Curso curso = dados.get(rowIndex); // Pega o objeto Curso da linha atual

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

  public void addCurso(Curso curso) {
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

  public Curso getCursoAt(int rowIndex) {
    if (rowIndex >= 0 && rowIndex < dados.size()) {
      return dados.get(rowIndex);
    }
    return null;
  }

  // Método para atualizar a lista completa de dados da tabela (usado na busca, por exemplo)
  public void setDados(List<Curso> novosDados) {
    this.dados = new ArrayList<>(novosDados);
    // Avisa a tabela que todos os dados mudaram (recria a tabela visualmente)
    fireTableDataChanged();
  }

  @Override
  public boolean isCellEditable(int rowIndex, int columnIndex) {
    // As duas últimas colunas (REMOVER e EDITAR) são editáveis para permitir o clique nos botões
    return columnIndex == getColumnCount() - 1 || columnIndex == getColumnCount() - 2;
  }

  // Método para definir o valor de uma célula (usado se você fosse editar os dados diretamente na tabela)
  @Override
  public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    Curso curso = dados.get(rowIndex);
    switch (columnIndex) {
      case 1:
        curso.setNome((String) aValue);
        break;
      case 2:
        curso.setCodigoCurso((String) aValue);
        break;
      case 3:
        curso.setAtivo((boolean) aValue);
        break;

    }

    fireTableCellUpdated(rowIndex, columnIndex);
  }

}
