/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.afip.dgi.agencia66.util.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConectarMultiBases {
    
    private Connection conectar;
    
public void conectarSqlite(String baseDeDatos) {
    try {
        System.out.println("Entre al codigo: " +baseDeDatos);
        conectar = DriverManager.getConnection("jdbc:sqlite:"+baseDeDatos);
        if(conectar != null) {
            System.out.println("Conectado a Sqlite");
        }
    } catch(SQLException sql) {
        System.err.println("No se pudo conectar\n" +sql);
    }
}    

public void setConeccion(Connection con) {
    conectar = con;
}

public Connection getConection() {
    return conectar;
}
    
    
}
