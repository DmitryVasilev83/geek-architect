package ru.geekbrains.patterns.decorator;

public class MilkCoffee implements Coffee{

    protected Coffee coffee;

    public MilkCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    public double getCost()
    {
        return coffee.getCost() + 2;
    }

    public String getDescription()
    {
        return coffee.getDescription() + ", milk";
    }
}
