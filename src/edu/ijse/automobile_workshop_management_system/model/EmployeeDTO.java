package edu.ijse.automobile_workshop_management_system.model;

public class EmployeeDTO {

    private int eid;
    private String employeeName;

    public EmployeeDTO() {
    }

    public EmployeeDTO(int eid, String employeeName) {
        this.eid = eid;
        this.employeeName = employeeName;
    }

    public EmployeeDTO(int eid) {
        this.eid = eid;
    }

    public EmployeeDTO(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

}
