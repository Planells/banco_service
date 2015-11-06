/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.presentacion;


import com.fpmislata.banco.bussiness.service.EntidadBancariaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 *
 * @author Dark
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    
    @Autowired
        EntidadBancariaService entidadBancariaService;
    
    public Main() {
        ApplicationContext applicationContext =new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        
        applicationContext.getAutowireCapableBeanFactory().autowireBean(this);
        
        System.out.println(entidadBancariaService.get(1).getNombre());
    }

    public static void main(String[] args) {
         
        new Main();
        
        
        
        
//        EntidadBancariaService entidadBancariaService=applicationContext.getBean(EntidadBancariaService.class);
        
        
      
        
        
        
        
//        try {
//            Statement statement = conexion.createStatement();
//            statement.executeUpdate("Insert into EntidadBancaria (nombre,codigoEntidad,fechaCreacion,direccion,CIF) Values ('la caixa','336','2015-09-23','calle paco','34')" );
//
//            
//        } catch (SQLException ex) {
//            System.out.println(ex.toString());
//            
//        }
//        try {
//            PreparedStatement preparedStatement = conexion.prepareStatement("UPDATE EntidadBancaria SET nombre = ?, codigoEntidad = ?, fechaCreacion= ?, direccion= ?, CIF= ? where idEntidadBancaria=1");
//            preparedStatement.setString(1, "banco1");
//            preparedStatement.setString(2, "339");
//            preparedStatement.setString(3, "2015-09-23");
//            preparedStatement.setString(4, "calle numero 2");
//            preparedStatement.setString(5, "42");
//            
//            preparedStatement.executeUpdate();
//            
//        } catch (SQLException ex) {
//            System.out.println(ex.toString());
//        }
//         try {
//        Statement statement = conexion.createStatement();
//        ResultSet resultSet = statement.executeQuery("select * from EntidadBancaria");
//        while (resultSet.next()) {
//            System.out.println(resultSet.getInt(1));
//            System.out.println(resultSet.getString(2));
//            System.out.println(resultSet.getString(3));
//            System.out.println(resultSet.getDate(4).toString());
//            System.out.println(resultSet.getString(5));
//            System.out.println(resultSet.getString(6));
//            
//        }
//    } catch (SQLException e ) {
//             System.out.println(e.toString() );
//    }
//        try {
//            Statement statement = conexion.createStatement();
//            statement.executeUpdate("DELETE FROM EntidadBancaria WHERE idEntidadBancaria = 1");
//
//        } catch (SQLException ex) {
//            System.out.println(ex.toString());
//
//        }
    }
}


