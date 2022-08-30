package ru.geekbrains.patterns.chain_of_responsibility;

public class Bank extends  Account{

    protected float balance;
    private String calledClass = "Bank";

    public Bank(float balance) {

        this.balance = balance;
    }

    public String getCalledClass() {
        return calledClass;
    }
}
