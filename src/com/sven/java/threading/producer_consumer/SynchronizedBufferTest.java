package com.sven.java.threading.producer_consumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedBufferTest {

    public static void main(String[] args) {
        ExecutorService application = Executors.newCachedThreadPool();

        Buffer synchronizedBuffer = new SynchronizedBuffer();

        System.out.printf( "%-40s%s\t\t%s\n%-40s%s\n\n", "Operation",
                "Buffer", "Occupied", "---------", "------\t\t--------" );

        application.execute(new Producer(synchronizedBuffer));
        application.execute(new Consumer(synchronizedBuffer));

        application.shutdown();

    }
}
