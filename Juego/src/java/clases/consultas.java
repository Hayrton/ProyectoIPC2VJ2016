/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.PreparedStatement;
import java.sql.ResultSet;



/**
 *
 * @author Davidd
 */
public class consultas extends conexion{
    
    public boolean autentication(String usuario, String contrasena){
        PreparedStatement pr = null;
        ResultSet rs = null;
        
        try {
            String consulta = "SELECT * FROM login where usuario=? and contrasena=?";
            pr = getConexion().prepareStatement(consulta);
            pr.setString(1, usuario);
            pr.setString(2, contrasena);
            rs = pr.executeQuery();
            
            if(rs.absolute(1)){
                return true;
            }
        }catch(Exception e){
            System.err.println("Error1 "+e);
        }finally{
            try{
                if(getConexion() != null) getConexion().close();
                if(pr != null)pr.close();
                if(rs != null)rs.close();
            } catch(Exception e){
               System.err.println("Error "+e); 
            }
        }
        return false;
    }
    
    public static void main(String[] args){
        consultas co = new consultas();
        System.out.println(co.autentication("Admin1", "12345"));
    }
}
