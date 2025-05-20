/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade11.forma;

import java.util.ArrayList;
import java.util.List;

public class FormList {
    private List<Forma> formas;

    public FormList() {
        formas = new ArrayList<>();
    }

    public void adicionarForma(Forma forma) {
        formas.add(forma);
    }

    public List<Forma> getFormas() {
        return formas;
    }
    
    // Se quiser, pode adicionar métodos para remover, buscar, listar, etc.
}
