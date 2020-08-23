package com.sven.java.threading.notsafe;

public class ArrayWriter implements Runnable{

    private final SimpleArray simpleArray;
    private final int startValue;
    public ArrayWriter(int startValue, SimpleArray array){
        this.simpleArray = array;
        this.startValue = startValue;
    }
    @Override
    public void run() {
        for(int i = startValue; i < startValue+3; i++){
            simpleArray.add(i);
        }
    }
}
