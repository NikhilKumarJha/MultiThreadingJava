package com.nikhil.LockBasedConcurrency.LocksAndCondition.ThreadAndMonitorLock;

public class MultiThreadingByExtend extends Thread{

    @Override
    public void run(){
        System.out.println("code executed by thread: "+ Thread.currentThread().getName());
    }
}
