/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.retifica.dao;

import br.com.retifica.jdbc.ConnectionSQLite;
import br.com.retifica.model.Retifica;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author LUCAS
 */
public class RetificaDAO {

    private Connection con;

    public RetificaDAO() {
        this.con = new ConnectionSQLite().getConnection();
    }

    public Retifica findRetifica(int idRetifica) {

        try {
            // Criar o sql, organizar e executar
            String sql = "SELECT * FROM tb_retifica WHERE idRetifica = ? GROUP BY idRetifica";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idRetifica);

            ResultSet rs = stmt.executeQuery();
            Retifica retifica = new Retifica();

            if (rs.next()) {
                retifica.setIdRetifica(rs.getInt("idRetifica"));
                retifica.setFantasyName(rs.getString("fantasy_name"));
                retifica.setCompanyName(rs.getString("company_name"));
                retifica.setCnpj(rs.getString("cnpj"));
                retifica.setIe(rs.getString("ie"));
                retifica.setTel(rs.getString("tel"));
                retifica.setTel2(rs.getString("tel2"));
                retifica.setTel3(rs.getString("tel3"));
                retifica.setStreet(rs.getString("street"));
                retifica.setNumber(rs.getString("number"));
                retifica.setDistrict(rs.getString("district"));
                retifica.setZipCode(rs.getString("zip_code"));
                retifica.setState(rs.getString("state"));
                retifica.setCity(rs.getString("city"));
                retifica.setSituationRetifica(rs.getString("situation_retifica"));
            }
            stmt.close();
            return retifica;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Retífica não encontrada!" + e);
            return null;
        }
    }

    public void updateRetifica(Retifica obj) {
        try {
            String sql = "UPDATE tb_retifica SET fantasy_name=?, company_name=?, cnpj=?, ie=?, tel=?, tel2=?, tel3=?, "
                    + "street=?, number=?, district=?, zip_code=?, state=?, city=? WHERE idRetifica=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getFantasyName());
            stmt.setString(2, obj.getCompanyName());
            stmt.setString(3, obj.getCnpj());
            stmt.setString(4, obj.getIe());
            stmt.setString(5, obj.getTel());
            stmt.setString(6, obj.getTel2());
            stmt.setString(7, obj.getTel3());
            stmt.setString(8, obj.getStreet());
            stmt.setString(9, obj.getNumber());
            stmt.setString(10, obj.getDistrict());
            stmt.setString(11, obj.getZipCode());
            stmt.setString(12, obj.getState());
            stmt.setString(13, obj.getCity());
            stmt.setInt(14, obj.getIdRetifica());

            stmt.executeUpdate();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel alterar a retífica");
            System.out.println(e);
        }
    }
}
