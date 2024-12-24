package com.nikhil.ThreadPoolExecuter;

import java.util.concurrent.*;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                4,
                10,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(2),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread th = new Thread(r);
                        th.setPriority(Thread.NORM_PRIORITY);
                        th.setDaemon(false);
                        return th;
                    }
                },
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println("Task rejected " + r.toString());
                    }
                }
        );
        threadPoolExecutor.allowCoreThreadTimeOut(true);
//        for (int i = 1; i <= 7; i++) {
//            threadPoolExecutor.submit(() -> {
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    // handle exception here
//                }
//                System.out.println("Task executed by thread: " + Thread.currentThread().getName());
//            });
//        }
//        threadPoolExecutor.shutdown();

//        Future<?> future = threadPoolExecutor.submit(() -> {
//            try {
//                Thread.sleep(7000);
//                System.out.println("This is task which thread will execute");
//            } catch (InterruptedException ignored) {
//            }
//        });
//        System.out.println("is done: " + future.isDone());
//        try {
//            future.get(2, TimeUnit.SECONDS);
//        } catch (Exception e) {
//            System.out.println("Timeout exception occurred");
//        }
//        try {
//            future.get();
//        } catch (Exception ignored) {
//        }
//        System.out.println("is done: " + future.isDone());
//        System.out.println("is cancelled: " + future.isCancelled());
//
//        Future<Integer> future1 = threadPoolExecutor.submit(()->{
//            System.out.println("doing something");
//            return 45;
//        });
//
//        System.out.println("callable return: "+future1.get());

//        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
//        for (int i = 1; i <= 5; i++) {
//            Future<List<Integer>> future = threadPoolExecutor.submit(() -> list.add(10), list);
//        }
//        try {
//            if (!threadPoolExecutor.awaitTermination(1, TimeUnit.MINUTES)) {
//                threadPoolExecutor.shutdownNow();
//            }
//        } catch (InterruptedException e) {
//            threadPoolExecutor.shutdownNow();
//        }
//        System.out.println(list.size());
//        for (Integer i : list) {
//            System.out.print(i + " ");
//        }
//        System.out.println();

//        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
//            @Override
//            public String get() {
//                try {
//                    System.out.println("Thread name of supply async: "+Thread.currentThread().getName());
//                    Thread.sleep(5000);
//                } catch (InterruptedException ignored) {
//                }
//                return "task completed";
//            }
//        }, threadPoolExecutor).thenApply((String s)->{
//            System.out.println("Thread name of then supply: "+Thread.currentThread().getName());
//            return s + " nigger";
//        }).thenApplyAsync((String s)->{
//            System.out.println("Thread name of then supply async: "+Thread.currentThread().getName());
//            return s;
//        }).thenCompose((String s)->{
//            return CompletableFuture.supplyAsync(()->s+" nikhil");
//        }).thenComposeAsync((String s)->{
//            return CompletableFuture.supplyAsync(()->s+" nikhil");
//        });
//
//        // if you want ordering in async task, use thenCompose
//
//        CompletableFuture<Integer> asyncTask1 = CompletableFuture.supplyAsync(()->{
//            return 10;
//        }, threadPoolExecutor);
//
//        CompletableFuture<String> asyncTask2 = CompletableFuture.supplyAsync(()->{
//            return "20";
//        }, threadPoolExecutor);
//
//        CompletableFuture<Integer> asyncTask1Task2 = asyncTask2.thenCombine(asyncTask1, new BiFunction<String, Integer, Integer>() {
//            @Override
//            public Integer apply(String s, Integer integer) {
//                return integer+Integer.parseInt(s);
//            }
//        });
//
//        System.out.println(asyncTask1Task2.get());

//        ExecutorService poolExecuter = Executors.newFixedThreadPool(5);
//        poolExecuter.submit(()->"this is async task");
//
//        ExecutorService poolExecuter1 = Executors.newCachedThreadPool();
//        poolExecuter1.submit(()->"this is async task");
//
        ForkJoinPool pool = new ForkJoinPool();
        Future<Integer> submit = pool.submit(new ComputeSumTask(1, 10));
        System.out.println(submit.get());
    }

}