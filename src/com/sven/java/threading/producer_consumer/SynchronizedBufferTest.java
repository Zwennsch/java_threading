package com.sven.java.threading.producer_consumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedBufferTest {

    public static void main(String[] args) {
        int numProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("Number of processors: "+numProcessors);

        ExecutorService application = Executors.newCachedThreadPool();

        Buffer synchronizedBuffer = new SynchronizedBuffer();

        System.out.printf( "%-40s%s\t\t%s\n%-40s%s\n\n", "Operation",
                "Buffer", "Occupied", "---------", "------\t\t--------" );

        application.execute(new Producer(synchronizedBuffer));
        application.execute(new Consumer(synchronizedBuffer));

        application.shutdown();

    }
}
