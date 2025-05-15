/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package br.com.ifba.atividade09.paymentMethods;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author gerviz
 */
public class PagamentoCartaoTest {
  
  public PagamentoCartaoTest() {
  }

  @org.junit.jupiter.api.BeforeAll
  public static void setUpClass() throws Exception {
  }

  @org.junit.jupiter.api.AfterAll
  public static void tearDownClass() throws Exception {
  }

  @org.junit.jupiter.api.BeforeEach
  public void setUp() throws Exception {
  }

  @org.junit.jupiter.api.AfterEach
  public void tearDown() throws Exception {
  }
  
  @BeforeAll
  public static void setUpClass() {
  }
  
  @AfterAll
  public static void tearDownClass() {
  }
  
  @BeforeEach
  public void setUp() {
  }
  
  @AfterEach
  public void tearDown() {
  }

  /**
   * Test of calcularTotal method, of class CardPayment.
   */
  @org.junit.jupiter.api.Test
  public void testCalcularTotal() {
    System.out.println("calcularTotal");
    double valor = 0.0;
    CardPayment instance = new CardPayment();
    double expResult = 0.0;
    double result = instance.calcularTotal(valor);
    assertEquals(expResult, result, 0);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of imprimirRecibo method, of class CardPayment.
   */
  @org.junit.jupiter.api.Test
  public void testImprimirRecibo() {
    System.out.println("imprimirRecibo");
    String nome = "";
    String data = "";
    double valor = 0.0;
    double valorFinal = 0.0;
    CardPayment instance = new CardPayment();
    instance.imprimirRecibo(nome, data, valor, valorFinal);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }
  
}
