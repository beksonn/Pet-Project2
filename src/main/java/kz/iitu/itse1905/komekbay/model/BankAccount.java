package kz.iitu.itse1905.komekbay.model;

public class BankAccount {
    private int id;
    private String ownerFullName;
    private int ownerPersonalAccount;
    private float money;
    private boolean paymentForThisMonth;

    public BankAccount(int id, String ownerFullName, int ownerPersonalAccount, float money, boolean paymentForThisMonth) {
        this.id = id;
        this.ownerFullName = ownerFullName;
        this.ownerPersonalAccount = ownerPersonalAccount;
        this.money = money;
        this.paymentForThisMonth = paymentForThisMonth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwnerFullName() {
        return ownerFullName;
    }



    public int getOwnerPersonalAccount() {
        return ownerPersonalAccount;
    }

    public void setOwnerPersonalAccount(int ownerPersonalAccount) {
        this.ownerPersonalAccount = ownerPersonalAccount;
    }

    public float getMoney() {
        return money;
    }

}
