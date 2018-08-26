package edu.ijse.automobile_workshop_management_system.controller;

import edu.ijse.automobile_workshop_management_system.dbconnection.DBConnection;
import edu.ijse.automobile_workshop_management_system.model.VehicleDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class VehicleController {

    public static boolean addVehicle(VehicleDTO vehicle) throws ClassNotFoundException, SQLException {
        String SQL = "insert into vehicle (vehicleNumber,mid) values(?,?)";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setObject(1, vehicle.getVehicleNo());
        stm.setObject(2, vehicle.getVehicleModel());
        return stm.executeUpdate() > 0;
    }

    public static boolean updateVehicle(VehicleDTO vehicle) throws SQLException, ClassNotFoundException {
        String SQL = "update vehicle set vehicleNumber=?,mid=? where vid=?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setObject(1, vehicle.getVehicleNo());
        stm.setObject(2, vehicle.getMid());
        stm.setObject(3, vehicle.getVid());
        return stm.executeUpdate() > 0;
    }

    public static boolean deleteVehicle(int vid) throws ClassNotFoundException, SQLException {
        String SQL = "delete from vehicle where vid='" + vid + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        return stm.executeUpdate(SQL) > 0;
    }

    public static int getVids() throws SQLException, ClassNotFoundException {
        String SQL = "select*from vehicle";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        if (rst.last()) {
            return rst.getInt(1);
        }
        return 0;
    }

    public static int getVid(VehicleDTO vehicle) throws SQLException, ClassNotFoundException {
        String SQL = "select vid from vehicle where vehicleNumber=?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setObject(1, vehicle.getVehicleNo());
        ResultSet rst = stm.executeQuery();
        if (rst.last()) {
            return rst.getInt(1);
        }
        return 0;
    }

    public static ArrayList<VehicleDTO> searchVehicle(VehicleDTO vehicle) throws ClassNotFoundException, SQLException {
        String SQL = "select vehicleNumber,brandName,modelName from Vehicle v,Model m,Brand b where v.mid=m.mid && m.brandid=b.brandid && vehicleNumber like '" + vehicle.getVehicleNo() + "%'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<VehicleDTO> vehicleList = new ArrayList<>();
        while (rst.next()) {
            vehicleList.add(new VehicleDTO(rst.getString(1), rst.getString(2), rst.getString(3)));
        }
        return vehicleList;
    }

    public static VehicleDTO giveVehicleData(VehicleDTO vehicle) throws ClassNotFoundException, SQLException {
        String SQL = "select vehicleNumber,brandName,modelName from Vehicle v,Model m,Brand b where v.mid=m.mid && m.brandid=b.brandid && vid='" + vehicle.getVid() + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        if (rst.next()) {
            return new VehicleDTO(rst.getString(1), rst.getString(2), rst.getString(3));
        }
        return null;
    }

    public static ArrayList<VehicleDTO> getAllVehicleNos() throws ClassNotFoundException, SQLException {
        String SQL = "select vehiclenumber from vehicle";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<VehicleDTO> vehicleList = new ArrayList<>();
        while (rst.next()) {
            vehicleList.add(new VehicleDTO(rst.getString(1)));
        }
        return vehicleList;
    }

    public static VehicleDTO getVehicleModel(VehicleDTO vehicleDTO) throws SQLException, ClassNotFoundException {
        String SQL = "select brandName,modelName from Vehicle v,Model m,Brand b where v.mid=m.mid && m.brandid=b.brandid && vehicleNumber=?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setObject(1, vehicleDTO.getVehicleNo());
        ResultSet rst = stm.executeQuery();
        if (rst.next()) {
            return new VehicleDTO(rst.getString(1), rst.getString(2));
        }
        return null;
    }

}
