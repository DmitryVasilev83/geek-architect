package ru.geekbrains.patterns.compisite;

import java.util.ArrayList;
import java.util.List;

public interface Employee {

    public String getName();
    public void setSalary(float salary);
    public float getSalary();
    public ArrayList<String> getRoles();
}
