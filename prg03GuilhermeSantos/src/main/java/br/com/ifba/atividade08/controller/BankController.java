/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade08.controller;

import br.com.ifba.atividade08.accountController.account;
import java.util.ArrayList;

/**
 *
 * @author gerviz
 */
public class BankController {

  public static ArrayList<account> contas = new ArrayList<>();

  public static void adicionarConta(account c) {
    contas.add(c);
  }
  
  public static void removerConta(account c){
  contas.remove(c);
  }
}
