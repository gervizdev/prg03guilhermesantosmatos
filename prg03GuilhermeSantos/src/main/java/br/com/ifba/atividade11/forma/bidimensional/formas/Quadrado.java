/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade11.forma.bidimensional.formas;

import br.com.ifba.atividade11.forma.bidimensional.Bidimensional;

/**
 *
 * @author gerviz
 */
public class Quadrado extends Bidimensional {

  public Quadrado(double lado1) {
  }
  private double lado;

  @Override
  public double obterArea() {
    return lado * lado;
  }

  @Override
  public String toString() {
    String parametros;
    parametros = "tipo: quadrado"
        + "\ndimensao: bidimensional"
        + "\nlado: " + getLado()
        + "\narea: " + obterArea();
    return parametros;
  }

  public double getLado() {
    return lado;
  }

  public void setLado(double lado) {
    this.lado = lado;
  }

}
