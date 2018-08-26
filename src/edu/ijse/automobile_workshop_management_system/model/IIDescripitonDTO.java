package edu.ijse.automobile_workshop_management_system.model;

public class IIDescripitonDTO {

    private int iidid;
    private int mid;
    private String description;
    private String partNumber;
    private String brandName;
    private String modelName;

    public IIDescripitonDTO() {
    }

    public IIDescripitonDTO(int iidid, int mid, String description) {
        this.iidid = iidid;
        this.mid = mid;
        this.description = description;
    }

    public IIDescripitonDTO(int iidid) {
        this.iidid = iidid;
    }

    public IIDescripitonDTO(String description, String partNumber, String brandName, String modelName) {
        this.partNumber = partNumber;
        this.description = description;
        this.brandName = brandName;
        this.modelName = modelName;
    }

    public IIDescripitonDTO(String description, String partNumber, int mid) {
        this.partNumber = partNumber;
        this.description = description;
        this.mid = mid;
    }

    public IIDescripitonDTO(String description, String partNumber) {
        this.partNumber = partNumber;
        this.description = description;
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
     * @return the mid
     */
    public int getMid() {
        return mid;
    }

    /**
     * @param mid the mid to set
     */
    public void setMid(int mid) {
        this.mid = mid;
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
