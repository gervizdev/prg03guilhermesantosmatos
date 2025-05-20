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
public class Esfera extends Tridimensional{
  
  private double raio;

  public Esfera(double raio) {
    this.raio = raio;
  }
  
  
  @Override
  public double obterVolume() {
    return (4.0 / 3.0) * Math.PI * raio * raio * raio;
  }

  @Override
  public double obterArea() {
    return 4 * Math.PI * raio * raio;
  }

  @Override
  public String toString() {
      String parametros;
    parametros = "tipo: esfera"
        + "\ndimensao: tridimensional"
        + "\nraio: " + getRaio()
        + "\nvolume: " + obterVolume()
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
