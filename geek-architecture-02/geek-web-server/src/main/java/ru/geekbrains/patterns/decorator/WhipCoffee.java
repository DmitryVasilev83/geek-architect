package ru.geekbrains.patterns.decorator;

public class WhipCoffee implements Coffee{

    protected Coffee coffee;

    public WhipCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    public double getCost()
    {
        return coffee.getCost() + 5;
    }

    public String getDescription()
    {
        return coffee.getDescription() + ", whip";
    }
}
