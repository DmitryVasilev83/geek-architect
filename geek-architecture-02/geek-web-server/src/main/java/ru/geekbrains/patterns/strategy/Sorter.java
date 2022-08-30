package ru.geekbrains.patterns.strategy;

import java.util.Arrays;


public class Sorter {

    protected SortStrategy sorter;

    public Sorter(SortStrategy sorter) {
        this.sorter = sorter;
    }

    public Integer[] sort(Integer[] dataset)    {
        return sorter.sort(dataset);
    }

}
