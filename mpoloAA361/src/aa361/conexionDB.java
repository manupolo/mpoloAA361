/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa361;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class conexionDB {
    Connection connection = null;
    private String bd = "aa361";
    private String host="localhost:3306";
    private String user = "root";
    private String pass = "popeye5";
    private String server = "jdbc:mysql://"+host+"/"+bd;
   
    public Connection conectarte (){
         Connection con = null;
     try {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(server, user, pass);
        System.out.println("Conectado");
     } catch (ClassNotFoundException ex){
         System.out.println("Otro error");
     } catch (SQLException ex) {
            ex.getSQLState();
       }
     return con;
    }
    
}
