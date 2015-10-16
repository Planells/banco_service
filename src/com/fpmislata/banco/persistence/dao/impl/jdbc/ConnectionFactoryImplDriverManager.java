/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistence.dao.impl.jdbc;

import java.sql.*;

/**
 *
 * @author Dark
 */
public class ConnectionFactoryImplDriverManager implements ConnectionFactory {

    @Override
    public Connection getConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver"); 
            Connection connection;
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "banco", "banco");
            return connection;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public void closeConnection(Connection connection) {
    }

}
