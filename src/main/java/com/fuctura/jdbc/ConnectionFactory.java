/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fuctura.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Roberto Dantas
 */
public class ConnectionFactory {
    
    public Connection getConnection(){
        
        try {
            
            return DriverManager.getConnection("jdbc:postgresql://localhost/fucturadb","postgres","toor");
            
        } catch (Exception erro) {
            throw new RuntimeException(erro);
        }
            
    }
    
}
