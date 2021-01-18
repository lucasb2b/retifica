/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.retifica.dao;

import br.com.retifica.jdbc.ConnectionSQLite;
import br.com.retifica.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author LUCAS
 */
public class UserDAO {

    private Connection con;

    public UserDAO() {
        this.con = new ConnectionSQLite().getConnection();
    }

    public void insertUser(User obj) {
        try {
            String sql = "INSERT INTO tb_user( full_name, email, password, join_date, access_level, tb_retifica_idRetifica) "
                    + "VALUES (?,?,?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getFullName());
            stmt.setString(2, obj.getEmail());
            stmt.setString(3, obj.getPassword());
            stmt.setString(4, String.valueOf(obj.getJoinDate()));
            stmt.setString(5, obj.getAccessLevel());
            stmt.setInt(6, obj.getTbRetificaIdRetifica());
            stmt.executeUpdate();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Adicionado com sucesso");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }

    public List<User> showUser() {
        try {
            List<User> list = new ArrayList<>();

            String sql = "SELECT * FROM tb_user";
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                User obj = new User();

                obj.setIdUser(rs.getInt("idUser"));
                obj.setFullName(rs.getString("full_name"));
                obj.setEmail(rs.getString("email"));
                obj.setPassword(rs.getString("password"));
                obj.setJoinDate(rs.getString("join_date"));
                obj.setAccessLevel(rs.getString("access_level"));
                obj.setSituation_user(rs.getString("situation_user"));
                obj.setTbRetificaIdRetifica(rs.getInt("tb_retifica_idRetifica"));

                list.add(obj);
            }
            return list;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }
}
