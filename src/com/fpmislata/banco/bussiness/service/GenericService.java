/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.bussiness.service;

import java.util.List;

/**
 *
 * @author German
 */
public interface GenericService<T> {
    
    T get(int id);
    boolean delete(int id);
    T insert(T t);
    T update(T t);
    List<T> findAll();
    
}