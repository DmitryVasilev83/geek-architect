package ru.geekbrains.patterns.iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class StationList implements Iterator {

    protected ArrayList<RadioStation> stations = new ArrayList<>();

    public ArrayList<RadioStation> getStations() {
        return stations;
    }

    protected int counter;

    public void addStation(RadioStation station)    {
        stations.add(station);
    }

    public int count()    {
        return stations.size();
    }

    public RadioStation current()
    {
        return stations.get(counter);
    }

    public int key()    {
        return counter;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    public Integer next()    {
        return counter++;
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }

    public int rewind()    {
        return counter = 0;
    }

    public boolean valid()    {

        return stations.get(counter) != null;
    }

}
