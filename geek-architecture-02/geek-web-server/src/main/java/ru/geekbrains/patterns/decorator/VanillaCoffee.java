package ru.geekbrains.patterns.decorator;

public class VanillaCoffee implements Coffee{

    protected Coffee coffee;

    public VanillaCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    public double getCost()
    {
        return coffee.getCost() + 3;
    }

    public String getDescription()
    {
        return coffee.getDescription() + ", vanilla";
    }
}
