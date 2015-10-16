/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.bussiness.service.impl;

import com.fpmislata.banco.bussiness.domain.EntidadBancaria;
import com.fpmislata.banco.bussiness.service.EntidadBancariaService;
import com.fpmislata.banco.persistence.dao.EntidadBancariaDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Dark
 */
public class EntidadBancariaServiceImpl extends GenericServiceImpl<EntidadBancaria> implements EntidadBancariaService {
    @Autowired
    EntidadBancariaDAO entidadBancariaDAO;



    @Override
    public List<EntidadBancaria> findByNombre(String nombre) {
         return entidadBancariaDAO.findByNombre(nombre);
    }
    
    
    
}
