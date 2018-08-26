package edu.ijse.automobile_workshop_management_system.controller;

import edu.ijse.automobile_workshop_management_system.dbconnection.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RepairSectionController {
    public static ArrayList<String> searchRepairSection() throws ClassNotFoundException, SQLException{
        String SQL="select description from repairsection";
        Connection connection=DBConnection.getDBConnection().getConnection();
        Statement stm= connection.createStatement();
        ResultSet rst=stm.executeQuery(SQL);
        ArrayList<String> sectionList=new ArrayList<>();
        while(rst.next()){
            sectionList.add(rst.getString(1));
        }
        return sectionList;
    }
    
    public static int getRsid(String text) throws ClassNotFoundException, SQLException{
        String SQL="select rsid from repairsection where description='"+text+"'";
        Connection connection=DBConnection.getDBConnection().getConnection();
        Statement stm= connection.createStatement();
        ResultSet rst=stm.executeQuery(SQL);
        if(rst.next()){
            return rst.getInt(1);
        }
        return  0;
    }
    
    public static String getDescription(int id) throws ClassNotFoundException, SQLException{
        String SQL="select description from repairsection where rsid='"+id+"'";
        Connection connection=DBConnection.getDBConnection().getConnection();
        Statement stm= connection.createStatement();
        ResultSet rst=stm.executeQuery(SQL);
        if(rst.next()){
            return rst.getString(1);
        }
        return "NO";
    }
}
