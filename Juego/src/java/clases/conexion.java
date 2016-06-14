/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author 201313875
 */
public class conexion {
    private String USERNAME="postgres";
    private String PASSWORD="123";
    private String HOST="localhost";
    private String PORT="5432";
    private String DATABASE="Juego";
    private String CLASSNAME="org.postgresql.Driver";
    private String URL= "jdbc:postgresql://"+HOST+":"+PORT+"/"+DATABASE;
    private Connection con;
    
    public conexion(){
        try{
            Class.forName(CLASSNAME);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e){
            System.err.println("Error"+ " "+e);
        } catch(SQLException e){
            System.err.println("Error"+ " "+e);
        }
    }
    
    public Connection getConexion(){
        return con;
    }
    public static void main(String[] args){
        conexion con = new conexion();
            }
}
