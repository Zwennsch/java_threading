package com.sven.java.threading.producer_consumer;

import java.util.Random;

public class Producer implements Runnable {
    private final Buffer sharedBuffer;
    private final static Random random = new Random();

    public Producer(Buffer sharedBuffer) {
        this.sharedBuffer = sharedBuffer;
    }

    @Override
    public void run() {
        int sum = 0;

        for (int counter = 1; counter <11; counter++){

            try {
                Thread.sleep(random.nextInt(3000));
                sharedBuffer.setValue(counter);
                sum+= counter;
                System.out.printf("\t\t\t%2d\n", sum);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Producer done producing\nTerminating Producer");
    }
}
