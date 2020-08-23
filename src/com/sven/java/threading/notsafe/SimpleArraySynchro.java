package com.sven.java.threading.notsafe;

public class SimpleArraySynchro extends SimpleArray{
    public SimpleArraySynchro(int size) {
        super(size);
    }

    @Override
    public void add(int value) {
        synchrAdd(value);
    }

    private synchronized void synchrAdd(int value) {
        int position = writeIndex;
        try {
            Thread.sleep(SimpleArray.random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        arr[position] = value;
        System.out.printf("Thread %s wrote value %2d written to array at index %d\n", Thread.currentThread().getName(), value, position);

        writeIndex++;
        System.out.printf("New WriteIndex is: %d\n", writeIndex);
    }
}
