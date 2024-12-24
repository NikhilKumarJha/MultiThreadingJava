package com.nikhil.LockBasedConcurrency.LocksAndCondition.ThreadAndMonitorLock;

public class MonitorLockRunnable implements Runnable{

    private final MonitorLockExample monitorLockExample;

    public MonitorLockRunnable(MonitorLockExample monitorLockExample) {
        this.monitorLockExample = monitorLockExample;
    }

    @Override
    public void run() {
        monitorLockExample.task1();
    }
}
