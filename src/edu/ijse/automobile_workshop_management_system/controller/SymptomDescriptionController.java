package edu.ijse.automobile_workshop_management_system.controller;

import edu.ijse.automobile_workshop_management_system.dbconnection.DBConnection;
import edu.ijse.automobile_workshop_management_system.model.SymptomDescriptionDTO;
import edu.ijse.automobile_workshop_management_system.model.SymptomDescriptionDetailDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SymptomDescriptionController {

    public static boolean addSymptom(SymptomDescriptionDTO symptomDescriptionDTO) throws SQLException, ClassNotFoundException {
        String SQL = "insert into BRDescription (description) values ('" + symptomDescriptionDTO.getDescription() + "')";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        if (stm.executeUpdate(SQL) > 0) {
            if (SymptomDescriptionController.getLastId() != null) {
                int brdid = SymptomDescriptionController.getLastId().getBrdid();
                int iid = symptomDescriptionDTO.getSymptomDescriptionDetailDTO().getIid();
                if (SymptomDescriptionDetailController.addSymptom(new SymptomDescriptionDetailDTO(brdid, iid))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static SymptomDescriptionDTO getLastId() throws ClassNotFoundException, SQLException {
        String SQL = "select brdid from BRDescription";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        if (rst.last()) {
            return new SymptomDescriptionDTO(rst.getInt(1));
        }
        return null;
    }

    public static SymptomDescriptionDTO getBrdId(SymptomDescriptionDTO symptomDescriptionDTO) throws ClassNotFoundException, SQLException {
        String SQL = "select brdid from BRDescription where description='" + symptomDescriptionDTO.getDescription() + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        if (rst.next()) {
            return new SymptomDescriptionDTO(rst.getInt(1));
        }
        return null;
    }

    public static ArrayList<SymptomDescriptionDTO> viewAllDesc() throws ClassNotFoundException, SQLException {
        String SQL = "select description from BRDescription";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<SymptomDescriptionDTO> detailList = new ArrayList<>();
        while (rst.next()) {
            detailList.add(new SymptomDescriptionDTO(rst.getString(1)));
        }
        return detailList;
    }
}
