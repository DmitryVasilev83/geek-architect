package ru.geekbrains.patterns.chain_of_responsibility;

public class Bitcoin extends Account{
    protected float balance;

    public String getCalledClass() {
        return calledClass;
    }

    private String calledClass = "Bitcoin";

    public Bitcoin(float balance) {

        this.balance = balance;
    }
}
