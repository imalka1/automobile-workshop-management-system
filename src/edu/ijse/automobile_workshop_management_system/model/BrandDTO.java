package edu.ijse.automobile_workshop_management_system.model;

public class BrandDTO {

    private int brandid;
    private String brandName;

    public BrandDTO() {
    }

    public BrandDTO(int brandid, String brandName) {
        this.brandid = brandid;
        this.brandName = brandName;
    }
    
    public BrandDTO(int brandid) {
        this.brandid = brandid;
    }
    
    public BrandDTO(String brandName) {
        this.brandName = brandName;
    }

    public int getBrandid() {
        return brandid;
    }

    public void setBrandid(int brandid) {
        this.brandid = brandid;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

}
