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
public class Triangulo extends Bidimensional {

  private double lado1, lado2, lado3, base, altura;

  public Triangulo(double lado1, double lado2, double lado3) {
    this.lado1 = lado1;
    this.lado2 = lado2;
    this.lado3 = lado3;
  }

  public Triangulo(double base, double altura) {
    this.base = base;
    this.altura = altura;
  }

  public Triangulo() {
  }

  @Override
  public double obterArea() {
    if (base > 0 && altura > 0) {
      return (base * altura) / 2;
    } else {
      double semiperimetro = (lado1 + lado2 + lado3) / 2;
      return Math.sqrt(semiperimetro * (semiperimetro - lado1) * (semiperimetro - lado2) * (semiperimetro - lado3));
    }
  }

  @Override
  public String toString() {
    String parametros;
    if (base > 0 && altura > 0) {
      parametros = "tipo: triangulo"
          + "\nbase: " + getBase()
          + "\naltura: " + getAltura()
          + "\narea: " + obterArea();
    } else {
      parametros = "tipo: triangulo"
          + "\nlado1: " + getLado1()
          + "\nlado2: " + getLado2()
          + "\nlado3: " + getLado3()
          + "\narea: " + obterArea();
    }
    return parametros;
  }

  public double getLado1() {
    return lado1;
  }

  public void setLado1(double lado1) {
    this.lado1 = lado1;
  }

  public double getLado2() {
    return lado2;
  }

  public void setLado2(double lado2) {
    this.lado2 = lado2;
  }

  public double getLado3() {
    return lado3;
  }

  public void setLado3(double lado3) {
    this.lado3 = lado3;
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
