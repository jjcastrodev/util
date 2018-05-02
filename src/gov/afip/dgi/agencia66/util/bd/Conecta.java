/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.afip.dgi.agencia66.util.bd;

/**
 *
 * @author u84062
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;



/**
 *
 * @author u84062
 */
public class Conecta {

String url;
public Connection conectar;

    public Conecta() {
        System.out.println("En Constructor!");
        //this.url = "//C:/reca.db"; //Base de Prueba
        // ANDA --this.url = "//C:inetpub/wwwroot/recaudacion/data/recaudacion.db";
        //this.url = "//C:inetpub/wwwroot/admin/data/admindgi.db";
        this.url = "//C:inetpub/wwwroot/varios/varios.db";
    }
        
    

public void conectarSqlite() {

    conectarSqlite(url);
}

public void conectarSqlite(String baseDeDatos) {
    try {
        System.out.println("Entre al codigo con: " +baseDeDatos);
        conectar = DriverManager.getConnection("jdbc:sqlite:"+baseDeDatos);
        
        if(conectar != null) {
            System.out.println("Conectado a Sqlite");
        }
    } catch(SQLException sql) {
        System.err.println("No se pudo conectar\n" +sql);
    }
}

public void cierraBase() {
    try {
        conectar.close();
    } catch (SQLException sql) {
        System.err.println("No se pudo cerrar\n");
    }
}
    
}
