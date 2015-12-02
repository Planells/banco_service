/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.security.impl;

import com.fpmislata.banco.bussiness.domain.Usuario;
import com.fpmislata.banco.security.Authorization;

/**
 *
 * @author German
 */
public class AuthorizationImpDummy implements Authorization {


    @Override
    public boolean isAuthorizedURL(Usuario usuario, String url, String metodo) {
        if(url == "/banco_api/api/login" ){
         return true;
        }else{
         return true;
        }
    }
}
