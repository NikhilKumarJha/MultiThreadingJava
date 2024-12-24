package com.nikhil.LockBasedConcurrency.LocksAndCondition.Condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    private boolean isAvailable = false;
    private static final ReentrantLock reentrantLock = new ReentrantLock();
    private static final Condition condition = reentrantLock.newCondition();

    public void consumer() {
        try {
            reentrantLock.lock();
            System.out.println("Producer Lock acquired by: " + Thread.currentThread().getName());
            if (isAvailable) {
                System.out.println("Producer thread is waiting: " + Thread.currentThread().getName());
                condition.await();
            }
            isAvailable = true;
            condition.signalAll();
        } catch (Exception e) {
            // handle exception here
        } finally {
            reentrantLock.unlock();
            System.out.println("Producer lock released by: " + Thread.currentThread().getName());
        }
    }

    public void producer() {
        try {
            Thread.sleep(1000);
            reentrantLock.lock();
            System.out.println("Consumer Lock acquired by: " + Thread.currentThread().getName());
            if (!isAvailable) {
                System.out.println("Consumer thread is waiting: " + Thread.currentThread().getName());
                condition.await();
            }
            isAvailable = false;
            condition.signalAll();
        } catch (Exception e) {
            // handle exception here
        } finally {
            reentrantLock.unlock();
            System.out.println("Consumer lock released by: " + Thread.currentThread().getName());
        }
    }
}
