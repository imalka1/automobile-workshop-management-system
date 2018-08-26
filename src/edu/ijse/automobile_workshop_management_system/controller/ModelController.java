package edu.ijse.automobile_workshop_management_system.controller;

import edu.ijse.automobile_workshop_management_system.dbconnection.DBConnection;
import edu.ijse.automobile_workshop_management_system.model.ModelDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModelController {

    public static ModelDTO getMid(ModelDTO modelDTO) throws ClassNotFoundException, SQLException {
        String SQL = "select mid from Model where modelName='" + modelDTO.getModelName() + "' && brandid='" + modelDTO.getBrandid() + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        if (rst.next()) {
            return new ModelDTO(rst.getInt(1));
        }
        return null;
    }

    public static ArrayList<ModelDTO> getModels(int brand) throws ClassNotFoundException, SQLException {
        String SQL = "select modelName from Model where brandid='" + brand + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<ModelDTO> descList = new ArrayList<>();
        while (rst.next()) {
            descList.add(new ModelDTO(rst.getString(1)));
        }
        return descList;
    }

    public static boolean addModel(String name, int brand) throws ClassNotFoundException, SQLException {
        String SQL = "insert into Model (brandid,modelName) values ('" + brand + "','" + name + "')";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        return stm.executeUpdate(SQL) > 0;
    }
}
