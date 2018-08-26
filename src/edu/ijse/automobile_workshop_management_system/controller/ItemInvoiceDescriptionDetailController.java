package edu.ijse.automobile_workshop_management_system.controller;

import edu.ijse.automobile_workshop_management_system.dbconnection.DBConnection;
import edu.ijse.automobile_workshop_management_system.model.ItemInvoiceDescriptionDTO;
import edu.ijse.automobile_workshop_management_system.model.ItemInvoiceDescriptionDetailDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ItemInvoiceDescriptionDetailController {

    public static boolean addItemInvoice(ItemInvoiceDescriptionDetailDTO itemInvoiceDescriptionDetailDTO) throws ClassNotFoundException, SQLException {
        String SQL = "insert into ItemInvoiceDescriptionDetail (itindid,iid,qty,price) values (?,?,?,?)";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setObject(1, itemInvoiceDescriptionDetailDTO.getItindid());
        stm.setObject(2, itemInvoiceDescriptionDetailDTO.getIid());
        stm.setObject(3, itemInvoiceDescriptionDetailDTO.getQty());
        stm.setObject(4, itemInvoiceDescriptionDetailDTO.getPrice());
        try {
            connection.setAutoCommit(false);
            if (stm.executeUpdate() > 0) {
                if (ItemInvoiceDescriptionController.updateItem(new ItemInvoiceDescriptionDTO(itemInvoiceDescriptionDetailDTO.getItindid(), -itemInvoiceDescriptionDetailDTO.getQty(), itemInvoiceDescriptionDetailDTO.getPrice()))) {
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

    public static boolean updateItemInvoice(ItemInvoiceDescriptionDetailDTO itemInvoiceDescriptionDetailDTO) throws ClassNotFoundException, SQLException {
        String SQL = "update ItemInvoiceDescriptionDetail set qty=qty+?,price=? where iid=? && itindid=?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setObject(1, itemInvoiceDescriptionDetailDTO.getQty());
        stm.setObject(2, itemInvoiceDescriptionDetailDTO.getPrice());
        stm.setObject(3, itemInvoiceDescriptionDetailDTO.getIid());
        stm.setObject(4, itemInvoiceDescriptionDetailDTO.getItindid());
        try {
            connection.setAutoCommit(false);
            if (stm.executeUpdate() > 0) {
                if (ItemInvoiceDescriptionController.updateItem(new ItemInvoiceDescriptionDTO(itemInvoiceDescriptionDetailDTO.getItindid(), -itemInvoiceDescriptionDetailDTO.getQty(), itemInvoiceDescriptionDetailDTO.getPrice()))) {
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

    public static ArrayList<ItemInvoiceDescriptionDetailDTO> viewItemInvoices(int id) throws SQLException, ClassNotFoundException {
        String SQL = "select iid.itindid,description,iid.qty,iid.price from ItemInvoiceDescriptionDetail iid,ItemInvoiceDescription id,IIDescription ii where iid.itindid=id.itindid && id.iidid=ii.iidid && iid=" + id + "";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<ItemInvoiceDescriptionDetailDTO> details = new ArrayList<>();
        while (rst.next()) {
            details.add(new ItemInvoiceDescriptionDetailDTO(rst.getInt(1), rst.getString(2), rst.getInt(3), rst.getDouble(4)));
        }
        return details;
    }
}
