package com.sven.java.threading.producer_consumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SharedBufferTest {

    public static void main(String[] args) {
        UnsychronizedBuffer buffer = new UnsychronizedBuffer();

        ExecutorService service = Executors.newCachedThreadPool();

        System.out.println(
                "Action\t\tValue\tSum of produced\tSum of consumed"
        );
        System.out.println(
                "------\t\t-----\t---------------\t---------------\n"
        );

        service.execute(new Producer(buffer));
        service.execute(new Consumer(buffer));

        service.shutdown();

        System.out.println("Simple Test for git on Asus-PC");
    }
}
