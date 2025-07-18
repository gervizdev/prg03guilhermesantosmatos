/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade18.tableModel;

import br.com.ifba.atividade18.aluno.entity.AlunoA18;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gerviz
 */
public class TableAlunoModel extends AbstractTableModel {

  // Nomes das colunas que vão aparecer na tabela
  private final String[] colunas = {"ID", "NOME", "MATRICULA", "CPF", "CURSO", "ATIVO", "REMOVER", "EDITAR"};

  private List<AlunoA18> dados;

  public TableAlunoModel(List<AlunoA18> dadosIniciais) {
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
    AlunoA18 aluno = dados.get(rowIndex); // Pega o objeto AlunoA18 da linha atual

    switch (columnIndex) {
      case 0:
        return aluno.getId();
      case 1:
        return aluno.getNome();
      case 2:
        return aluno.getMatricula();
      case 3:
        return aluno.getCpf();
      case 4:
        return aluno.getCurso();
      case 5:
        return aluno.isAtivo();
      case 6:
        return "Remover";
      case 7:
        return "Editar";
      default:
        return null;
    }
  }

  public void addAluno(AlunoA18 aluno) {
    this.dados.add(aluno);
    // Avisa a tabela que uma nova linha foi inserida
    fireTableRowsInserted(dados.size() - 1, dados.size() - 1);
  }

  public void removeAluno(int rowIndex) {
    if (rowIndex >= 0 && rowIndex < dados.size()) {
      this.dados.remove(rowIndex);
      // Avisa a tabela que uma linha foi removida
      fireTableRowsDeleted(rowIndex, rowIndex);
    }
  }

  public AlunoA18 getAlunoAt(int rowIndex) {
    if (rowIndex >= 0 && rowIndex < dados.size()) {
      return dados.get(rowIndex);
    }
    return null;
  }

  // Método para atualizar a lista completa de dados da tabela 
  public void setDados(List<AlunoA18> novosDados) {
    this.dados = new ArrayList<>(novosDados);
    fireTableDataChanged();
  }

  @Override
  public boolean isCellEditable(int rowIndex, int columnIndex) {
    // As duas últimas colunas (REMOVER e EDITAR) são editáveis para permitir o clique nos botões
    return columnIndex == getColumnCount() - 1 || columnIndex == getColumnCount() - 2;
  }

}
