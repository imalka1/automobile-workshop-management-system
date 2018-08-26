package edu.ijse.automobile_workshop_management_system.controller;

import edu.ijse.automobile_workshop_management_system.dbconnection.DBConnection;
import edu.ijse.automobile_workshop_management_system.model.IIDescripitonDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class IIDescriptionController {

    public static ArrayList<IIDescripitonDTO> getAllItems() throws ClassNotFoundException, SQLException {
        String SQL = "select description,partNumber from IIDescription";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<IIDescripitonDTO> itemList = new ArrayList<>();
        while (rst.next()) {
            itemList.add(new IIDescripitonDTO(rst.getString(1), rst.getString(2)));
        }
        return itemList;
    }

    public static IIDescripitonDTO getItemAndPartNo(IIDescripitonDTO iIDescripitonDTO) throws ClassNotFoundException, SQLException {
        String SQL = "select iidid,description,partNumber from IIDescription where (description='" + iIDescripitonDTO.getDescription() + "' || partNumber='" + iIDescripitonDTO.getPartNumber() + "') && mid=" + iIDescripitonDTO.getMid() + "";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        if (rst.next()) {
            IIDescripitonDTO descripitonDTO = new IIDescripitonDTO();
            descripitonDTO.setIidid(rst.getInt(1));
            descripitonDTO.setDescription(rst.getString(2));
            descripitonDTO.setPartNumber(rst.getString(3));
            return descripitonDTO;
        }
        return null;
    }

    public static IIDescripitonDTO getIid(IIDescripitonDTO iIDescripitonDTO) throws ClassNotFoundException, SQLException {
        String SQL = "select iidid from IIDescription where (description ='" + iIDescripitonDTO.getDescription() + "' || partNumber='" + iIDescripitonDTO.getPartNumber() + "') && mid='" + iIDescripitonDTO.getMid() + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        if (rst.next()) {
            return new IIDescripitonDTO(rst.getInt(1));
        }
        return null;
    }

    public static boolean addItem(IIDescripitonDTO iIDescripitonDTO) throws ClassNotFoundException, SQLException {
        String SQL = "insert into IIDescription (description,partNumber,mid) values ('" + iIDescripitonDTO.getDescription() + "','" + iIDescripitonDTO.getPartNumber() + "','" + iIDescripitonDTO.getMid() + "')";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        return stm.executeUpdate(SQL) > 0;
    }
}
