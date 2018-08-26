package edu.ijse.automobile_workshop_management_system.model;

public class CustomerVehicleDetailDTO {

    private int cvid;
    private int cid;
    private int vid;

    public CustomerVehicleDetailDTO() {
    }

    public CustomerVehicleDetailDTO(int cvid, int cid, int vid) {
        this.cvid = cvid;
        this.cid = cid;
        this.vid = vid;
    }

    public CustomerVehicleDetailDTO(int cid, int vid) {
        this.cid = cid;
        this.vid = vid;
    }

    public int getCvid() {
        return cvid;
    }

    public void setCvid(int cvid) {
        this.cvid = cvid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

}
