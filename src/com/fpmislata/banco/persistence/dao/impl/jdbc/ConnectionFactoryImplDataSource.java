/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistence.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Dark
 */
public class ConnectionFactoryImplDataSource implements ConnectionFactory {
    
    
    
    @Override
    public Connection getConnection() {
                 
        try {
            InitialContext initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            DataSource dataSource = (DataSource) envCtx.lookup("jdbc/banco");
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
