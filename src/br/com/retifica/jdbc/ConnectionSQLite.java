/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.retifica.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author LUCAS
 */
public class ConnectionSQLite {
    
    public Connection getConnection()  {
        try {
            String url = "jdbc:sqlite:C:\\Users\\LUCAS\\Documents\\NetBeansProjects\\Projeto Retifica\\src\\br\\com\\retifica\\database\\v8system.db";
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
