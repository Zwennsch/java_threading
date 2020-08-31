package com.sven.java.threading.producer_consumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CircularBufferTest {
    public static void main(String[] args) {

        CircularBuffer circularBuffer = new CircularBuffer();
        ExecutorService service = Executors.newCachedThreadPool();

        circularBuffer.displayState("Initial State");

        service.execute(new Consumer(circularBuffer));
        service.execute(new Producer(circularBuffer));

        service.shutdown();
    }
}
