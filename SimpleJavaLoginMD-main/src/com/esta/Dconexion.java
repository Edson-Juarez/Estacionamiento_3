/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Leandro
 */
public class Dconexion {
    private static Connection con;
    //DECLARAMOS LOS DATOS DE CONEXION A LA BD
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String pass = "1234";
    private static final String url = "jdbc:mysql://localhost:3306/estacion";

    public static Connection getConnection() {
        con = null;
        try {
            Class.forName(driver);
            con= (Connection) DriverManager.getConnection(url,user,pass);
            
            if(con!=null){
            System.out.println("Conexion establecida");
            }
        }
        catch (ClassNotFoundException | SQLException e){
          System.out.println("Error de conexion" + e );  
        }
        return con;
    }
   
}

