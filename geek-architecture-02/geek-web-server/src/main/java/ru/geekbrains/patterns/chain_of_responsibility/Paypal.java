package ru.geekbrains.patterns.chain_of_responsibility;

public class Paypal extends Account{
    protected float balance;

    public String getCalledClass() {
        return calledClass;
    }

    private String calledClass = "Paypal";

    public Paypal(float balance) {

        this.balance = balance;
    }
}
