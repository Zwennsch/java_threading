package com.sven.java.threading.producer_consumer;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockingBuffer implements Buffer {

    private final ArrayBlockingQueue<Integer> buffer;

    public BlockingBuffer() {
        buffer = new ArrayBlockingQueue<>(1);
    }
    @Override
    public void setValue(int value) throws InterruptedException {
        buffer.put(value);
        System.out.printf( "%s%2d\t%s%d\n", "Producer writes ", value,
                "Buffer cells occupied: ", buffer.size() );
    }

    @Override
    public int getValue() throws InterruptedException {
        int readValue = buffer.take();
        System.out.printf( "%s %2d\t%s%d\n", "Consumer reads ",
                readValue, "Buffer cells occupied: ", buffer.size() );
        return readValue;
    }
}
