package edu.ijse.automobile_workshop_management_system.model;

public class VehicleDTO {

    private int vid;
    private String vehicleNo;
    private int mid;
    private String model;
    private String brand;

    public VehicleDTO() {
    }

    public VehicleDTO(String vehicleNo, String brand, String model) {
        this.vehicleNo = vehicleNo;
        this.model = model;
        this.brand = brand;
    }

    public VehicleDTO(String brand, String model) {
        this.model = model;
        this.brand = brand;
    }

    public VehicleDTO(int vid, String vehicleNo, int mid) {
        this.vid = vid;
        this.vehicleNo = vehicleNo;
        this.mid = mid;
    }

    public VehicleDTO(int vid) {
        this.vid = vid;
    }

    public VehicleDTO(String vehicleNo, int mid) {
        this.vehicleNo = vehicleNo;
        this.mid = mid;
    }

    public VehicleDTO(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public int getVehicleModel() {
        return getMid();
    }

    public void setVehicleModel(int mid) {
        this.setMid(mid);
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

}
