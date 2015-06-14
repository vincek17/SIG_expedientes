/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

import Controlador.ControladorBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.lang.String;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Kevin
 */
public class Usuario {
 private int idusuario;
 private int idtipousuario;
 private String nombreusuario;
 private String clave;
 private int estadousuario;   
 private Connection cn;   
 private String[][] elementos;
 
 public Usuario(){
 }
 
 /*
 public void Usuario(int idusuario, int idtipousuario, String nombreusuario, String clave, int estadousuario){
  this.idusuario = idusuario;
  this.idtipousuario = idtipousuario;
  this.nombreusuario = nombreusuario;
  this.clave = clave;
  this.estadousuario = estadousuario;
 }*/

    /**
     * @return the idusuario
     */
    public int getIdusuario() {
        return idusuario;
    }

    /**
     * @param idusuario the idusuario to set
     */
    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    /**
     * @return the idtipousuario
     */
    public int getIdtipousuario() {
        return idtipousuario;
    }

    /**
     * @param idtipousuario the idtipousuario to set
     */
    public void setIdtipousuario(int idtipousuario) {
        this.idtipousuario = idtipousuario;
    }

    /**
     * @return the nombreusuario
     */
    public String getNombreusuario() {
        return nombreusuario;
    }

    /**
     * @param nombreusuario the nombreusuario to set
     */
    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @return the estadousuario
     */
    public int getEstadousuario() {
        return estadousuario;
    }

    /**
     * @param estadousuario the estadousuario to set
     */
    public void setEstadousuario(int estadousuario) {
        this.estadousuario = estadousuario;
    }
    
    public boolean NuevoUsuario(){
        ControladorBD con = new ControladorBD();
        cn = con.AbrirConexion();   
        boolean resp = false;
        try{
            String sql = "INSERT INTO USUARIO(IDTIPOUSUARIO, NOMBREUSUARIO, CLAVE, ESTADOUSUARIO) VALUES(? ,? ,? ,?)";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setInt(1,idtipousuario);
            cmd.setString(2,nombreusuario);
            cmd.setString(3,clave);
            cmd.setInt(4,estadousuario);
            if(!cmd.execute()){
                resp = true;
            }
            cmd.close();
            cn.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
     return resp;
    }
    
    
//    public String[][] consultarUsuario(){
//        ControladorBD con = new ControladorBD();
//        cn = con.AbrirConexion();
//        int contador = 0;
//        boolean resp = false;
//        
//        try{
//            String sql = "SELECT * FROM USUARIO";
//            PreparedStatement cmd = cn.prepareStatement(sql);
//            //cmd.setInt(1, idusuario); si fuera ?
//            ResultSet rs = cmd.executeQuery();
//            int filas =rs.getRow();
//            elementos = new String[filas][5];
//            while(rs.next()){
//                resp = true;
//                elementos[contador][1] = String.valueOf(rs.getInt(1));
//                elementos[contador][2] = String.valueOf(rs.getInt(2));
//                elementos[contador][3] = rs.getString(3);
//                elementos[contador][4] = rs.getString(4);
//                elementos[contador][5] = String.valueOf(rs.getInt(5));
//                contador++;
//            }
//            cmd.close();
//            cn.close();
//            
//        }catch(Exception ex){
//            JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage());
//        }
//        return elementos;
//    }

    public TableModel consultarUsuario(){
        
        ControladorBD con = new ControladorBD();
        cn = con.AbrirConexion();
        DefaultTableModel TablaUsuarios = new DefaultTableModel();
        try {
            TablaUsuarios.addColumn("IDUSUARIO");
            TablaUsuarios.addColumn("IDTIPOUSUARIO");
            TablaUsuarios.addColumn("NOMBREUSUARIO");
            TablaUsuarios.addColumn("CLAVE");
            TablaUsuarios.addColumn("ESTADOUSUARIO");          
            String sql = "SELECT * FROM USUARIO";
            PreparedStatement cmd = cn.prepareStatement(sql);
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Object dato[] = new Object[TablaUsuarios.getColumnCount()];//antes era 5
                for (int i = 0; i < TablaUsuarios.getColumnCount(); i++) {
                    dato[i] = rs.getString(i + 1);
                }
                TablaUsuarios.addRow(dato);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }

        return TablaUsuarios;
    }
    
public TableModel consultarUsuario(String usuario, String clave){
        
        ControladorBD con = new ControladorBD();
        cn = con.AbrirConexion();
        DefaultTableModel TablaUsuarios = new DefaultTableModel();
        try {
            TablaUsuarios.addColumn("IDUSUARIO");
            TablaUsuarios.addColumn("IDTIPOUSUARIO");
            TablaUsuarios.addColumn("NOMBREUSUARIO");
            TablaUsuarios.addColumn("CLAVE");
            TablaUsuarios.addColumn("ESTADOUSUARIO");          
            String sql = "SELECT * FROM USUARIO WHERE NOMBREUSUARIO='"+usuario+"' AND CLAVE='"+clave+"'";
            PreparedStatement cmd = cn.prepareStatement(sql);
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Object dato[] = new Object[TablaUsuarios.getColumnCount()];//antes era 5
                for (int i = 0; i < TablaUsuarios.getColumnCount(); i++) {
                    dato[i] = rs.getString(i + 1);
                }
                TablaUsuarios.addRow(dato);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }

        return TablaUsuarios;
    }    
    
    /**
     * @return the lista
     */
}
