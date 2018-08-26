package edu.ijse.automobile_workshop_management_system.controller;

import edu.ijse.automobile_workshop_management_system.dbconnection.DBConnection;
import edu.ijse.automobile_workshop_management_system.model.RepairDescriptionDTO;
import edu.ijse.automobile_workshop_management_system.model.RepairInvoiceDescriptionDetailDTO;
import edu.ijse.automobile_workshop_management_system.model.RepairSectionDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RepairDescriptionController {

    public static ArrayList<RepairSectionDTO> getAllReapairDesc() throws ClassNotFoundException, SQLException {
        String SQL = "select description from RepairDescription";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<RepairSectionDTO> descList = new ArrayList<>();
        while (rst.next()) {
            descList.add(new RepairSectionDTO(rst.getString(1)));
        }
        return descList;
    }

    public static RepairDescriptionDTO getRdid(RepairDescriptionDTO repairDescriptionDTO) throws ClassNotFoundException, SQLException {
        String SQL = "select rdid from RepairDescription where description='" + repairDescriptionDTO.getDescription() + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        if (rst.next()) {
            return new RepairDescriptionDTO(rst.getInt(1));
        }
        return null;
    }

    public static boolean addSymptom(RepairDescriptionDTO repairDescriptionDTO) throws SQLException, ClassNotFoundException {
        String SQL = "insert into RepairDescription (description) values ('" + repairDescriptionDTO.getDescription() + "')";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        if (stm.executeUpdate(SQL) > 0) {
            if (RepairDescriptionController.getLastId() != null) {
                int rdid = RepairDescriptionController.getLastId().getRdid();
                int iid = repairDescriptionDTO.getRepairInvoiceDescriptionDetailDTO().getIid();
                int qty = repairDescriptionDTO.getRepairInvoiceDescriptionDetailDTO().getQty();
                double price = repairDescriptionDTO.getRepairInvoiceDescriptionDetailDTO().getPrice();
                if (RepairInvoiceDescriptionDetailController.addRepair(new RepairInvoiceDescriptionDetailDTO(rdid, iid, qty, price))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static RepairDescriptionDTO getLastId() throws ClassNotFoundException, SQLException {
        String SQL = "select rdid from RepairDescription";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        if (rst.last()) {
            return new RepairDescriptionDTO(rst.getInt(1));
        }
        return null;
    }
}
