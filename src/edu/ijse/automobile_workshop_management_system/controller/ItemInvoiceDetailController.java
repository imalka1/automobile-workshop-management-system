package edu.ijse.automobile_workshop_management_system.controller;

import edu.ijse.automobile_workshop_management_system.dbconnection.DBConnection;
import edu.ijse.automobile_workshop_management_system.model.ItemDTO;
import edu.ijse.automobile_workshop_management_system.model.ItemInvoiceDescriptionDetailDTO;
import edu.ijse.automobile_workshop_management_system.model.ItemInvoiceDetailDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ItemInvoiceDetailController {

    public static boolean addItemInvoice(ItemInvoiceDetailDTO itemInvoiceDetailDTO) throws ClassNotFoundException, SQLException {
        String SQL = "insert into ItemInvoiceDetail (itid,iid,qty,price) values (?,?,?,?)";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setObject(1, itemInvoiceDetailDTO.getItid());
        stm.setObject(2, itemInvoiceDetailDTO.getIid());
        stm.setObject(3, itemInvoiceDetailDTO.getQty());
        stm.setObject(4, itemInvoiceDetailDTO.getPrice());
        try {
            connection.setAutoCommit(false);
            if (stm.executeUpdate() > 0) {
                if (ItemController.updateItem(new ItemDTO(itemInvoiceDetailDTO.getItid(), -itemInvoiceDetailDTO.getQty(), itemInvoiceDetailDTO.getPrice()))) {
                    connection.commit();
                    return true;
                }
            }
            connection.rollback();
            return false;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    public static boolean updateItemInvoice(ItemInvoiceDetailDTO itemInvoiceDetailDTO) throws ClassNotFoundException, SQLException {
        String SQL = "update ItemInvoiceDetail set qty=qty+?,price=? where iid=? && itid=?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setObject(1, itemInvoiceDetailDTO.getQty());
        stm.setObject(2, itemInvoiceDetailDTO.getPrice());
        stm.setObject(3, itemInvoiceDetailDTO.getIid());
        stm.setObject(4, itemInvoiceDetailDTO.getItid());
        try {
            connection.setAutoCommit(false);
            if (stm.executeUpdate() > 0) {
                if (ItemController.updateItem(new ItemDTO(itemInvoiceDetailDTO.getItid(), -itemInvoiceDetailDTO.getQty(), itemInvoiceDetailDTO.getPrice()))) {
                    connection.commit();
                    return true;
                }
            }
            connection.rollback();
            return false;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    public static ArrayList<ItemInvoiceDetailDTO> viewStockInvoices(int id) throws SQLException, ClassNotFoundException {
        String SQL = "select iid.itid,description,iid.qty,iid.price from ItemInvoiceDetail iid,Item i where iid.itid=i.itid && iid=" + id + "";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<ItemInvoiceDetailDTO> details = new ArrayList<>();
        while (rst.next()) {
            details.add(new ItemInvoiceDetailDTO(rst.getInt(1), rst.getString(2), rst.getInt(3), rst.getDouble(4)));
        }
        return details;
    }
}
