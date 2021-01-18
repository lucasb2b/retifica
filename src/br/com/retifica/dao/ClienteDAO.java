/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.retifica.dao;

import br.com.projeto.model.WebServiceCep;
import br.com.retifica.jdbc.ConnectionSQLite;
import br.com.retifica.model.Cliente;
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
public class ClienteDAO {

    private Connection con;

    public ClienteDAO() {
        this.con = new ConnectionSQLite().getConnection();
    }

    public void insertClient(Cliente obj) {
        try {

            String sql = "INSERT INTO tb_client(full_name, cpf, rg, tel, tel2, street, number, district, zip_code, state, city, tb_retifica_idRetifica) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getFullName());
            stmt.setString(2, obj.getCpf());
            stmt.setString(3, obj.getRg());
            stmt.setString(4, obj.getTel());
            stmt.setString(5, obj.getTel2());
            stmt.setString(6, obj.getStreet());
            stmt.setString(7, obj.getNumber());
            stmt.setString(8, obj.getDistrict());
            stmt.setString(9, obj.getZipCode());
            stmt.setString(10, obj.getState());
            stmt.setString(11, obj.getCity());
            stmt.setInt(12, obj.getTbRetificaIdRetifica());

            stmt.executeUpdate();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cliente cadastrado com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }

    public List<Cliente> showClient() {
        try {
            List<Cliente> list = new ArrayList<>();

            String sql = "SELECT * FROM tb_client";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente obj = new Cliente();

                obj.setIdClient(rs.getInt("idClient"));
                obj.setFullName(rs.getString("full_name"));
                obj.setCpf(rs.getString("cpf"));
                obj.setRg(rs.getString("rg"));
                obj.setTel(rs.getString("tel"));
                obj.setTel2(rs.getString("tel2"));
                obj.setStreet(rs.getString("street"));
                obj.setNumber(rs.getString("number"));
                obj.setDistrict(rs.getString("district"));
                obj.setZipCode(rs.getString("zip_code"));
                obj.setState(rs.getString("state"));
                obj.setCity(rs.getString("city"));
                obj.setSituationClient(rs.getString("situation_client"));
                obj.setTbRetificaIdRetifica(rs.getInt("tb_retifica_idRetifica"));

                list.add(obj);
            }

            return list;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }

    }

    public void updateClient(Cliente obj) {
        try {
            String sql = "UPDATE tb_client SET full_name=?, "
                    + "cpf = ?, "
                    + "rg = ?, "
                    + "tel = ?, tel2 = ?, "
                    + "street = ?, "
                    + "number = ?, "
                    + "district = ?, "
                    + "zip_code = ?, "
                    + "state = ?, "
                    + "city = ? "
                    + "WHERE idClient = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getFullName());
            stmt.setString(2, obj.getCpf());
            stmt.setString(3, obj.getRg());
            stmt.setString(4, obj.getTel());
            stmt.setString(5, obj.getTel2());
            stmt.setString(6, obj.getStreet());
            stmt.setString(7, obj.getNumber());
            stmt.setString(8, obj.getDistrict());
            stmt.setString(9, obj.getZipCode());
            stmt.setString(10, obj.getState());
            stmt.setString(11, obj.getCity());
            stmt.setInt(12, obj.getIdClient());
            stmt.executeUpdate();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }
    }

    public void deleteClient(Cliente obj) {
        try {
            String sql = "DELETE FROM tb_client WHERE idClient = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getIdClient());
            stmt.executeUpdate();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Excluído com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }
    }

    public Cliente buscaCep(String cep) {

        WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);

        Cliente obj = new Cliente();

        if (webServiceCep.wasSuccessful()) {
            obj.setStreet(webServiceCep.getLogradouroFull());
            obj.setCity(webServiceCep.getCidade());
            obj.setDistrict(webServiceCep.getBairro());
            obj.setState(webServiceCep.getUf());

            return obj;
        } else {
            JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());
            JOptionPane.showMessageDialog(null, "Descrição do erro: " + webServiceCep.getResultText());
            return null;
        }

    }
}
