package edu.ijse.automobile_workshop_management_system.model;

public class SymptomDescriptionDTO {

    private int brdid;
    private String description;
    private SymptomDescriptionDetailDTO symptomDescriptionDetailDTO;

    public SymptomDescriptionDTO() {
    }

    public SymptomDescriptionDTO(int brdid, String description) {
        this.brdid = brdid;
        this.description = description;
    }
    
    public SymptomDescriptionDTO(int brdid) {
        this.brdid = brdid;
    }

    public SymptomDescriptionDTO(String description) {
        this.description = description;
    }

    public SymptomDescriptionDTO(String description, SymptomDescriptionDetailDTO symptomDescriptionDetailDTO) {
        this.description = description;
        this.symptomDescriptionDetailDTO = symptomDescriptionDetailDTO;
    }

    public int getBrdid() {
        return brdid;
    }

    public void setBrdid(int brdid) {
        this.brdid = brdid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SymptomDescriptionDetailDTO getSymptomDescriptionDetailDTO() {
        return symptomDescriptionDetailDTO;
    }

    public void setSymptomDescriptionDetailDTO(SymptomDescriptionDetailDTO symptomDescriptionDetailDTO) {
        this.symptomDescriptionDetailDTO = symptomDescriptionDetailDTO;
    }
}
