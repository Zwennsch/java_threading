package com.sven.java.threading.producer_consumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlockingBufferTest {

    public static void main(String[] args) {
        Buffer blockingBuffer = new BlockingBuffer();
        ExecutorService service = Executors.newCachedThreadPool();

        service.execute(new Consumer(blockingBuffer));
        service.execute(new Producer(blockingBuffer));

        service.shutdown();
    }
}
