package com.nikhil.LockFreeConcurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class SharedResource {
    private AtomicInteger count = new AtomicInteger(0);

    void increment(){
        count.incrementAndGet();
    }

    int get(){
        return count.get();
    }
}
