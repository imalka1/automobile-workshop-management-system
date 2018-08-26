package edu.ijse.automobile_workshop_management_system.controller;

import edu.ijse.automobile_workshop_management_system.dbconnection.DBConnection;
import edu.ijse.automobile_workshop_management_system.model.ItemDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ItemController {
    
    public static ArrayList<ItemDTO> getAllItemCodes() throws ClassNotFoundException, SQLException {
        String SQL = "select itid  from Item";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<ItemDTO> itemList = new ArrayList<>();
        while (rst.next()) {
            itemList.add(new ItemDTO(rst.getInt(1)));
        }
        return itemList;
    }
    
    public static ArrayList<ItemDTO> getAllItemDesc() throws ClassNotFoundException, SQLException {
        String SQL = "select itid,qty,partNumber,brandName,modelName,description from Item i,Model m,Brand b where i.mid =m.mid && m.brandid=b.brandid";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<ItemDTO> itemList = new ArrayList<>();
        while (rst.next()) {
            itemList.add(new ItemDTO(rst.getInt(1), rst.getInt(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6)));
        }
        return itemList;
    }
    
    public static ArrayList<ItemDTO> getItemData(ItemDTO itemDTO) throws ClassNotFoundException, SQLException {
        String SQL = "select itid,qty,price,partNumber,brandName,modelName,description from Item i,Model m,Brand b where i.mid =m.mid && m.brandid=b.brandid && qty>0 && (description='" + itemDTO.getDescription() + "' || partNumber='" + itemDTO.getDescription() + "' || itid='" + itemDTO.getDescription() + "')";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<ItemDTO> itemList = new ArrayList<>();
        if (rst.next()) {
            itemList.add(new ItemDTO(rst.getInt(1), rst.getInt(2), rst.getDouble(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7)));
        }
        return itemList;
    }
    
    public static ItemDTO getQtyAndPartNo(ItemDTO itemDTO) throws ClassNotFoundException, SQLException {
        String SQL = "select qty,partNumber from Item where itid='" + itemDTO.getItemId() + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        if (rst.next()) {
            ItemDTO item = new ItemDTO();
            item.setQty(rst.getInt(1));
            item.setPartNo(rst.getString(2));
            return item;
        }
        return null;
    }
    
    public static boolean updateItem(ItemDTO itemDTO) throws ClassNotFoundException, SQLException {
        String SQL = "update Item set qty=qty+? where itid=?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setObject(1, itemDTO.getQty());
        stm.setObject(2, itemDTO.getItemId());
        return stm.executeUpdate() > 0;
    }
}
