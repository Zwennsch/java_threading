package com.sven.java.threading.producer_consumer;

public interface Buffer {

    void setValue(int value) throws InterruptedException;

    int getValue() throws InterruptedException;
}
