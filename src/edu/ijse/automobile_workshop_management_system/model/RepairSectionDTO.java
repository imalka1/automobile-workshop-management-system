package edu.ijse.automobile_workshop_management_system.model;

public class RepairSectionDTO {

    private int rsid;
    private String description;

    public RepairSectionDTO() {
    }

    public RepairSectionDTO(int rsid, String description) {
        this.rsid = rsid;
        this.description = description;
    }

    public RepairSectionDTO(String description) {
        this.description = description;
    }

    public int getRsid() {
        return rsid;
    }

    public void setRsid(int rsid) {
        this.rsid = rsid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
