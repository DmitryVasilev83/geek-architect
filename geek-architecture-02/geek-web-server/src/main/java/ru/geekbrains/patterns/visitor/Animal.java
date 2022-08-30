package ru.geekbrains.patterns.visitor;

public interface Animal {
    public void accept(AnimalOperation operation);
}
