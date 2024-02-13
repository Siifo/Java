package com.siifo.siifo.model;


public class Credenciales {
    private String correo;
    private String pass;
    
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public Credenciales(String correo, String pass) {
        this.correo = correo;
        this.pass = pass;
    }

    public Credenciales() {
        
    }
}
