package com.sven.java.threading.notsafe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SharedArrayTest {
    final boolean synchro;

    public SharedArrayTest(boolean synchro){
        this.synchro = synchro;
        SimpleArray simpleArray;
        if(synchro){
            simpleArray = new SimpleArraySynchro(6);
        }else{
            simpleArray = new SimpleArray(6);
        }

//        create two threads for arrayWriter:
        ArrayWriter writer1 = new ArrayWriter(1, simpleArray);
        ArrayWriter writer2 = new ArrayWriter(11, simpleArray);

        ExecutorService service = Executors.newCachedThreadPool();

        service.execute(writer1);
        service.execute(writer2);

        service.shutdown();

        try {
            boolean tasksEnded = service.awaitTermination(1, TimeUnit.MINUTES);

            if(tasksEnded){
                System.out.println(simpleArray);
            }else {
                System.out.println("Timed out while waiting for tasks to finish");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
