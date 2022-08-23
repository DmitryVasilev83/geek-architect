package ru.geekbrains.patterns.compisite;

import java.util.ArrayList;

public class Developer implements Employee{


    protected float salary;
    protected String name;
    protected ArrayList<String> roles;

    public Developer(float salary, String name) {
        this.salary = salary;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setSalary(float salary) {

    }

    @Override
    public float getSalary() {
        return salary;
    }

    @Override
    public ArrayList<String> getRoles() {
        return roles;
    }
}
