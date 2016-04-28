/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa361;

import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class test {
    public static void main(String[] args) throws SQLException{
        conexionDB c = new conexionDB();
        funciones f = new funciones();
        
        c.conectarte(); 
        f.createEQUIPO(c.conectarte(), "aa361");
        f.cargaTablacoches(c.conectarte(), "aa361", "e01.txt");
    }
    
}
