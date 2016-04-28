/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa361;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;

/**
 *
 * @author Usuario
 */
public class funciones {
    public void createEQUIPO(Connection con, String BDNombre) throws SQLException {
        String createString =   "create table " + BDNombre+".COCHES " +
                                "(MATRICULA varchar(8) NOT NULL," +
                                "MARCA varchar(40) NOT NULL," +
                                "MODELO varchar(40) NOT NULL," +
                                "COLOR varchar(20) NOT NULL," +
                                "ANIO integer NOT NULL," +
                                "PRECIO integer," +
                                "PRIMARY KEY (MATRICULA))";
        Statement stmt = null;
            try {
                stmt = con.createStatement();
                stmt.executeUpdate(createString);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                stmt.close();
            }
    }
    
    public static void cargaTablacoches(Connection con, String BDNombre, String archivo)
    throws SQLException{
        Statement stmt=null;
        try{
            stmt=con.createStatement();
            File fe=new File(archivo);
            FileReader fr = new FileReader(fe);
            BufferedReader br=new BufferedReader(fr);
            String s;
            while((s=br.readLine())!=null){
            StringTokenizer str;
            str=new StringTokenizer(s);
            String comando="Insert INTO" + BDNombre+ ".COCHES VALUES("
            +" ’ "+str.nextToken()+" ‘ " //MATRICULA
            +" ’ "+str.nextToken()+" ‘ " //MARCA
            +" ’ "+str.nextToken()+" ‘ " //MODELO
            +" ’ "+str.nextToken()+" ‘ " //COLOR
            +" ’ "+str.nextToken()+" ‘ " //AÑO
            +" ’ "+str.nextToken()+" ‘ " //PRECIO
            +")";
            stmt.executeUpdate(comando);
            }
            if(fr!=null) fr.close();
            }catch (EOFException eof) {
                System.out.println(" --------------------------");
            }catch (FileNotFoundException fnf) {
                System.err.println("Fichero no encontrado " + fnf);
            }catch(IOException e){
                System.err.println("Se ha producido una IOException");
            e.printStackTrace();
            }catch (Throwable e) {
                System.err.println("Error de programa: " + e);
            e.printStackTrace();
            }
            }

}
