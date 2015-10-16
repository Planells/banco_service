/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistence.dao;

import com.fpmislata.banco.bussiness.domain.EntidadBancaria;
import java.util.List;



/**
 *
 * @author Dark
 */
public interface EntidadBancariaDAO extends GenericDAO<EntidadBancaria> {
    List<EntidadBancaria> findByNombre(String nombre);
}
