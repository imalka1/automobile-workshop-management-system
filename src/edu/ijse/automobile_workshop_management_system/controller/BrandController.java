package edu.ijse.automobile_workshop_management_system.controller;

import edu.ijse.automobile_workshop_management_system.dbconnection.DBConnection;
import edu.ijse.automobile_workshop_management_system.model.BrandDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BrandController {

    public static BrandDTO getBrandId(BrandDTO brandDTO) throws ClassNotFoundException, SQLException {
        String SQL = "select brandid  from Brand where brandName ='" + brandDTO.getBrandName() + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        if (rst.next()) {
            return new BrandDTO(rst.getInt(1));
        }
        return null;
    }

    public static ArrayList<BrandDTO> getAllBrands() throws ClassNotFoundException, SQLException {
        String SQL = "select brandName  from Brand";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<BrandDTO> descList = new ArrayList<>();
        while (rst.next()) {
            descList.add(new BrandDTO(rst.getString(1)));
        }
        return descList;
    }

    public static boolean addBrand(String name) throws ClassNotFoundException, SQLException {
        String SQL = "insert into Brand (brandName) values ('" + name + "')";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        return stm.executeUpdate(SQL) > 0;
    }
}
