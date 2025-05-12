/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade08.accountController;

import br.com.ifba.atividade08.controller.BankController;

/**
 *
 * @author gerviz
 */
public class account {

  //variaveis
  public int numConta;
  protected String tipo;
  private String dono;
  private Double saldo;
  private boolean status;

  public account(int numConta, String tipo, String dono, Double saldo, boolean status) {

    this.numConta = numConta;
    this.tipo = tipo;
    this.dono = dono;
    this.saldo = saldo;
    this.status = status;
  }

  public int getNumConta() {
    return numConta;
  }

  public void setNumConta(int numConta) {
    this.numConta = numConta;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public String getDono() {
    return dono;
  }

  public void setDono(String dono) {
    this.dono = dono;
  }

  public Double getSaldo() {
    return saldo;
  }

  public void setSaldo(Double saldo) {
    this.saldo = saldo;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public void openAccount() {
    this.status = true;
    if (this.tipo.equals("corrente")) {
      this.saldo = 50.00;
    } else {
      this.saldo = 150.00;
    }
  }

  public void closeAccount() {
    this.status = false;
  }

  public void deposit(double valor) {
    this.saldo += valor;
  }

  public void draw(double valor) {
    this.saldo  -= valor;
  }
}
