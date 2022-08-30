package ru.geekbrains.patterns.observer;

import java.util.Observable;
import java.util.Observer;

public class JobSeeker implements Observer {
    @Override
    public void update(Observable observable, Object o) {

    }

    protected String name;

    public JobSeeker(String name) {
        this.name = name;
    }

    public void onJobPosted(JobPost job)    {
        // Do something with the job posting
        System.out.println("Hi " + name + "! New job posted: " + job.getTitle());

    }
}
