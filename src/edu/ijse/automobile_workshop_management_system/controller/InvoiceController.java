package edu.ijse.automobile_workshop_management_system.controller;

import edu.ijse.automobile_workshop_management_system.dbconnection.DBConnection;
import edu.ijse.automobile_workshop_management_system.model.CustomerVehicleDetailDTO;
import edu.ijse.automobile_workshop_management_system.model.EmployeeInvoiceDetailDTO;
import edu.ijse.automobile_workshop_management_system.model.InvoiceDTO;
import edu.ijse.automobile_workshop_management_system.model.VehicleDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class InvoiceController {

    public static boolean addInvoice(InvoiceDTO invoice) throws ClassNotFoundException, SQLException {
        String SQL = "insert into invoice (cvid,rsid,invoiceNumber,meterReading,date,discount,amount,finalize,nextService,yearOrMonth) values(?,?,?,?,?,?,?,?,?,?)";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setObject(1, invoice.getCvid());
        stm.setObject(2, invoice.getRsid());
        stm.setObject(3, invoice.getInvoiceNumber());
        stm.setObject(4, invoice.getMeterReading());
        stm.setObject(5, invoice.getDate());
        stm.setObject(6, invoice.getDiscount());
        stm.setObject(7, invoice.getAmount());
        stm.setObject(8, invoice.getFinalize());
        stm.setObject(9, invoice.getNextService());
        stm.setObject(10, invoice.getYearOrMonth());

        try {
            connection.setAutoCommit(false);
            int count = 0;
            if (stm.executeUpdate() > 0) {
                for (EmployeeInvoiceDetailDTO employeeInvoiceDetailDTO : invoice.getEmployeeInvoiceDetailDTO()) {
                    if (EmployeeInvoiceDetailController.addEmployees(employeeInvoiceDetailDTO)) {
                        count++;
                    }
                }
                if (count == invoice.getEmployeeInvoiceDetailDTO().size()) {
                    connection.commit();
                    connection.setAutoCommit(true);
                    return true;
                }
            }
            connection.rollback();
            return false;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    public static ArrayList<String> searchVehicleNumber() throws ClassNotFoundException, SQLException {
        String SQL = "select distinct vehicleNumber from Vehicle v,CustomerVehicleDetail cvd,invoice i where v.vid=cvd.vid && cvd.cvid=i.cvid && finalize='0'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<String> noList = new ArrayList<>();
        while (rst.next()) {
            noList.add(rst.getString(1));
        }
        return noList;
    }

    public static ArrayList<InvoiceDTO> viewInvoice(int id) throws ClassNotFoundException, SQLException {
        String SQL = "select date,invoicenumber,meterreading,nextservice,rsid,amount,yearormonth,discount from invoice where cvid=" + id + "";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<InvoiceDTO> invoiceList = new ArrayList<>();
        while (rst.next()) {
            invoiceList.add(new InvoiceDTO(rst.getString(1), rst.getString(2), rst.getString(3), (rst.getString(4) + " " + rst.getString(7)), rst.getInt(5), rst.getDouble(6), rst.getDouble(8)));
        }
        return invoiceList;
    }

    public static int getInvoiceId(InvoiceDTO invoiceDTO) throws ClassNotFoundException, SQLException {
        String SQL = "select iid from invoice where invoiceNumber=?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setObject(1, invoiceDTO.getInvoiceNumber());
        ResultSet rst = stm.executeQuery();
        if (rst.next()) {
            return rst.getInt(1);
        }
        return 0;
    }

    public static ArrayList<InvoiceDTO> getInvoiceNumbers() throws ClassNotFoundException, SQLException {
        String SQL = "select invoiceNumber from invoice";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<InvoiceDTO> invoiceNumbers = new ArrayList<>();
        while (rst.next()) {
            invoiceNumbers.add(new InvoiceDTO(rst.getString(1)));
        }
        return invoiceNumbers;
    }

    public static InvoiceDTO getLastInvoiceNumber() throws ClassNotFoundException, SQLException {
        String SQL = "select invoiceNumber from invoice order by iid asc";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        if (rst.last()) {
            return new InvoiceDTO(rst.getString(1));
        }
        return new InvoiceDTO("0");
    }

    public static InvoiceDTO getLastIid() throws ClassNotFoundException, SQLException {
        String SQL = "select iid from invoice";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        if (rst.last()) {
            return new InvoiceDTO(rst.getInt(1));
        }
        return new InvoiceDTO(0);
    }

    public static ArrayList<InvoiceDTO> getInvoiceData(String no) throws ClassNotFoundException, SQLException {
        String SQL = "select date,invoicenumber,meterreading,nextservice,description,amount,yearormonth,discount from invoice i,repairsection rs,vehicle v,CustomerVehicleDetail cvd where rs.rsid=i.rsid && v.vid=cvd.vid && cvd.cvid=i.cvid && (vehicleNumber='" + no + "' || invoiceNumber='" + no + "')";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<InvoiceDTO> invoiceList = new ArrayList<>();
        while (rst.next()) {
            invoiceList.add(new InvoiceDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getDouble(6), rst.getString(7), rst.getDouble(8)));
        }
        return invoiceList;
    }

    public static ArrayList<InvoiceDTO> getInvoiceRepairData(String no) throws ClassNotFoundException, SQLException {
        String SQL = "select date,invoicenumber,description,amount from invoice i,repairsection rs,vehicle v,CustomerVehicleDetail cvd where rs.rsid=i.rsid && v.vid=cvd.vid && cvd.cvid=i.cvid && finalize='0' && vehicleNumber='" + no + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<InvoiceDTO> invoiceList = new ArrayList<>();
        while (rst.next()) {
            invoiceList.add(new InvoiceDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getDouble(4)));
        }
        return invoiceList;
    }

    public static boolean updateInvoice(InvoiceDTO invoiceDTO) throws ClassNotFoundException, SQLException {
        String SQL = "update Invoice set rsid=?, invoiceNumber=?, meterReading=?, discount=?, amount=?, finalize=?, nextService=?, yearOrMonth=? where iid=?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setObject(0, stm);
        return stm.executeUpdate() > 0;
    }

    public static VehicleDTO getVehicleModelAndNo(String no) throws ClassNotFoundException, SQLException {
        String SQL = "select distinct brandName,modelName,vehicleNumber from invoice i,customervehicledetail cv,vehicle v,model m,brand b where i.cvid=cv.cvid && cv.vid=v.vid && v.mid=m.mid && m.brandid=b.brandid && invoiceNumber='" + no + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        if (rst.next()) {
            VehicleDTO vehicle = new VehicleDTO();
            vehicle.setBrand(rst.getString(1));
            vehicle.setModel(rst.getString(2));
            vehicle.setVehicleNo(rst.getString(3));
            return vehicle;
        }
        return null;
    }

    public static CustomerVehicleDetailDTO getCvid(InvoiceDTO invoiceDTO) throws ClassNotFoundException, SQLException {
        String SQL = "select cid,vid from CustomerVehicleDetail cvd,Invoice i where i.cvid=cvd.cvid && invoiceNumber='" + invoiceDTO.getInvoiceNumber() + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        if (rst.next()) {
            CustomerVehicleDetailDTO customerVehicle = new CustomerVehicleDetailDTO();
            customerVehicle.setCid(rst.getInt(1));
            customerVehicle.setVid(rst.getInt(2));
            return customerVehicle;
        }
        return null;
    }
}
