package edu.ijse.automobile_workshop_management_system.model;

public class EmployeeInvoiceDetailDTO {

    private int iid;
    private int eid;

    public EmployeeInvoiceDetailDTO() {
    }

    public EmployeeInvoiceDetailDTO(int eid, int iid) {
        this.iid = iid;
        this.eid = eid;
    }
    
    public EmployeeInvoiceDetailDTO(int eid) {
        this.eid = eid;
    }

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

}
