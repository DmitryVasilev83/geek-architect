package ru.geekbrains.iterator;

import java.util.Iterator;

public class NumsIterator implements Iterable {

    private Integer count;

    public NumsIterator(Integer count) {
        this.count = count;
    }

    Iterable<Integer> nums = new Iterable<>() {

        @Override
        public Iterator<Integer> iterator() {
            return new Iterator<>() {

                int[] arr = new int[count];

                int current = 0;

                @Override
                public boolean hasNext() {
                    return current < arr.length;
                }

                @Override
                public Integer next() {
                    int x = (int) (Math.random() * 10);
                    arr[current] = x;
                    return arr[current++];
                }
            };

        }
    };

    public Iterable<Integer> getNums(){
        return nums;
    }


    @Override
    public Iterator iterator() {
        return null;
    }
}
