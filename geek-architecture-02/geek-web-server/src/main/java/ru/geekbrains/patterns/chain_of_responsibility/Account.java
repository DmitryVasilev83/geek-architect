package ru.geekbrains.patterns.chain_of_responsibility;

public abstract class Account {

    protected Account successor;
    protected float balance;
    protected String calledClass;

    public Account(float balance) {
        this.balance = balance;

    }

    protected Account() {
    }

    public void setNext(Account account)    {
        successor = account;
    }

    public void pay(float amountToPay) throws Exception {
        if (canPay(amountToPay)) {
            String text = String.format("Paid %s using %s", amountToPay, successor.calledClass);
            System.out.println(text);
        } else if (successor != null) {
            String text = String.format("Cannot pay using %s. Proceeding ..", successor.calledClass);
            successor.pay(amountToPay);
        } else {
            throw new Exception("None of the accounts have enough balance");
    }
    }

    public boolean canPay(float amount)    {
        return balance >= amount;
    }
}
