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
public class Circulo extends Bidimensional {

  private double raio;

  public Circulo() {
  }

  public Circulo(double raio) {
    this.raio = raio;
  }

  @Override
  public double obterArea() {
    return raio * raio * Math.PI;
  }

  @Override
  public String toString() {
    String parametros;
    parametros = "tipo: circulo"
        + "\ndimensao: bidimensional"
        + "\nraio: " + getRaio()
        + "\narea: " + obterArea();
    return parametros;
  }

  public double getRaio() {
    return raio;
  }

  public void setRaio(double raio) {
    this.raio = raio;
  }

}
