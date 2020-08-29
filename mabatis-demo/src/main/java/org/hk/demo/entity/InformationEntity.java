package org.hk.demo.entity;

public class InformationEntity {
    private String occupation;
    private String workAddress;

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    @Override
    public String toString() {
        return "InformationEntity{" +
                "occupation='" + occupation + '\'' +
                ", workAddress='" + workAddress + '\'' +
                '}';
    }
}