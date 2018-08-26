package edu.ijse.automobile_workshop_management_system.controller;

import edu.ijse.automobile_workshop_management_system.dbconnection.DBConnection;
import edu.ijse.automobile_workshop_management_system.model.ItemInvoiceDTO;
import edu.ijse.automobile_workshop_management_system.model.ItemInvoiceDescriptionDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Imalka
 */
public class ItemInvoiceController {

    public static ItemInvoiceDTO getItinid(ItemInvoiceDTO itemInvoiceDTO) throws ClassNotFoundException, SQLException {
        String SQL = "select itinid from ItemInvoice where name ='" + itemInvoiceDTO.getName() + "' && address='" + itemInvoiceDTO.getAddress() + "' && invoiceNumber='" + itemInvoiceDTO.getInvoiceNumber() + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        if (rst.next()) {
            return new ItemInvoiceDTO(rst.getInt(1));
        }
        return null;
    }

    public static boolean addInvoice(ItemInvoiceDTO itemInvoiceDTO) throws ClassNotFoundException, SQLException {
        String SQL = "insert into ItemInvoice (invoiceNumber,name,address) values ('" + itemInvoiceDTO.getInvoiceNumber() + "','" + itemInvoiceDTO.getName() + "','" + itemInvoiceDTO.getAddress() + "')";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        return stm.executeUpdate(SQL) > 0;
    }

    public static ArrayList<ItemInvoiceDTO> getInvoiceName() throws ClassNotFoundException, SQLException {
        String SQL = "select distinct name,address from ItemInvoice";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<ItemInvoiceDTO> descList = new ArrayList<>();
        while (rst.next()) {
            descList.add(new ItemInvoiceDTO(rst.getString(1)));
        }
        return descList;
    }

    public static ArrayList<ItemInvoiceDTO> getInvoiceAddress(ItemInvoiceDTO itemInvoiceDTO) throws ClassNotFoundException, SQLException {
        String SQL = "select distinct address from ItemInvoice where name='" + itemInvoiceDTO.getName() + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<ItemInvoiceDTO> descList = new ArrayList<>();
        while (rst.next()) {
            ItemInvoiceDTO item = new ItemInvoiceDTO();
            item.setAddress(rst.getString(1));
            descList.add(item);
        }
        return descList;
    }

    public static ItemInvoiceDTO getItemData(ItemInvoiceDescriptionDTO itemInvoiceDescriptionDTO) throws ClassNotFoundException, SQLException {
        String SQL = "select ii.itinid,invoiceNumber,name,address from ItemInvoice ii,ItemInvoiceDescription iid where ii.itinid=iid.itinid && itindid='" + itemInvoiceDescriptionDTO.getItindid() + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        if (rst.next()) {
            return new ItemInvoiceDTO(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4));
        }
        return null;
    }

    public static ArrayList<ItemInvoiceDTO> getInvoiceData(ItemInvoiceDTO itemInvoiceDTO) throws ClassNotFoundException, SQLException {
        String SQL = "select itinid,invoiceNumber,name,address from ItemInvoice where invoiceNumber='" + itemInvoiceDTO.getInvoiceNumber() + "' && name='" + itemInvoiceDTO.getName() + "' && address='" + itemInvoiceDTO.getAddress() + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<ItemInvoiceDTO> descList = new ArrayList<>();
        while (rst.next()) {
            descList.add(new ItemInvoiceDTO(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4)));
        }
        return descList;
    }
}
