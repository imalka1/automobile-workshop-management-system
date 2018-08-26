package edu.ijse.automobile_workshop_management_system.model;

public class RepairDescriptionDTO {
    private int rdid;
    private String description;
    private RepairInvoiceDescriptionDetailDTO repairInvoiceDescriptionDetailDTO;

    public RepairDescriptionDTO() {
    }

    public RepairDescriptionDTO(int rdid, String description, RepairInvoiceDescriptionDetailDTO repairInvoiceDescriptionDetailDTO) {
        this.rdid = rdid;
        this.description = description;
        this.repairInvoiceDescriptionDetailDTO = repairInvoiceDescriptionDetailDTO;
    }
    
    public RepairDescriptionDTO(String description, RepairInvoiceDescriptionDetailDTO repairInvoiceDescriptionDetailDTO) {
        this.description = description;
        this.repairInvoiceDescriptionDetailDTO = repairInvoiceDescriptionDetailDTO;
    }
    
    public RepairDescriptionDTO(String description) {
        this.description = description;
    }
    
    public RepairDescriptionDTO(int rdid) {
        this.rdid = rdid;
    }

    public int getRdid() {
        return rdid;
    }

    public void setRdid(int rdid) {
        this.rdid = rdid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RepairInvoiceDescriptionDetailDTO getRepairInvoiceDescriptionDetailDTO() {
        return repairInvoiceDescriptionDetailDTO;
    }

    public void setRepairInvoiceDescriptionDetailDTO(RepairInvoiceDescriptionDetailDTO repairInvoiceDescriptionDetailDTO) {
        this.repairInvoiceDescriptionDetailDTO = repairInvoiceDescriptionDetailDTO;
    }
    
}
