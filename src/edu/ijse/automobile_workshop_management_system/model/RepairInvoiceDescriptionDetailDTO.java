package edu.ijse.automobile_workshop_management_system.model;

public class RepairInvoiceDescriptionDetailDTO {

    private int iid;
    private int rdid;
    private int qty;
    private double price;
    private String description;

    public RepairInvoiceDescriptionDetailDTO() {
    }

    public RepairInvoiceDescriptionDetailDTO(int qty, double price, String description) {
        this.qty = qty;
        this.price = price;
        this.description = description;
    }

    public RepairInvoiceDescriptionDetailDTO(int rdid, int iid, int qty, double price) {
        this.iid = iid;
        this.rdid = rdid;
        this.qty = qty;
        this.price = price;
    }

    public RepairInvoiceDescriptionDetailDTO(int rdid, int iid) {
        this.iid = iid;
        this.rdid = rdid;
    }

    public RepairInvoiceDescriptionDetailDTO(int iid,int qty, double price) {
        this.iid = iid;
        this.qty = qty;
        this.price = price;
    }

    /**
     * @return the iid
     */
    public int getIid() {
        return iid;
    }

    /**
     * @param iid the iid to set
     */
    public void setIid(int iid) {
        this.iid = iid;
    }

    /**
     * @return the rdid
     */
    public int getRdid() {
        return rdid;
    }

    /**
     * @param rdid the rdid to set
     */
    public void setRdid(int rdid) {
        this.rdid = rdid;
    }

    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
