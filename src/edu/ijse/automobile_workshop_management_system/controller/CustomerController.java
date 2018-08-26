package edu.ijse.automobile_workshop_management_system.controller;

import edu.ijse.automobile_workshop_management_system.dbconnection.DBConnection;
import edu.ijse.automobile_workshop_management_system.model.CustomerDTO;
import java.sql.*;
import java.util.*;

public class CustomerController {

    public static boolean addCustomer(CustomerDTO customer) throws ClassNotFoundException, SQLException {
        String SQL = "insert into customer (custName,custAddress,telephone,email) values(?,?,?,?)";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setObject(1, customer.getName());
        stm.setObject(2, customer.getAddress());
        stm.setObject(3, customer.getTelephone());
        stm.setObject(4, customer.getEmail());
        return stm.executeUpdate() > 0;
    }

    public static CustomerDTO giveCustomerData(CustomerDTO customerDTO) throws ClassNotFoundException, SQLException {
        String SQL = "select*from customer where cid='" + customerDTO.getCid() + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        if (rst.next()) {
            return new CustomerDTO(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5));
        } else {
            return null;
        }
    }

    public static boolean deleteCustomer(int cid) throws ClassNotFoundException, SQLException {
        String SQL = "delete from customer where cid='" + cid + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        return stm.executeUpdate(SQL) > 0;
    }

    public static boolean updateCustomer(CustomerDTO customer) throws ClassNotFoundException, SQLException {
        String SQL = "update customer set custName=?,custAddress=?,telephone=?,email=? where cid=?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setObject(1, customer.getName());
        stm.setObject(2, customer.getAddress());
        stm.setObject(3, customer.getTelephone());
        stm.setObject(4, customer.getEmail());
        stm.setObject(5, customer.getCid());
        return stm.executeUpdate() > 0;
    }

    public static ArrayList<CustomerDTO> viewCustomer() throws ClassNotFoundException, SQLException {
        String SQL = "select*from customer";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<CustomerDTO> customerList = new ArrayList<>();
        while (rst.next()) {
            customerList.add(new CustomerDTO(rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5)));
        }
        return customerList;
    }

    public static ArrayList<CustomerDTO> searchCustomerData(String name) throws ClassNotFoundException, SQLException {
        String SQL = "select*from customer where custName like '" + name + "%' || telephone like '" + name + "%' || email like '" + name + "%'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<CustomerDTO> customerList = new ArrayList<>();
        while (rst.next()) {
            customerList.add(new CustomerDTO(rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5)));
        }
        return customerList;
    }

    public static int getCid() throws SQLException, ClassNotFoundException {
        String SQL = "select*from customer";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        if (rst.last()) {
            return rst.getInt(1);
        }
        return 0;
    }

    public static int getCid(CustomerDTO customer) throws SQLException, ClassNotFoundException {
        String SQL = "select cid from customer where custName=? && custAddress=? && telephone=? && email=?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setObject(1, customer.getName());
        stm.setObject(2, customer.getAddress());
        stm.setObject(3, customer.getTelephone());
        stm.setObject(4, customer.getEmail());
        ResultSet rst = stm.executeQuery();
        if (rst.last()) {
            return rst.getInt(1);
        }
        return 0;
    }
}
