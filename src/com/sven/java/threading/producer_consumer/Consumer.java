package com.sven.java.threading.producer_consumer;

import java.util.Random;

public class Consumer implements Runnable {
    private static final Random random = new Random();
    private final Buffer sharedBuffer;

    public Consumer(Buffer sharedBuffer) {
        this.sharedBuffer = sharedBuffer;
    }

    @Override
    public void run() {
        int sum = 0;

        for(int counter = 1; counter < 11; counter++){
            try {
                Thread.sleep(random.nextInt(3000));
                sum += sharedBuffer.getValue();
                System.out.printf("\t\t\t\t\t%2d\n", sum);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("\n%s %d\n%s\n", "Consumer read values totaling in sum:", sum, "Terminating Consumer");

    }
}
