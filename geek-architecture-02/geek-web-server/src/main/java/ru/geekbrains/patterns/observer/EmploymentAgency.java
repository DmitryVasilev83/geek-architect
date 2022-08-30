package ru.geekbrains.patterns.observer;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class EmploymentAgency extends Observable {

    protected ArrayList<JobSeeker> observers = new ArrayList<>();

    protected void notify(JobPost jobPosting)    {
        for (JobSeeker obs: observers) {
            obs.onJobPosted(jobPosting);        }

    }


    public void attach(JobSeeker observer)    {
        observers.add(observer);
    }

    public void addJob(JobPost jobPosting)
    {
        notify(jobPosting);
    }
}
