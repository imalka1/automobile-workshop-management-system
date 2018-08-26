package edu.ijse.automobile_workshop_management_system.model;

public class ModelDTO {

    private int mid;
    private int brandid;
    private String modelName;

    public ModelDTO() {
    }

    public ModelDTO(int mid, int brandid, String modelName) {
        this.mid = mid;
        this.brandid = brandid;
        this.modelName = modelName;
    }
    
    public ModelDTO(int brandid, String modelName) {
        this.brandid = brandid;
        this.modelName = modelName;
    }
    
    public ModelDTO(int mid) {
        this.mid = mid;
    }
    
    public ModelDTO(String modelName) {
        this.modelName = modelName;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getBrandid() {
        return brandid;
    }

    public void setBrandid(int brandid) {
        this.brandid = brandid;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

}
