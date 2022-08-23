package ru.geekbrains.patterns.decorator;

public class SimpleCoffee implements Coffee{
    @Override
    public double getCost() {
        return 10;
    }

    @Override
    public String getDescription() {
        return "Simple coffee";
    }
}
