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
public class MoneyPayment implements paymentInterface {
     private double valor;
    public double calcularTotal(double valor){
        double desconto = valor * 0.10;
        return valor - desconto;
         }
    
    public void imprimirRecibo(String nome, String data, double valor, double valorFinal) {
    String recibo = """
        ===== Recibo de Pagamento (Dinheiro) =====
        Cliente: %s
        Data : %s
        Valor do Produto: R$ %.2f
        Desconto: 10%%
        Valor Final: R$ %.2f
        ==========================================
        """.formatted(nome, data, valor, valorFinal);

    JOptionPane.showMessageDialog(null, recibo, "Recibo", JOptionPane.INFORMATION_MESSAGE);
}
    
}
