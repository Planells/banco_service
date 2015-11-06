/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.security;


import com.fpmislata.banco.bussiness.domain.Usuario;

/**
 *
 * @author German
 */
public interface Authorization {
    
    boolean isAuthorizedURL(Usuario usuario, String url);
    
}
