/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistence.jdbc.impl;

import com.fpmislata.banco.persistence.jdbc.ConnectionFactory;
import com.fpmislata.banco.persistence.jdbc.DataSourceFactory;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Dark
 */
public class ConnectionFactoryImplDataSource implements ConnectionFactory {
    
    @Autowired
    DataSourceFactory dataSourceFactory;
    
    @Override
    public Connection getConnection() {
                 
        try {
            DataSource dataSource = dataSourceFactory.getDataSource();
            Connection connection= dataSource.getConnection();
            return connection;
        } catch (Exception ex) {
           throw new RuntimeException(ex);
        }
        
    }

    @Override
    public void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (Exception ex) {
          throw new RuntimeException(ex);
        }
    }

}
