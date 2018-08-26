package edu.ijse.automobile_workshop_management_system.model;

public class ItemInvoiceDescriptionDTO {

    private int itindid;
    private int iidid;
    private int itinid;
    private int qty;
    private double price;
    private String name;
    private String description;
    private String partNumber;
    private String brandName;
    private String modelName;

    public ItemInvoiceDescriptionDTO() {
    }

    public ItemInvoiceDescriptionDTO(int itindid, int iidid, int itinid, int qty, double price, String name, String description, String brandName, String modelName) {
        this.itindid = itindid;
        this.iidid = iidid;
        this.itinid = itinid;
        this.qty = qty;
        this.price = price;
        this.name = name;
        this.description = description;
        this.brandName = brandName;
        this.modelName = modelName;
    }

    public ItemInvoiceDescriptionDTO(int iidid, int itinid, int qty, double price) {
        this.iidid = iidid;
        this.itinid = itinid;
        this.qty = qty;
        this.price = price;
    }

    public ItemInvoiceDescriptionDTO(int itindid, int qty, String description, String partNumber, String name, String brandName, String modelName) {
        this.itindid = itindid;
        this.partNumber = partNumber;
        this.qty = qty;
        this.name = name;
        this.description = description;
        this.brandName = brandName;
        this.modelName = modelName;
    }

    public ItemInvoiceDescriptionDTO(int itindid, int qty, String description, String partNumber, String name, String brandName, String modelName, double price) {
        this.itindid = itindid;
        this.price = price;
        this.partNumber = partNumber;
        this.qty = qty;
        this.name = name;
        this.description = description;
        this.brandName = brandName;
        this.modelName = modelName;
    }

    public ItemInvoiceDescriptionDTO(int itindid, int qty, double price) {
        this.itindid = itindid;
        this.price = price;
        this.qty = qty;
    }

    public ItemInvoiceDescriptionDTO(int qty, String partNumber) {
        this.qty = qty;
        this.partNumber = partNumber;
    }

    public ItemInvoiceDescriptionDTO(String description) {
        this.description = description;
    }

    /**
     * @return the itindid
     */
    public int getItindid() {
        return itindid;
    }

    /**
     * @param itindid the itindid to set
     */
    public void setItindid(int itindid) {
        this.itindid = itindid;
    }

    /**
     * @return the iidid
     */
    public int getIidid() {
        return iidid;
    }

    /**
     * @param iidid the iidid to set
     */
    public void setIidid(int iidid) {
        this.iidid = iidid;
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

    /**
     * @return the brandName
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * @param brandName the brandName to set
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    /**
     * @return the modelName
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * @param modelName the modelName to set
     */
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    /**
     * @return the partNumber
     */
    public String getPartNumber() {
        return partNumber;
    }

    /**
     * @param partNumber the partNumber to set
     */
    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

}
