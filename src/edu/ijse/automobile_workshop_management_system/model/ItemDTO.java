package edu.ijse.automobile_workshop_management_system.model;

public class ItemDTO {

    private int itemId;
    private int mId;
    private String brandName;
    private String modelName;
    private String partNo;
    private String description;
    private int qty;
    private double price;

    public ItemDTO() {
    }

    public ItemDTO(int itemId, int mId, String brandName, String modelName, String partNo, String description, int qty, double price) {
        this.itemId = itemId;
        this.mId = mId;
        this.brandName = brandName;
        this.modelName = modelName;
        this.partNo = partNo;
        this.description = description;
        this.qty = qty;
        this.price = price;
    }

    public ItemDTO(int itemId, double price, String partNo, int qty) {
        this.itemId = itemId;
        this.partNo = partNo;
        this.qty = qty;
        this.price = price;
    }

    public ItemDTO(int itemId, int qty, double price) {
        this.itemId = itemId;
        this.qty = qty;
        this.price = price;
    }

    public ItemDTO(int itemId, int qty, double price, String partNo, String brandName, String modelName, String description) {
        this.partNo = partNo;
        this.itemId = itemId;
        this.qty = qty;
        this.price = price;
        this.brandName = brandName;
        this.modelName = modelName;
        this.description = description;
    }

    public ItemDTO(int itemId, int qty, String partNo, String brandName, String modelName, String description) {
        this.partNo = partNo;
        this.itemId = itemId;
        this.qty = qty;
        this.brandName = brandName;
        this.modelName = modelName;
        this.description = description;
    }

    public ItemDTO(String description) {
        this.description = description;
    }

    public ItemDTO(int itemId) {
        this.itemId = itemId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getPartNo() {
        return partNo;
    }

    public void setPartNo(String partNo) {
        this.partNo = partNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

}
