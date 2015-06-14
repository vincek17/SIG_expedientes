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
public class Juez {

    private int idjuez;
    private String nombrejuez;
    private String apellidojuez;
    private String genero;
    private String titulo;
    private static int idjueSeleccionado;
    private Connection cn;
    
    public Juez(){
        
    }

    /**
     * @return the idjuez
     */
    public int getIdjuez() {
        return idjuez;
    }

    /**
     * @param idjuez the idjuez to set
     */
    public void setIdjuez(int idjuez) {
        this.idjuez = idjuez;
    }

    /**
     * @return the nombrejuez
     */
    public String getNombrejuez() {
        return nombrejuez;
    }

    /**
     * @param nombrejuez the nombrejuez to set
     */
    public void setNombrejuez(String nombrejuez) {
        this.nombrejuez = nombrejuez;
    }

    /**
     * @return the apellidojuez
     */
    public String getApellidojuez() {
        return apellidojuez;
    }

    /**
     * @param apellidojuez the apellidojuez to set
     */
    public void setApellidojuez(String apellidojuez) {
        this.apellidojuez = apellidojuez;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    /**
     * @return the idjueSeleccionado
     */
    public static int getIdjueSeleccionado() {
        return idjueSeleccionado;
    }

    /**
     * @param aIdjueSeleccionado the idjueSeleccionado to set
     */
    public static void setIdjueSeleccionado(int aIdjueSeleccionado) {
        idjueSeleccionado = aIdjueSeleccionado;
        
    }    
    
     public TableModel consultarJuez(){
        
        ControladorBD con = new ControladorBD();
        cn = con.AbrirConexion();
        DefaultTableModel TablaJuez = new DefaultTableModel();
        try {
            TablaJuez.addColumn("IDJUEZ");
            TablaJuez.addColumn("IDDEPENDENCIA");
            TablaJuez.addColumn("NOMBREJUEZ");
            TablaJuez.addColumn("APELLIDOJUEZ");
            TablaJuez.addColumn("GENERO");          
            TablaJuez.addColumn("TITULO");          
            String sql = "SELECT * FROM JUEZ";
            PreparedStatement cmd = cn.prepareStatement(sql);
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Object dato[] = new Object[TablaJuez.getColumnCount()];//antes era 5
                for (int i = 0; i < TablaJuez.getColumnCount(); i++) {
                    dato[i] = rs.getString(i + 1);
                }
                TablaJuez.addRow(dato);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }

        return TablaJuez;
    }
     
     public ArrayList consultarJuez(int id){
        
        ControladorBD con = new ControladorBD();
        cn = con.AbrirConexion();
        ArrayList dato = new ArrayList();
        try {           
            String sql = "SQL";
            PreparedStatement cmd = cn.prepareStatement(sql);
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                dato.add(rs.getString(1));//mod
                dato.add(rs.getString(2));
                dato.add(rs.getString(3));
                dato.add(rs.getString(4));
                dato.add(rs.getString(5));
                dato.add(rs.getString(6));
                dato.add(rs.getString(7));
                dato.add(rs.getString(8));
                dato.add(rs.getString(9));
             //   dato.add(rs.getString(10));
             //   dato.add(rs.getString(11));
             //   dato.add(rs.getString(12));
             //   dato.add(rs.getString(13));
             //   dato.add(rs.getString(14));
            }
         } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return dato;
    }
}