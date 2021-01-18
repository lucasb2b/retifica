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
public class ConnectionFactory {
    
    public Connection getConnection() throws ClassNotFoundException {
       try{
           String url = "jdbc:mysql://127.0.0.1:3306/v8system";
           String user = "root";
           String password = "";
           return DriverManager.getConnection(url, user, password);
       } catch (SQLException e){
           throw new RuntimeException(e);
       }
    }
}
