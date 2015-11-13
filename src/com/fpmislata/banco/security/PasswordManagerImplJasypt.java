/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.security;

import org.jasypt.util.password.StrongPasswordEncryptor;

/**
 *
 * @author German
 */
public class PasswordManagerImplJasypt implements PasswordManager {
     private StrongPasswordEncryptor strongPasswordEncryptor = new StrongPasswordEncryptor();
     
    @Override
    public String encrypt(String password) {
        
        String encryptedPassword = strongPasswordEncryptor.encryptPassword(password);
        return encryptedPassword;
    }

    @Override
    public boolean check(String password, String encrypt) {
        
        if (strongPasswordEncryptor.checkPassword(password, encrypt)) {
            return true;
        } else {
            return false;
        }
    }

}
