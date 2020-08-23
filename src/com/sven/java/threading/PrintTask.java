package com.sven.java.threading;

import java.util.Random;

public class PrintTask implements Runnable{
    private final String name;
    private final int sleepTime;
    private final Random random = new Random();

    public PrintTask(String name){
        this.name = name;
        sleepTime = random.nextInt(5000);
    }

    @Override
    public void run() {
        try {
            System.out.printf("Thread %s is going to sleep for %d millisecond \n", name, sleepTime);
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            System.out.printf("Thread %s wurde frühzeitig unterbrochen \n", name);
            e.printStackTrace();
        }

        System.out.printf("Ende des Schlafens für Thread %s \n",name);
    }
}
