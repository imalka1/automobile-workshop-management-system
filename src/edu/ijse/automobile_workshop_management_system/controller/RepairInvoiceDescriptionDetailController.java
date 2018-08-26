package edu.ijse.automobile_workshop_management_system.controller;

import edu.ijse.automobile_workshop_management_system.dbconnection.DBConnection;
import edu.ijse.automobile_workshop_management_system.model.RepairInvoiceDescriptionDetailDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RepairInvoiceDescriptionDetailController {

    public static boolean addRepair(RepairInvoiceDescriptionDetailDTO repairInvoiceDescriptionDetailDTO) throws SQLException, ClassNotFoundException {
        String SQL = "insert into InvoiceRepairDescDetail (rdid,iid,qty,price) values (?,?,?,?)";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setObject(1, repairInvoiceDescriptionDetailDTO.getRdid());
        stm.setObject(2, repairInvoiceDescriptionDetailDTO.getIid());
        stm.setObject(3, repairInvoiceDescriptionDetailDTO.getQty());
        stm.setObject(4, repairInvoiceDescriptionDetailDTO.getPrice());
        return stm.executeUpdate() > 0;
    }

    public static ArrayList<RepairInvoiceDescriptionDetailDTO> viewRepairs(int id) throws SQLException, ClassNotFoundException {
        String SQL = "select qty,price,description from InvoiceRepairDescDetail ir,RepairDescription rd where ir.rdid=rd.rdid && iid=" + id + "";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<RepairInvoiceDescriptionDetailDTO> details = new ArrayList<>();
        while (rst.next()) {
            details.add(new RepairInvoiceDescriptionDetailDTO(rst.getInt(1), rst.getDouble(2), rst.getString(3)));
        }
        return details;
    }

    public static boolean updateRepairs(RepairInvoiceDescriptionDetailDTO repairInvoiceDescriptionDetailDTO) throws ClassNotFoundException, SQLException {
        String SQL = "update InvoiceRepairDescDetail set qty=?,price=? where iid=? && rdid=?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement(SQL);       
        stm.setObject(1, repairInvoiceDescriptionDetailDTO.getQty());
        stm.setObject(2, repairInvoiceDescriptionDetailDTO.getPrice());
        stm.setObject(3, repairInvoiceDescriptionDetailDTO.getIid());
        stm.setObject(4, repairInvoiceDescriptionDetailDTO.getRdid());
        return stm.executeUpdate()>0;
    }
}
