package ru.geekbrains.patterns.compisite;

import java.util.ArrayList;

public class Organization {

    protected ArrayList<Employee> employees;

    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public  float getNetSalaries()
    {
        float netSalary = 0;

        for (Employee employee : employees) {
            netSalary += employee.getSalary();
        }
        return netSalary;
    }
}
