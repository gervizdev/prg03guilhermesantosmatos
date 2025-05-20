/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade11.forma.tridimensional.formas;

import br.com.ifba.atividade11.forma.tridimensional.Tridimensional;

/**
 *
 * @author gerviz
 */
public class Cubo extends Tridimensional {

  private double lado;

  public Cubo(double lado) {
    this.lado = lado;
  }

  @Override
  public double obterVolume() {
    return lado * lado * lado;
  }

  @Override
  public double obterArea() {
    return 6 * lado * lado;
  }

  @Override
  public String toString() {
    String parametros;
    parametros = "tipo: cubo"
        + "\nlado" + getLado()
        + "\nvolume: " + obterVolume()
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
