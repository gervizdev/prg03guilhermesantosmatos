/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade07.controller;

/**
 *
 * @author gerviz
 */
public class fatorialController {
    
    public int getFatorial(int valor){
      int resultado = 1;
    for (int i = 2; i <= valor; i++) {
        resultado *= i;
    }
    return resultado;
    }
    
    public String getFormula(int valor) {
    StringBuilder formula = new StringBuilder("Fórmula: ");
    for (int i = valor; i > 1; i--) {
        formula.append(i).append(" x ");
    }
    formula.append("1");
    return formula.toString();
}

}
