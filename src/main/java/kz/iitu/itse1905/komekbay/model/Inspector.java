package kz.iitu.itse1905.komekbay.model;

public class Inspector {
    private int id;
    private String firstName;
    private String lastName;
    private String region;
    private int costOfService;
    private boolean isHeFree;

    public Inspector(int id, String firstName, String lastName, String region, int costOfService, boolean isHeFree) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.region = region;
        this.costOfService = costOfService;
        this.isHeFree = isHeFree;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }



    public int getCostOfService() {
        return costOfService;
    }



    public boolean isHeFree() {
        return isHeFree;
    }


}
