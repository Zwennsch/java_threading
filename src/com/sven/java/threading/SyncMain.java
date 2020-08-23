package com.sven.java.threading;

import com.sven.java.threading.notsafe.SharedArrayTest;

public class SyncMain {

    public static void main(String[] args) {
//        new TaskExecutor();
        new SharedArrayTest(false);
        new SharedArrayTest(true);
    }
}
