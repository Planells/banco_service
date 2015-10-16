/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.bussiness.service.impl;


import com.fpmislata.banco.bussiness.service.GenericService;

import com.fpmislata.banco.persistence.dao.GenericDAO;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author German
 */
public class GenericServiceImpl<T> implements GenericService<T> {
    @Autowired
    GenericDAO<T> genericDAO;
    
    @Override
    public T get(int id) {
          return genericDAO.get(id);
    }

    @Override
    public boolean delete(int id) {
        return genericDAO.delete(id);
    }

    @Override
    public T insert(T t) {
        return genericDAO.insert(t);
    }

    @Override
    public T update(T t) {
         return genericDAO.update(t);
    }

    @Override
    public List<T> findAll() {
         return genericDAO.findAll();
    }

    
    
    
    
}
