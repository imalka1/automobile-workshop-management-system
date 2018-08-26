package edu.ijse.automobile_workshop_management_system.model;

public class ItemInvoiceDTO {

    private int itinid;
    private String invoiceNumber;
    private String address;
    private String name;

    public ItemInvoiceDTO() {
    }

    public ItemInvoiceDTO(int itinid, String invoiceNumber, String address) {
        this.itinid = itinid;
        this.invoiceNumber = invoiceNumber;
        this.address = address;
    }

    public ItemInvoiceDTO(int itinid, String invoiceNumber, String name, String address) {
        this.itinid = itinid;
        this.invoiceNumber = invoiceNumber;
        this.address = address;
        this.name = name;
    }

    public ItemInvoiceDTO(String invoiceNumber, String name, String address) {
        this.invoiceNumber = invoiceNumber;
        this.address = address;
        this.name = name;
    }

    public ItemInvoiceDTO(String name) {
        this.name = name;
    }

    public ItemInvoiceDTO(int itinid) {
        this.itinid = itinid;
    }

    /**
     * @return the itinid
     */
    public int getItinid() {
        return itinid;
    }

    /**
     * @param itinid the itinid to set
     */
    public void setItinid(int itinid) {
        this.itinid = itinid;
    }

    /**
     * @return the invoiceNumber
     */
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    /**
     * @param invoiceNumber the invoiceNumber to set
     */
    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}
