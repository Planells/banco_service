/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistence.jdbc;

import javax.sql.DataSource;

/**
 *
 * @author German
 */
public interface DataSourceFactory {
    
    DataSource getDataSource();
    
}
