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
public class Piramide extends Tridimensional{
  private double base, altura;

  public Piramide(double base, double altura) {
    this.base = base;
    this.altura = altura;
  }
  
  @Override
  public double obterVolume() {
    return (base * base * altura) / 3;
  }

  @Override
  public double obterArea() {
     double arestaBase = base;
    double areaBase = arestaBase * arestaBase;
    double apotema = Math.sqrt((altura * altura) + ((arestaBase / 2) * (arestaBase / 2)));
    double areaLateral = 2 * arestaBase * apotema;
    return areaBase + areaLateral;
  }

  @Override
  public String toString() {
      String parametros;
    parametros = "tipo: piramide"
        + "\nbase: " + getBase()
        + "\naltura: " + getAltura()
        + "\nvolume: " + obterVolume()
        + "\narea: " + obterArea();
    return parametros;
  }

  public double getBase() {
    return base;
  }

  public void setBase(double base) {
    this.base = base;
  }

  public double getAltura() {
    return altura;
  }

  public void setAltura(double altura) {
    this.altura = altura;
  }
  
}
