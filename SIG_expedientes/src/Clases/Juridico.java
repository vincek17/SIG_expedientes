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
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author FlordeMaria
 */
public class Juridico {



    private int idjuridico;
    private String nombrejuridico;
    private String apelidojuridico;
    private Connection cn;
    private static int IdJuridicoSeleccionado;
    
    
    void Juridico(){
        
    }
  
        /**
     * @return the IdJuridicoSeleccionado
     */
    public static int getIdJuridicoSeleccionado() {
        return IdJuridicoSeleccionado;
    }

    /**
     * @param aIdJuridicoSeleccionado the IdJuridicoSeleccionado to set
     */
    public static void setIdJuridicoSeleccionado(int aIdJuridicoSeleccionado) {
        IdJuridicoSeleccionado = aIdJuridicoSeleccionado;
    }
    
         public TableModel consultarJuridico(){
        
        ControladorBD con = new ControladorBD();
        cn = con.AbrirConexion();
        DefaultTableModel TablaJuridico = new DefaultTableModel();
        try {
            TablaJuridico.addColumn("IDJURIDICO");
            TablaJuridico.addColumn("NOMBREJURIDIO");
            TablaJuridico.addColumn("APELLIDOJURIDICO");   
            String sql = "SELECT * FROM JURIDICO";
            PreparedStatement cmd = cn.prepareStatement(sql);
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Object dato[] = new Object[TablaJuridico.getColumnCount()];//antes era 5
                for (int i = 0; i < TablaJuridico.getColumnCount(); i++) {
                    dato[i] = rs.getString(i + 1);
                }
                TablaJuridico.addRow(dato);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }

        return TablaJuridico;
    }
    
         
       public ArrayList consultarJuridico(int id){
        
        ControladorBD con = new ControladorBD();
        cn = con.AbrirConexion();
        ArrayList dato2 = new ArrayList();
        try {           
            String sql = "EXECUTE PerfilDeJuridico "+ id;
            PreparedStatement cmd = cn.prepareStatement(sql);
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                dato2.add(rs.getString(1));
                dato2.add(rs.getString(2));
                dato2.add(rs.getString(3));
                dato2.add(rs.getString(4));
                dato2.add(rs.getString(5));
   
            }
         } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return dato2;
    }
         
}
