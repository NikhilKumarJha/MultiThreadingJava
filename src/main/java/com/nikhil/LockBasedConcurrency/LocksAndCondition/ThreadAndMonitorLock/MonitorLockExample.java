package com.nikhil.LockBasedConcurrency.LocksAndCondition.ThreadAndMonitorLock;

public class MonitorLockExample {
    public synchronized void task1() {
        try {
            System.out.println("inside task1");
            Thread.sleep(10000);
        } catch (Exception e) {
            // exception handling
        }
    }

    public void task2() {
        System.out.println("task2, but before synchronized");
        synchronized (this) {
            System.out.println("task2, inside synchronized");
        }
    }

    public void task3() {
        System.out.println("task3");
    }
}
