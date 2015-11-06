/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.bussiness.domain;

/**
 *
 * @author German
 */

public class Usuario {
    private int idUsuario;
    private String name,passwordEncrypt;
    private Rol rol;

    public Usuario() {
    }

    public Usuario(int idUsuario, String name, String passwordEncrypt, Rol rol) {
        this.idUsuario = idUsuario;
        this.name = name;
        this.passwordEncrypt = passwordEncrypt;
        this.rol = rol;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswordEncrypt() {
        return passwordEncrypt;
    }

    public void setPasswordEncrypt(String passwordEncrypt) {
        this.passwordEncrypt = passwordEncrypt;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    
    
    
}
