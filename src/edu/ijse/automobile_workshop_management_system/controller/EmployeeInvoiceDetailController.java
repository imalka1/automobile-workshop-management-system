package edu.ijse.automobile_workshop_management_system.controller;

import edu.ijse.automobile_workshop_management_system.dbconnection.DBConnection;
import edu.ijse.automobile_workshop_management_system.model.EmployeeDTO;
import edu.ijse.automobile_workshop_management_system.model.EmployeeInvoiceDetailDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmployeeInvoiceDetailController {

    public static ArrayList<EmployeeDTO> viewEmployee(int id) throws ClassNotFoundException, SQLException {
        String SQL = "select name from employee e,EmployeeInvoiceDetail ei where e.eid=ei.eid && iid=" + id + "";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<EmployeeDTO> employeeList = new ArrayList<>();
        while (rst.next()) {
            employeeList.add(new EmployeeDTO(rst.getString(1)));
        }
        return employeeList;
    }

    public static ArrayList<EmployeeDTO> getAllEmployees() throws ClassNotFoundException, SQLException {
        String SQL = "select name from employee";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<EmployeeDTO> employeeList = new ArrayList<>();
        while (rst.next()) {
            employeeList.add(new EmployeeDTO(rst.getString(1)));
        }
        return employeeList;
    }

    public static boolean addEmployees(EmployeeInvoiceDetailDTO employeeInvoiceDetailDTO) throws ClassNotFoundException, SQLException {
        String SQL = "insert into EmployeeInvoiceDetail values (?,?)";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=connection.prepareStatement(SQL);
        stm.setObject(1, employeeInvoiceDetailDTO.getEid());
        stm.setObject(2, employeeInvoiceDetailDTO.getIid());
        System.out.println(employeeInvoiceDetailDTO.getEid()+" "+employeeInvoiceDetailDTO.getIid());
        return stm.executeUpdate() > 0;
    }
}
