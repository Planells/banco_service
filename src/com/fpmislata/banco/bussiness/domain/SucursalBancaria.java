/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.bussiness.domain;

import java.util.Date;

/**
 *
 * @author German
 */
public class SucursalBancaria {
    
    private int idSucursalBancaria;
    private String nombre, codigoSucursal,direccion;
    private Date fechaCreacion;
    private EntidadBancaria entidadBancaria;

    public SucursalBancaria(int idSucursalBancaria, String nombre, String codigoSucursal, String direccion, Date fechaCreacion, EntidadBancaria entidadBancaria) {
        this.idSucursalBancaria = idSucursalBancaria;
        this.nombre = nombre;
        this.codigoSucursal = codigoSucursal;
        this.direccion = direccion;
        this.fechaCreacion = fechaCreacion;
        this.entidadBancaria = entidadBancaria;
    }

    public SucursalBancaria() {
    }

    public int getIdSucursalBancaria() {
        return idSucursalBancaria;
    }

    public void setIdSucursalBancaria(int idSucursalBancaria) {
        this.idSucursalBancaria = idSucursalBancaria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoSucursal() {
        return codigoSucursal;
    }

    public void setCodigoSucursal(String codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public EntidadBancaria getEntidadBancaria() {
        return entidadBancaria;
    }

    public void setEntidadBancaria(EntidadBancaria entidadBancaria) {
        this.entidadBancaria = entidadBancaria;
    }
    
    
    
    
}
