package edu.ijse.automobile_workshop_management_system.model;

public class CustomerDTO {

    private int cid;
    private String name;
    private String address;
    private String telephone;
    private String email;

    public CustomerDTO() {
    }

    public CustomerDTO(int cid, String name, String address, String telephone, String email) {
        this.cid = cid;
        this.name = name;
        this.telephone = telephone;
        this.address = address;
        this.email = email;
    }

    public CustomerDTO(int cid) {
        this.cid = cid;
    }

    public CustomerDTO(String name, String address, String telephone, String email) {
        this.name = name;
        this.telephone = telephone;
        this.address = address;
        this.email = email;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
