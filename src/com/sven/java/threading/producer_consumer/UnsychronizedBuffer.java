package com.sven.java.threading.producer_consumer;

public class UnsychronizedBuffer implements Buffer{

    private int value = -1;
    @Override
    public void setValue(int value) throws InterruptedException {
        System.out.printf("Producer sets %d", value);
        this.value = value;
    }

    @Override
    public int getValue() throws InterruptedException {
        System.out.printf("Consumer reads %d", value);
        return value;
    }
}
