package edu.ijse.automobile_workshop_management_system.controller;

import edu.ijse.automobile_workshop_management_system.dbconnection.DBConnection;
import edu.ijse.automobile_workshop_management_system.model.EmployeeDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeController {
    public static EmployeeDTO getEmpId(String name) throws ClassNotFoundException, SQLException{
        String SQL="select eid from employee where name='"+name+"'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        if(rst.next()){
            return new EmployeeDTO(rst.getInt(1));
        }
        return null;
    }
}
