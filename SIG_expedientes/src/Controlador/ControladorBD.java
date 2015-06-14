package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kevin
 */
public class ControladorBD {
    
    //protected String serverName = null;
    //protected String tcpip = null;
    Connection cn = null;
    
    public Connection AbrirConexion(){
        
            try{
                
                //serverName = JOptionPane.showInputDialog("Ingrese su ServerName");
                //tcpip = JOptionPane.showInputDialog("Ingrese su TCPIP");
                String url = "jdbc:sqlserver://"+VariablesGlobales.serverName+":"+VariablesGlobales.tcpip+";database=BDSIGCSJ;integratedSecurity=true;";
                //JOptionPane.showMessageDialog(null, url);
                //String url = "jdbc:sqlserver://localhost;databaseName=BDSIGCSJ;user=sig;password=sig1152015;";
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                cn = DriverManager.getConnection(url);
                JOptionPane.showMessageDialog(null, "Conexion con la base de datos establecida");
                
                //String url = "jdbc:sqlserver://Jbeltran\\sqlexpress:49157;database=Expedientes;integratedSecurity=true;";
                //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                //con = DriverManager.getConnection(url);
                //System.out.println("Conexion a la BD");
                
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "ERRROR: "+e.getMessage());
            }
            return cn;
    }
    
   public Connection CerrarConexion(Connection cn){
        try {
            cn.close();
            return cn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRROR: "+e.getMessage());
            return cn;
        }
    }
    
}


