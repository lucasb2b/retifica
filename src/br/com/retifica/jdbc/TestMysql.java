/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.retifica.jdbc;
import javax.swing.JOptionPane;

/**
 *
 * @author LUCAS
 */
public class TestMysql {

    public static void main(String[] args) {
        try {
            new ConnectionFactory().getConnection();
            JOptionPane.showMessageDialog(null, "Conexão estabelecida com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro:" + e);
        }
    }
}
