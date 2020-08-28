package com.sven.java.threading.producer_consumer;

public class SynchronizedBuffer implements Buffer {

    private int buffer = -1;
    private boolean isOccupied = false;

    @Override
    public synchronized void setValue(int value) throws InterruptedException {
        while (isOccupied){
            System.out.println("Producer tries to write ");
            displayState("Buffer full, producer waits.");
            wait();
        }
        buffer  = value;

        isOccupied = true;
        displayState("producer writes "+buffer);
//        tell waiting threads to enter the runnable state:
        notifyAll();
    } //end method set; releases the lock on synchronizedBuffer


    @Override
    public synchronized int getValue() throws InterruptedException {

        while (!isOccupied){
            System.out.println("Consumer tries to read");
            displayState("Buffer empty, consumer waits.");
            wait();
        }
        isOccupied = false;

        displayState("consumer reads "+buffer);
        notifyAll();

        return buffer;
    }

    public void displayState(String state){
        System.out.printf("%-40s%d\t\t%b\n\n",state, buffer, isOccupied);
    }
}
