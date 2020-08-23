package com.sven.java.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskExecutor {

    public TaskExecutor(){
        PrintTask task1 = new PrintTask("task1");
        PrintTask task2 = new PrintTask("task2");
        PrintTask task3 = new PrintTask("task3");

        System.out.println("Starting the executor \n");

        ExecutorService service = Executors.newCachedThreadPool();

        service.execute(task1);
        service.execute(task2);
        service.execute(task3);

        service.shutdown();

        System.out.println("End of main thread. Start tasks. \n");
    }
}
