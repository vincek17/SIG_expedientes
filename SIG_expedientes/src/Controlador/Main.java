package Controlador;


import Interfaces.LoginUser;


public class Main {

    public static void main(String[] args) {
       
        ControladorBD bd = new ControladorBD();
        //bd.AbrirConexion();
        
        ControladorClases cc = new ControladorClases();
        cc.AbrirLogin();
        
        
    }

}
