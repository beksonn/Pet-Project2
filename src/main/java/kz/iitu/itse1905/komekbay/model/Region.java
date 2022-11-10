package kz.iitu.itse1905.komekbay.model;

public class Region {

    private int id;
    private String name;
    private float firstLvlPayment;
    private float secondLvlPayment;
    private float thirdLvlPayment;

    public Region(int id, String name, float firstLvlPayment, float secondLvlPayment, float thirdLvlPayment) {
        this.id = id;
        this.name = name;
        this.firstLvlPayment = firstLvlPayment;
        this.secondLvlPayment = secondLvlPayment;
        this.thirdLvlPayment = thirdLvlPayment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public float getFirstLvlPayment() {
        return firstLvlPayment;
    }


    public float getSecondLvlPayment() {
        return secondLvlPayment;
    }


    public float getThirdLvlPayment() {
        return thirdLvlPayment;
    }
}
