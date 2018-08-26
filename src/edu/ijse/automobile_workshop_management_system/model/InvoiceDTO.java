package edu.ijse.automobile_workshop_management_system.model;

import java.util.ArrayList;

public class InvoiceDTO {

    private int iid;
    private int cvid;
    private int rsid;
    private String repairName;
    private String invoiceNumber;
    private String meterReading;
    private String date;
    private double discount;
    private double amount;
    private String finalize;
    private String nextService;
    private String yearOrMonth;
    private ArrayList<EmployeeInvoiceDetailDTO> employeeInvoiceDetailDTOs;

    public InvoiceDTO() {
    }

    public InvoiceDTO(int iid, int cvid, int rsid, String invoiceNumber, String meterReading, String date, double discount, double amount, String finalize, String nextService, String yearOrMonth, ArrayList<EmployeeInvoiceDetailDTO> employeeInvoiceDetailDTOs) {
        this.iid = iid;
        this.cvid = cvid;
        this.rsid = rsid;
        this.invoiceNumber = invoiceNumber;
        this.meterReading = meterReading;
        this.date = date;
        this.discount = discount;
        this.amount = amount;
        this.finalize = finalize;
        this.nextService = nextService;
        this.yearOrMonth = yearOrMonth;
        this.employeeInvoiceDetailDTOs = employeeInvoiceDetailDTOs;
    }

    public InvoiceDTO(int cvid, int rsid, String invoiceNumber, String meterReading, String date, double discount, double amount, String finalize, String nextService, String yearOrMonth, ArrayList<EmployeeInvoiceDetailDTO> employeeInvoiceDetailDTOs) {
        this.cvid = cvid;
        this.rsid = rsid;
        this.invoiceNumber = invoiceNumber;
        this.meterReading = meterReading;
        this.date = date;
        this.discount = discount;
        this.amount = amount;
        this.finalize = finalize;
        this.nextService = nextService;
        this.yearOrMonth = yearOrMonth;
        this.employeeInvoiceDetailDTOs = employeeInvoiceDetailDTOs;
    }

    public InvoiceDTO(String date, String invoiceNumber, String meterReading, String nextService, int rsid, double amount, double discount) {
        this.date = date;
        this.invoiceNumber = invoiceNumber;
        this.meterReading = meterReading;
        this.nextService = nextService;
        this.rsid = rsid;
        this.amount = amount;
    }

    public InvoiceDTO(String date, String invoiceNumber, String meterReading, String nextService, String repairName, double amount, String yearOrMonth, double discount) {
        this.invoiceNumber = invoiceNumber;
        this.meterReading = meterReading;
        this.date = date;
        this.discount = discount;
        this.amount = amount;
        this.repairName = repairName;
        this.nextService = nextService;
        this.yearOrMonth = yearOrMonth;
    }

    public InvoiceDTO(String date, String invoiceNumber, String repairName, double amount) {
        this.invoiceNumber = invoiceNumber;
        this.date = date;
        this.amount = amount;
        this.repairName = repairName;
    }

    public InvoiceDTO(int iid) {
        this.iid = iid;
    }

    public InvoiceDTO(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public int getCvid() {
        return cvid;
    }

    public void setCvid(int cvid) {
        this.cvid = cvid;
    }

    public int getRsid() {
        return rsid;
    }

    public void setRsid(int rsid) {
        this.rsid = rsid;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getMeterReading() {
        return meterReading;
    }

    public void setMeterReading(String meterReading) {
        this.meterReading = meterReading;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getFinalize() {
        return finalize;
    }

    public void setFinalize(String finalize) {
        this.finalize = finalize;
    }

    public String getNextService() {
        return nextService;
    }

    public void setNextService(String nextService) {
        this.nextService = nextService;
    }

    public String getYearOrMonth() {
        return yearOrMonth;
    }

    public void setYearOrMonth(String yearOrMonth) {
        this.yearOrMonth = yearOrMonth;
    }

    public ArrayList<EmployeeInvoiceDetailDTO> getEmployeeInvoiceDetailDTO() {
        return getEmployeeInvoiceDetailDTOs();
    }

    public void setEmployeeDTO(ArrayList<EmployeeInvoiceDetailDTO> employeeInvoiceDetailDTOs) {
        this.setEmployeeInvoiceDetailDTOs(employeeInvoiceDetailDTOs);
    }

    public String getRepairName() {
        return repairName;
    }

    public void setRepairName(String repairName) {
        this.repairName = repairName;
    }

    public ArrayList<EmployeeInvoiceDetailDTO> getEmployeeInvoiceDetailDTOs() {
        return employeeInvoiceDetailDTOs;
    }

    public void setEmployeeInvoiceDetailDTOs(ArrayList<EmployeeInvoiceDetailDTO> employeeInvoiceDetailDTOs) {
        this.employeeInvoiceDetailDTOs = employeeInvoiceDetailDTOs;
    }

}
