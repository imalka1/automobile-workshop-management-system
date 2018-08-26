package edu.ijse.automobile_workshop_management_system.model;

public class SymptomDescriptionDetailDTO {

    private int brdid;
    private int iid;
    private String description;

    public SymptomDescriptionDetailDTO() {
    }

    public SymptomDescriptionDetailDTO(String description) {
        this.description = description;
    }

    public SymptomDescriptionDetailDTO(int brdid, int iid) {
        this.brdid = brdid;
        this.iid = iid;
    }
    
     public SymptomDescriptionDetailDTO(int iid) {
        this.iid = iid;
    }

    public int getBrdid() {
        return brdid;
    }

    public void setBrdid(int brdid) {
        this.brdid = brdid;
    }

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
