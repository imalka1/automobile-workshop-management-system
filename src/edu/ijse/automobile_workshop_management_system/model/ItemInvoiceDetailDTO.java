package edu.ijse.automobile_workshop_management_system.model;

public class ItemInvoiceDetailDTO {

    private int itid;
    private int iid;
    private int qty;
    private double price;
    private String description;

    public ItemInvoiceDetailDTO() {
    }

    public ItemInvoiceDetailDTO(int itid, int iid, int qty, double price, String description) {
        this.itid = itid;
        this.iid = iid;
        this.qty = qty;
        this.price = price;
        this.description = description;
    }

    public ItemInvoiceDetailDTO(int itid, String description, int qty, double price) {
        this.itid = itid;
        this.qty = qty;
        this.price = price;
        this.description = description;
    }

    public ItemInvoiceDetailDTO(int iid, int itid, int qty, double price) {
        this.itid = itid;
        this.iid = iid;
        this.qty = qty;
        this.price = price;
    }

    /**
     * @return the itid
     */
    public int getItid() {
        return itid;
    }

    /**
     * @param itid the itid to set
     */
    public void setItid(int itid) {
        this.itid = itid;
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
