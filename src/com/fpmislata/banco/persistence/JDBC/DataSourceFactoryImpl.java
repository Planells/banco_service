/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistence.JDBC;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author German
 */
public class DataSourceFactoryImpl implements DataSourceFactory {

    @Override
    public DataSource getDataSource() {
        try {
            InitialContext initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            DataSource dataSource = (DataSource) envCtx.lookup("jdbc/MySQLDS");            
            return dataSource;
        } catch (Exception ex) {
           throw new RuntimeException(ex);
        }
    }
    
    
    
}
