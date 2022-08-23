package ru.geekbrains.patterns.adapter;

public class WildDogAdapter implements Lion{

    protected WildDog dog;

    public WildDogAdapter(WildDog wildDog) {
        this.dog = wildDog;
    }

    @Override
    public void roar() {
        dog.bark();

    }
}
