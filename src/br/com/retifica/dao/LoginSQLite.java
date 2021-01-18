/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.retifica.dao;

import br.com.retifica.jdbc.ConnectionSQLite;
import br.com.retifica.view.FrmLogin;
import br.com.retifica.view.FrmMenu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author LUCAS
 */
public class LoginSQLite {

    private Connection con;

    public LoginSQLite() {
        this.con = new ConnectionSQLite().getConnection();
    }

    public void login(String email, String password) {
        try {
            String sql = "SELECT * FROM `tb_user` where email = ? AND password = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Usuario logado

                //Administrador
                if (rs.getString("access_level").equals("admin")) {
                    JOptionPane.showMessageDialog(null, "Seja bem vindo ao Sistema");
                    FrmMenu tela = new FrmMenu();
                    tela.txtUser.setText(rs.getString("full_name"));
                    tela.txtID.setText(String.valueOf(rs.getInt("tb_retifica_idRetifica")));

                    tela.setVisible(true);
                } else {
                    //Dados incorretos
                    JOptionPane.showMessageDialog(null, "Dados incorretos!");
                    new FrmLogin().setVisible(true);

                }
                
                stmt.close();
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro : " + erro);
        }
    }
}
