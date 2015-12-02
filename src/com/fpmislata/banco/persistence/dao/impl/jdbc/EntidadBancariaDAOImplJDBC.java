/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistence.dao.impl.jdbc;

import com.fpmislata.banco.persistence.jdbc.ConnectionFactory;
import com.fpmislata.banco.bussiness.domain.EntidadBancaria;
import com.fpmislata.banco.persistence.dao.EntidadBancariaDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


/**
 *
 * @author Dark
 */
public class EntidadBancariaDAOImplJDBC implements EntidadBancariaDAO {

    @Autowired
    private ConnectionFactory connectionFactory;

    @Override
    public EntidadBancaria get(int idEntidadBancaria) {

        try {
            EntidadBancaria entidadBancaria;
            Connection connection = connectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from EntidadBancaria where idEntidadBancaria=?");
            preparedStatement.setInt(1, idEntidadBancaria);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                entidadBancaria = new EntidadBancaria();
                entidadBancaria.setIdEntidadBancaria(resultSet.getInt(1));
                entidadBancaria.setNombre(resultSet.getString(2));
                entidadBancaria.setCodigoEntidad(resultSet.getString(3));
                entidadBancaria.setFechaCreacion(resultSet.getDate(4));
                entidadBancaria.setDireccion(resultSet.getString(5));
                entidadBancaria.setCif(resultSet.getString(6));
            }else{
                entidadBancaria= null;
            }
            
            if(resultSet.next()){
                throw new RuntimeException("Demasiadas filas devueltas");
            }
            
            preparedStatement.close();
            connectionFactory.closeConnection(connection);
            return entidadBancaria;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public EntidadBancaria insert(EntidadBancaria entidadBancaria) {

        try {
            int idTabla = 0;
            Connection connection = connectionFactory.getConnection();
            String sentencia = "Insert into EntidadBancaria (nombre,codigoEntidad,fechaCreacion,direccion,CIF) Values (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sentencia, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, entidadBancaria.getNombre());
            preparedStatement.setString(2, entidadBancaria.getCodigoEntidad());
            if(entidadBancaria.getFechaCreacion() == null){
            preparedStatement.setDate(3, null);
            }else{           
            preparedStatement.setDate(3, new java.sql.Date(entidadBancaria.getFechaCreacion().getTime()));
            }
            
            preparedStatement.setString(4, entidadBancaria.getDireccion());
            preparedStatement.setString(5, entidadBancaria.getCif());

            int elementInsert = preparedStatement.executeUpdate();
            
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    idTabla = (int) generatedKeys.getLong(1);
                }
            }
            preparedStatement.close();
            connectionFactory.closeConnection(connection);
            if(elementInsert == 1){
            return this.get(idTabla);
            }else{
             throw new RuntimeException("Se insertaron "+ elementInsert+" registros");   
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public EntidadBancaria update(EntidadBancaria entidadBancaria) {

        try {
            Connection connection = connectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE EntidadBancaria SET nombre = ?, codigoEntidad = ?, fechaCreacion= ?, direccion= ?, CIF= ? where idEntidadBancaria=?");
            preparedStatement.setString(1, entidadBancaria.getNombre());
            preparedStatement.setString(2, entidadBancaria.getCodigoEntidad());
            if(entidadBancaria.getFechaCreacion() == null){
            preparedStatement.setDate(3, null);
            }else{           
            preparedStatement.setDate(3, new java.sql.Date(entidadBancaria.getFechaCreacion().getTime()));
            }
            preparedStatement.setString(4, entidadBancaria.getDireccion());
            preparedStatement.setString(5, entidadBancaria.getCif());
            preparedStatement.setInt(6, entidadBancaria.getIdEntidadBancaria());

            preparedStatement.executeUpdate();
            preparedStatement.close();
            connectionFactory.closeConnection(connection);
            return this.get(entidadBancaria.getIdEntidadBancaria());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public boolean delete(int idEntidadBancaria) {

        try {
           
            Connection connection = connectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM EntidadBancaria WHERE idEntidadBancaria = ?");
            preparedStatement.setInt(1, idEntidadBancaria);
            int elementsDeleted = preparedStatement.executeUpdate();
            preparedStatement.close();
            preparedStatement.close();
            connectionFactory.closeConnection(connection);
            if (elementsDeleted == 0 ) {
                return false;
            } else if (elementsDeleted == 1 ) {
                return true;
            } else if (elementsDeleted >1 ) {
                throw new RuntimeException("Demasiadas filas borradas"+ elementsDeleted);
            } else {
                throw new RuntimeException("Soy un paranoico"+ elementsDeleted);
            }                                  
        } catch (Exception ex) {
            throw new RuntimeException(ex);

        }

    }

    @Override
    public List<EntidadBancaria> findAll() {

        try {
            List<EntidadBancaria> entidadesBancarias = new ArrayList<>();
            Connection connection = connectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from EntidadBancaria");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                EntidadBancaria entidadBancaria = new EntidadBancaria();
                entidadBancaria.setIdEntidadBancaria(resultSet.getInt(1));
                entidadBancaria.setNombre(resultSet.getString(2));
                entidadBancaria.setCodigoEntidad(resultSet.getString(3));
                entidadBancaria.setFechaCreacion(resultSet.getDate(4));
                entidadBancaria.setDireccion(resultSet.getString(5));
                entidadBancaria.setCif(resultSet.getString(6));
                entidadesBancarias.add(entidadBancaria);
            }
            preparedStatement.close();
            connectionFactory.closeConnection(connection);
            return entidadesBancarias;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<EntidadBancaria> findByNombre(String nombre) {

        try {
            List<EntidadBancaria> entidadesBancarias = new ArrayList<>();
            Connection connection = connectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from EntidadBancaria where nombre=?");
            preparedStatement.setString(1, nombre);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                EntidadBancaria entidadBancaria = new EntidadBancaria();
                entidadBancaria.setIdEntidadBancaria(resultSet.getInt(1));
                entidadBancaria.setNombre(resultSet.getString(2));
                entidadBancaria.setCodigoEntidad(resultSet.getString(3));
                entidadBancaria.setFechaCreacion(resultSet.getDate(4));
                entidadBancaria.setDireccion(resultSet.getString(5));
                entidadBancaria.setCif(resultSet.getString(6));
                entidadesBancarias.add(entidadBancaria);
            }
            preparedStatement.close();
            connectionFactory.closeConnection(connection);
            return entidadesBancarias;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

   

}
