/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDatos;

import javax.swing.JOptionPane;

public class Servidor {
    private String ipServidor, usuario, contra, database, servidor, drivers, gestorBd, concatenacion;
    private int puerto;
    private boolean encriptacion, certificado;

        
    public Servidor(String ipSer,int puer, String usu,String cont, String db, String ser, String driv, String gestor, boolean encrip, boolean cert, String instac) {
        this.ipServidor = ipSer;
        this.usuario = usu;
        this.contra = cont;
        this.database = db;
        this.servidor = ser;
        this.drivers = driv;
        this.gestorBd = gestor;
        this.encriptacion = encrip;
        this.certificado = cert;
    }
    
    public Servidor(){
        this.ipServidor = "192.168.112.122";
        this.usuario = "sa";
        this.contra = "Gbd2022";
        this.database = "master";
        this.servidor = "";
        this.drivers = "";
        this.gestorBd = "";
        this.encriptacion = true;
        this.certificado = true;
    }
    
    public String getIpServidor() {
        return ipServidor;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContra() {
        return contra;
    }

    public String getDatabase() {
        return database;
    }

    public String getServidor() {
        return servidor;
    }

    public String getConcatenacion() {
        return concatenacion;
    }

    public int getPuerto() {
        return puerto;
    }
    
    public String toString(){
        return ipServidor + usuario + contra + database + servidor + drivers + gestorBd + concatenacion +puerto + encriptacion + certificado;
    }
    

}
