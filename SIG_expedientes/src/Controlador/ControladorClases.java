package Controlador;

import Interfaces.GestionarTiposDeUsuarios;
import Interfaces.GestionarUsuarios;
import Interfaces.ICantidadDeAsignaciones;
import Interfaces.ICantidadDeDenunciasPorJuez;
import Interfaces.ICantidadDeDiasExpedientes;
import Interfaces.ICantidadDeJuecesPorGenero;
import Interfaces.IComparativoDeRendimiento;
import Interfaces.IExpedientesQueVenceran;
import Interfaces.LoginUser;
import Interfaces.MapaDeDenuncias;
import Interfaces.MenuPrincipal;
import Interfaces.PerfilDeColaboradores;
import Interfaces.PerfilDeColaboradoresParametros;
import Interfaces.PerfilDeJueces;
import Interfaces.PerfilDeJuecesParametros;
import Interfaces.RendimientoDeDepartamento;
import Interfaces.RendimientoDeExpedientes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kevin
 */
public class ControladorClases {
    
    
        public void AbrirLogin(){
           LoginUser abrir = new LoginUser();
            abrir.setVisible(true);
            abrir.setLocationRelativeTo(null);
        }
        
        public void AbrirMenuPrincipal(){
            MenuPrincipal abrir = new MenuPrincipal();
            abrir.setVisible(true);
            abrir.setLocationRelativeTo(null);
            
        }
        
        public void AbrirCantidadDeDiasExpedientes(){
            ICantidadDeDiasExpedientes abrir = new ICantidadDeDiasExpedientes();
            abrir.setVisible(true);
            abrir.setLocationRelativeTo(null);
        }
        
        public void AbrirCantidadDeDenunciasPorJuez(){
            ICantidadDeDenunciasPorJuez abrir = new ICantidadDeDenunciasPorJuez();
            abrir.setVisible(true);
            abrir.setLocationRelativeTo(null);
        }
        
        public void AbrirCantidadDeJuecesPorGenero(){
           ICantidadDeJuecesPorGenero abrir = new ICantidadDeJuecesPorGenero();
           abrir.setVisible(true);
           abrir.setLocationRelativeTo(null);
        }
        
        public void AbrirCantidadDeAsignaciones(){
           ICantidadDeAsignaciones abrir = new ICantidadDeAsignaciones();
           abrir.setVisible(true);
           abrir.setLocationRelativeTo(null);
        }
        
        public void AbrirExpedientesQueVenceran(){
            IExpedientesQueVenceran abrir = new IExpedientesQueVenceran();
            abrir.setVisible(true);
            abrir.setLocationRelativeTo(null);
        }
        
        public void AbrirComparativoDeRendimiento(){
            IComparativoDeRendimiento abrir = new IComparativoDeRendimiento();
            abrir.setVisible(true);
            abrir.setLocationRelativeTo(null);
        }
        
        public void AbrirMapaDeDenuncias(){
            MapaDeDenuncias abrir = new MapaDeDenuncias();
            abrir.setVisible(true);
            abrir.setLocationRelativeTo(null);
        }
        
        public void AbrirRendimientoDeDepartamento(){
            RendimientoDeDepartamento abrir = new RendimientoDeDepartamento();
            abrir.setVisible(true);
            abrir.setLocationRelativeTo(null);
        }
        
        public void AbrirRendimientoDeExpedientes(){
            RendimientoDeExpedientes abrir = new RendimientoDeExpedientes();
            abrir.setVisible(true);
            abrir.setLocationRelativeTo(null);
        }
        
        public void AbrirPerfilDeJueces(){
            PerfilDeJueces abrir = new PerfilDeJueces();
            abrir.setVisible(true);
            abrir.setLocationRelativeTo(null);
        }
        
        public void AbrirPerfilDeColaboradores(){
            PerfilDeColaboradores abrir = new PerfilDeColaboradores();
            abrir.setVisible(true);
            abrir.setLocationRelativeTo(null);
        }
        
        public void AbrirGestionarUsuarios(){
            GestionarUsuarios abrir = new GestionarUsuarios();
            abrir.setVisible(true);
            abrir.setLocationRelativeTo(null);
        }
        
        public void AbrirGestionarTiposDeUsuarios(){
            GestionarTiposDeUsuarios abrir = new GestionarTiposDeUsuarios();
            abrir.setVisible(true);
            abrir.setLocationRelativeTo(null);
        }
        
        public void AbrirPerfilDeJuecesParametros(){
            PerfilDeJuecesParametros abrir = new PerfilDeJuecesParametros();
            abrir.setVisible(true);
            abrir.setLocationRelativeTo(null);
        }
        
        public void AbrirPerfilDeColaboradoresParametros(){
            PerfilDeColaboradoresParametros abrir = new PerfilDeColaboradoresParametros();
            abrir.setVisible(true);
            abrir.setLocationRelativeTo(null);
        }
        
        public void Cerrar(){
           System.exit(0);
        }
        
    
}
