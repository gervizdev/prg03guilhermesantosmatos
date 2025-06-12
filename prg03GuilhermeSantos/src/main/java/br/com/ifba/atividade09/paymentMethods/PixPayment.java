/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade09.paymentMethods;

import br.com.ifba.atividade09.interfaces.paymentInterface;
import javax.swing.JOptionPane;

/**
 *
 * @author gerviz
 */
//calcula, cria e imprime o recibo referente ao metodo de pagamento
public class PixPayment implements paymentInterface {

  private double valor;

  public double calcularTotal(double valor) {
    double cashback = valor * 0.02;
    return valor - cashback;
  }

  public void imprimirRecibo(String nome, String data, double valor, double valorFinal) {
    String recibo = """
            ===== Recibo de Pagamento (Pix) =====
            Cliente: %s
            Data da Compra: %s
            Valor do Produto: R$ %.2f
            Cashback: 2%%
            Valor Final: R$ %.2f
            =====================================
            """.formatted(nome, data, valor, valorFinal);

    JOptionPane.showMessageDialog(null, recibo, "Recibo", JOptionPane.INFORMATION_MESSAGE);
  }
}
