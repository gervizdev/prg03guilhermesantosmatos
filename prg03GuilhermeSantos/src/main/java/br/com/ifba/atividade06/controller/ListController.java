/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade06.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author gerviz
 */
// controla a lista
public class ListController {
// cria a lista com 10 elementos, todos o numero 0

  private final List<Integer> lista = new ArrayList<>(Collections.nCopies(10, 0));
// atualiza o valor baseado no index

  public void atualizar(int index, int valor) {
    lista.set(index, valor);
  }
// oredena em ordem crescente

  public void ordenar() {
    Collections.sort(lista);
  }
// retorna a lista para o MainFrame atualiza-la na tela

  public List<Integer> getLista() {
    return new ArrayList<>(lista);
  }
}
