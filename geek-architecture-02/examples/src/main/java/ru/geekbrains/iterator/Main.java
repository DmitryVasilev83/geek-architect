package ru.geekbrains.iterator;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

//        Iterable<String> strings = new Iterable<>() {
//
//            @Override
//            public Iterator<String> iterator() {
//                return new Iterator<>() {
//
//                    String[] arr = {"first", "second", "third"};
//
//                    int current = 0;
//
//                    @Override
//                    public boolean hasNext() {
//                        return current < arr.length;
//                    }
//
//                    @Override
//                    public String next() {
//                        return arr[current++];
//                    }
//                };
//            }
//        };

//        Iterable<Integer> nums = new Iterable<>() {
//
//            @Override
//            public Iterator<Integer> iterator() {
//                return new Iterator<>() {
//
//                    int[] arr = new int[3];
//
//                    int current = 0;
//
//                    @Override
//                    public boolean hasNext() {
//                        return current < arr.length;
//                    }
//
//                    @Override
//                    public Integer next() {
//                        int x = (int) (Math.random() * 10);
//                        arr[current] = x;
//                        return arr[current++];
//                    }
//                };
//            }
//        };

        NumsIterator numsIterator = new NumsIterator(3);
        Iterable<Integer> nums = numsIterator.getNums();

        for (Integer num : nums) {
            System.out.println(num);
        }

    }
}
