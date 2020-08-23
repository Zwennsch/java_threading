package com.sven.java.threading.notsafe;

import java.util.Arrays;
import java.util.Random;

public class SimpleArray { //Not Threadsafe!

    final int[] arr;
    int writeIndex = 0;
    static final Random random = new Random();

    public SimpleArray (int size){
        arr = new int[size];
    }

    public void add(int value){
        int position = writeIndex;
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        arr[position] = value;
        System.out.printf("Thread %s wrote value %2d written to array at index %d\n", Thread.currentThread().getName(), value, position);

        writeIndex++;
        System.out.printf("New WriteIndex is: %d\n", writeIndex);
    }

    @Override
    public String toString() {
        return "SimpleArray contents: " + Arrays.toString(arr);
    }
}
