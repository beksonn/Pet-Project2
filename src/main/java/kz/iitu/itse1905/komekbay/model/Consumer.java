package kz.iitu.itse1905.komekbay.model;

import javax.validation.constraints.AssertTrue;

public class Consumer {

    private int personalAccount;
    private String firstName;
    private String lastName;
    private String address;
    private float lastMeterReading;
    private String region;

    public Consumer(int personalAccount, String firstName, String lastName, String address, float lastMeterReading, String region) {
        this.personalAccount = personalAccount;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.lastMeterReading = lastMeterReading;
        this.region = region;
    }

    @AssertTrue(message = "Region name can not be null, and Aqsai ")
    public boolean isNameInValid(){
        return region!= null && !region.equalsIgnoreCase("Aqsai");
    }

    public int getPersonalAccount() {
        return personalAccount;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public String getAddress() {
        return address;
    }


    public float getLastMeterReading() {
        return lastMeterReading;
    }


    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}