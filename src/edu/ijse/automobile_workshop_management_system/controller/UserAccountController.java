package edu.ijse.automobile_workshop_management_system.controller;

import edu.ijse.automobile_workshop_management_system.dbconnection.DBConnection;
import edu.ijse.automobile_workshop_management_system.model.UserAccountDTO;
import edu.ijse.automobile_workshop_management_system.utilities.Validate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserAccountController {

    public static boolean addNewUser(UserAccountDTO userAccountDTO) throws ClassNotFoundException, SQLException {
        String SQL = "insert into useraccount (username,password values(?,?))";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setObject(1, userAccountDTO.getUserName());
        stm.setObject(2, userAccountDTO.getPassword());
        return stm.executeUpdate() > 0;
    }

    public static boolean updateUser(UserAccountDTO userAccountDTO) throws ClassNotFoundException, SQLException {
        String SQL = "update useraccount set username=?, password=? where uid=?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setObject(1, userAccountDTO.getUserName());
        stm.setObject(2, userAccountDTO.getPassword());
        stm.setObject(3, userAccountDTO.getUid());
        return stm.executeUpdate() > 0;
    }

    public static String[] searchAccount(UserAccountDTO userAccountDTO) throws ClassNotFoundException, SQLException {
        String SQL = "select username,password,accounttype from useraccount where username=? && password=?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setObject(1, userAccountDTO.getUserName());
        stm.setObject(2, Validate.encryptPassword(userAccountDTO.getPassword()));
        ResultSet rst = stm.executeQuery();
        String[] ob = new String[3];
        ob[0] = "NO";
        ob[1] = "NO";
        ob[2] = "NO";
        if (rst.next()) {
            ob[0] = rst.getString(1);
            ob[1] = rst.getString(2);
            ob[2] = rst.getString(3);
        }
        return ob;
    }

    public static int giveUid(Object[] ob) throws SQLException, ClassNotFoundException {
        String SQL = "select uid from useraccount where username=? && password=?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        rst.next();
        return rst.getInt(1);
    }
}
