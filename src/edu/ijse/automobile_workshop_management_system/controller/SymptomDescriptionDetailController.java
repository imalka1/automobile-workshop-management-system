package edu.ijse.automobile_workshop_management_system.controller;

import edu.ijse.automobile_workshop_management_system.dbconnection.DBConnection;
import edu.ijse.automobile_workshop_management_system.model.SymptomDescriptionDTO;
import edu.ijse.automobile_workshop_management_system.model.SymptomDescriptionDetailDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SymptomDescriptionDetailController {

    public static ArrayList<SymptomDescriptionDetailDTO> viewSymptoms(int id) throws SQLException, ClassNotFoundException {
        String SQL = "select description from BRDescription br,BRDescriptionDetail brd where br.brdid=brd.brdid && iid=" + id + "";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<SymptomDescriptionDetailDTO> details = new ArrayList<>();
        while (rst.next()) {
            details.add(new SymptomDescriptionDetailDTO(rst.getString(1)));
        }
        return details;
    }

    public static boolean addSymptom(SymptomDescriptionDetailDTO symptomDescriptionDetailDTO) throws SQLException, ClassNotFoundException {
        String SQL = "insert into BRDescriptionDetail (brdid,iid) values (?,?)";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setObject(1, symptomDescriptionDetailDTO.getBrdid());
        stm.setObject(2, symptomDescriptionDetailDTO.getIid());
        return stm.executeUpdate() > 0;
    }
}
