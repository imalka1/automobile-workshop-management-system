package edu.ijse.automobile_workshop_management_system.controller;

import edu.ijse.automobile_workshop_management_system.dbconnection.DBConnection;
import edu.ijse.automobile_workshop_management_system.model.ItemInvoiceDescriptionDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ItemInvoiceDescriptionController {

    public static ArrayList<ItemInvoiceDescriptionDTO> getAllInvoices() throws ClassNotFoundException, SQLException {
        String SQL = "select itindid,qty,description,partNumber,name,brandName,modelName from ItemInvoice i,IIDescription ii,ItemInvoiceDescription iid,Brand b,Model m where i.itinid=iid.itinid && ii.iidid=iid.iidid && ii.mid=m.mid && b.brandid=m.brandid";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ArrayList<ItemInvoiceDescriptionDTO> itemList = new ArrayList<>();
        ResultSet rst = stm.executeQuery(SQL);
        while (rst.next()) {
            itemList.add(new ItemInvoiceDescriptionDTO(rst.getInt(1), rst.getInt(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7)));
        }
        return itemList;
    }

    public static ArrayList<ItemInvoiceDescriptionDTO> getItemData(ItemInvoiceDescriptionDTO itemInvoiceDescriptionDTO) throws ClassNotFoundException, SQLException {
        String SQL = "select itindid,qty,description,partNumber,name,brandName,modelName,price from ItemInvoice i,IIDescription ii,ItemInvoiceDescription iid,Brand b,Model m where i.itinid=iid.itinid && ii.iidid=iid.iidid && ii.mid=m.mid && b.brandid=m.brandid && qty>0 && (description='" + itemInvoiceDescriptionDTO.getDescription() + "' || partNumber='" + itemInvoiceDescriptionDTO.getDescription() + "' || itindid='" + itemInvoiceDescriptionDTO.getDescription() + "')";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<ItemInvoiceDescriptionDTO> itemList = new ArrayList<>();
        while (rst.next()) {
            itemList.add(new ItemInvoiceDescriptionDTO(rst.getInt(1), rst.getInt(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getDouble(8)));
        }
        return itemList;
    }

    public static ItemInvoiceDescriptionDTO getQtyAndPartNo(ItemInvoiceDescriptionDTO itemInvoiceDescriptionDTO) throws ClassNotFoundException, SQLException {
        String SQL = "select qty,partNumber from ItemInvoiceDescription ii,IIDescription i where ii.iidid=i.iidid && itindid='" + itemInvoiceDescriptionDTO.getItindid() + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        if (rst.next()) {
            return new ItemInvoiceDescriptionDTO(rst.getInt(1), rst.getString(2));
        }
        return null;
    }

    public static boolean updateItem(ItemInvoiceDescriptionDTO itemInvoiceDescriptionDTO) throws ClassNotFoundException, SQLException {
        String SQL = "update ItemInvoiceDescription set qty=qty+? where itindid=?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setObject(1, itemInvoiceDescriptionDTO.getQty());
        stm.setObject(2, itemInvoiceDescriptionDTO.getItindid());
        return stm.executeUpdate() > 0;
    }

    public static boolean updateItemWithPrice(ItemInvoiceDescriptionDTO itemInvoiceDescriptionDTO) throws ClassNotFoundException, SQLException {
        String SQL = "update ItemInvoiceDescription set qty=qty+?,price=? where itindid=?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setObject(1, itemInvoiceDescriptionDTO.getQty());
        stm.setObject(2, itemInvoiceDescriptionDTO.getPrice());
        stm.setObject(3, itemInvoiceDescriptionDTO.getItindid());
        return stm.executeUpdate() > 0;
    }

    public static boolean addItem(ItemInvoiceDescriptionDTO itemInvoiceDescriptionDTO) throws ClassNotFoundException, SQLException {
        String SQL = "insert into ItemInvoiceDescription (iidid,itinid,qty,price) values (?,?,?,?)";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setObject(1, itemInvoiceDescriptionDTO.getIidid());
        stm.setObject(2, itemInvoiceDescriptionDTO.getItinid());
        stm.setObject(3, itemInvoiceDescriptionDTO.getQty());
        stm.setObject(4, itemInvoiceDescriptionDTO.getPrice());
        return stm.executeUpdate() > 0;
    }

    public static ArrayList<ItemInvoiceDescriptionDTO> getAllDataUsingInvoice(ItemInvoiceDescriptionDTO itemInvoiceDescriptionDTO) throws ClassNotFoundException, SQLException {
        String SQL = "select itindid,qty,description,partNumber,brandName,modelName,price from ItemInvoice i,IIDescription ii,ItemInvoiceDescription iid,Brand b,Model m where i.itinid=iid.itinid && ii.iidid=iid.iidid && ii.mid=m.mid && b.brandid=m.brandid && i.itinid='" + itemInvoiceDescriptionDTO.getItinid() + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ArrayList<ItemInvoiceDescriptionDTO> itemList = new ArrayList<>();
        ResultSet rst = stm.executeQuery(SQL);
        while (rst.next()) {
            ItemInvoiceDescriptionDTO descriptionDTO = new ItemInvoiceDescriptionDTO();
            descriptionDTO.setItindid(rst.getInt(1));
            descriptionDTO.setQty(rst.getInt(2));
            descriptionDTO.setDescription(rst.getString(3));
            descriptionDTO.setPartNumber(rst.getString(4));
            descriptionDTO.setBrandName(rst.getString(5));
            descriptionDTO.setModelName(rst.getString(6));
            descriptionDTO.setPrice(rst.getDouble(7));
            itemList.add(descriptionDTO);
        }
        return itemList;
    }

    public static ArrayList<ItemInvoiceDescriptionDTO> getAllDataUsingDesc(ItemInvoiceDescriptionDTO itemInvoiceDescriptionDTO) throws ClassNotFoundException, SQLException {
        String SQL = "select itindid,qty,description,partNumber,brandName,modelName,price from ItemInvoice i,IIDescription ii,ItemInvoiceDescription iid,Brand b,Model m where i.itinid=iid.itinid && ii.iidid=iid.iidid && ii.mid=m.mid && b.brandid=m.brandid && qty>0 && (description like '" + itemInvoiceDescriptionDTO.getDescription() + "' || partNumber like '" + itemInvoiceDescriptionDTO.getPartNumber() + "')";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ArrayList<ItemInvoiceDescriptionDTO> itemList = new ArrayList<>();
        ResultSet rst = stm.executeQuery(SQL);
        while (rst.next()) {
            ItemInvoiceDescriptionDTO descriptionDTO = new ItemInvoiceDescriptionDTO();
            descriptionDTO.setItindid(rst.getInt(1));
            descriptionDTO.setQty(rst.getInt(2));
            descriptionDTO.setDescription(rst.getString(3));
            descriptionDTO.setPartNumber(rst.getString(4));
            descriptionDTO.setBrandName(rst.getString(5));
            descriptionDTO.setModelName(rst.getString(6));
            descriptionDTO.setPrice(rst.getDouble(7));
            itemList.add(descriptionDTO);
        }
        return itemList;
    }

    public static ArrayList<ItemInvoiceDescriptionDTO> getAllDataUsingDescAndModel(ItemInvoiceDescriptionDTO itemInvoiceDescriptionDTO) throws ClassNotFoundException, SQLException {
        String SQL = "select itindid,qty,description,partNumber,brandName,modelName,price from ItemInvoice i,IIDescription ii,ItemInvoiceDescription iid,Brand b,Model m where i.itinid=iid.itinid && ii.iidid=iid.iidid && ii.mid=m.mid && b.brandid=m.brandid && qty>0 && (description='" + itemInvoiceDescriptionDTO.getDescription() + "' || partNumber='" + itemInvoiceDescriptionDTO.getPartNumber() + "') && modelName='" + itemInvoiceDescriptionDTO.getModelName() + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ArrayList<ItemInvoiceDescriptionDTO> itemList = new ArrayList<>();
        ResultSet rst = stm.executeQuery(SQL);
        while (rst.next()) {
            ItemInvoiceDescriptionDTO descriptionDTO = new ItemInvoiceDescriptionDTO();
            descriptionDTO.setItindid(rst.getInt(1));
            descriptionDTO.setQty(rst.getInt(2));
            descriptionDTO.setDescription(rst.getString(3));
            descriptionDTO.setPartNumber(rst.getString(4));
            descriptionDTO.setBrandName(rst.getString(5));
            descriptionDTO.setModelName(rst.getString(6));
            descriptionDTO.setPrice(rst.getDouble(7));
            itemList.add(descriptionDTO);
        }
        return itemList;
    }

    public static ArrayList<ItemInvoiceDescriptionDTO> getAllDataUsingDescAndModelAndQty(ItemInvoiceDescriptionDTO itemInvoiceDescriptionDTO) throws ClassNotFoundException, SQLException {
        String SQL = "select itindid,qty,description,partNumber,brandName,modelName,price from ItemInvoice i,IIDescription ii,ItemInvoiceDescription iid,Brand b,Model m where i.itinid=iid.itinid && ii.iidid=iid.iidid && ii.mid=m.mid && b.brandid=m.brandid && qty>0 && (description='" + itemInvoiceDescriptionDTO.getDescription() + "' || partNumber='" + itemInvoiceDescriptionDTO.getPartNumber() + "') && modelName='" + itemInvoiceDescriptionDTO.getModelName() + "' && qty>='" + itemInvoiceDescriptionDTO.getQty() + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ArrayList<ItemInvoiceDescriptionDTO> itemList = new ArrayList<>();
        ResultSet rst = stm.executeQuery(SQL);
        while (rst.next()) {
            ItemInvoiceDescriptionDTO descriptionDTO = new ItemInvoiceDescriptionDTO();
            descriptionDTO.setItindid(rst.getInt(1));
            descriptionDTO.setQty(rst.getInt(2));
            descriptionDTO.setDescription(rst.getString(3));
            descriptionDTO.setPartNumber(rst.getString(4));
            descriptionDTO.setBrandName(rst.getString(5));
            descriptionDTO.setModelName(rst.getString(6));
            descriptionDTO.setPrice(rst.getDouble(7));
            itemList.add(descriptionDTO);
        }
        return itemList;
    }
}
