package com.nikhil.LockBasedConcurrency.LocksAndCondition.ProducerConsumerProblem;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {
    private final Queue<Integer> queue;
    private final Integer bufferSize;

    SharedResource(int bufferSize) {
        queue = new LinkedList<>();
        this.bufferSize = bufferSize;
    }

    public synchronized void produce(int item) throws InterruptedException {
        if (queue.size() == bufferSize) {
            System.out.println("Buffer is full, producer is waiting for consumer");
            wait();
        }
        queue.add(item);
        System.out.println("Produced item: " + item);
        notifyAll();
    }

    public synchronized Integer consume() throws InterruptedException {
        if (queue.isEmpty()) {
            System.out.println("Buffer is empty, waiting for producer to produce data");
            wait();
        }
        Integer currentItem = queue.poll();
        System.out.println("Consumer item: " + currentItem);
        notifyAll();
        return currentItem;
    }
}