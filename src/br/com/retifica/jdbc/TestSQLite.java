/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.retifica.jdbc;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 *
 * @author LUCAS
 */
public class TestSQLite {
    public static void main(String[] args) {
        try {
            new ConnectionSQLite().getConnection();
            JOptionPane.showMessageDialog(null, "conexão estabelecida com sucesso");
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro: "+e);
        }
    }
}
