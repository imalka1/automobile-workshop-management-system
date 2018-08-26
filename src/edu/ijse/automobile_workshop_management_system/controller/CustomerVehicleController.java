package edu.ijse.automobile_workshop_management_system.controller;

import edu.ijse.automobile_workshop_management_system.dbconnection.DBConnection;
import edu.ijse.automobile_workshop_management_system.model.CustomerDTO;
import edu.ijse.automobile_workshop_management_system.model.CustomerVehicleDetailDTO;
import edu.ijse.automobile_workshop_management_system.model.VehicleDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerVehicleController {
    
    public static boolean addCustomerVehicle(CustomerVehicleDetailDTO customerVehicleDetailDTO) throws ClassNotFoundException, SQLException {
        String SQL = "insert into CustomerVehicleDetail (cid,vid) values(?,?)";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setObject(1, customerVehicleDetailDTO.getCid());
        stm.setObject(2, customerVehicleDetailDTO.getVid());
        return stm.executeUpdate() > 0;
    }
    
    public static ArrayList<VehicleDTO> viewVehicle(int no) throws ClassNotFoundException, SQLException {
        String SQL = "select vehiclenumber,brandName,modelName from vehicle v,customervehicledetail cvd,Model m,Brand b where b.brandid=m.brandid && v.mid=m.mid && v.vid=cvd.vid && cid=" + no + "";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<VehicleDTO> vehicleList = new ArrayList<>();
        while (rst.next()) {
            vehicleList.add(new VehicleDTO(rst.getString(1), rst.getString(2), rst.getString(3)));
        }
        return vehicleList;
    }
    
    public static ArrayList<CustomerDTO> viewCustomer(int no) throws ClassNotFoundException, SQLException {
        String SQL = "select custName,custAddress,telephone,email from customer c,customervehicledetail cvd where c.cid=cvd.cid && vid=" + no + "";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<CustomerDTO> customerList = new ArrayList<>();
        while (rst.next()) {
            customerList.add(new CustomerDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4)));
        }
        return customerList;
    }
    
    public static boolean deleteCustomerVehicle(int no1, int no2) throws ClassNotFoundException, SQLException {
        String SQL = "delete from customervehicledetail where cid=" + no1 + " && vid=" + no2 + "";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        return stm.executeUpdate(SQL) > 0;
    }
    
    public static int getCvid(int cid, int vid) throws ClassNotFoundException, SQLException {
        String SQL = "select cvid from CustomerVehicleDetail where cid=? && vid=?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setObject(1, cid);
        stm.setObject(2, vid);
        ResultSet rst = stm.executeQuery();
        if (rst.next()) {
            return rst.getInt(1);
        }
        return 0;
    }
}
