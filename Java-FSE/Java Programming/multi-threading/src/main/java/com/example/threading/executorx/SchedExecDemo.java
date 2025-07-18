package com.example.threading.executorx;

import java.util.concurrent.*;

public class SchedExecDemo {
    public static void main(String[] args) {
        ScheduledExecutorService sch1 = Executors.newScheduledThreadPool(2);

        sch1.schedule(() -> System.out.println("Hello"), 3, TimeUnit.SECONDS);

        sch1.shutdown();

        System.out.println(sch1.isTerminated());

        while(true){
            try {
                if (!!sch1.awaitTermination(1, TimeUnit.MILLISECONDS)) break;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

        System.out.println("All scheduled tasks done");
        System.out.println(sch1.isTerminated());

        try {
            sch1.schedule(
                    () -> System.out.println("Hello Again"),
                    3,
                    TimeUnit.SECONDS
            );
        } catch (RejectedExecutionException e) {
            System.out.println("Rejected execution, Executor has been used already");
        }


        ScheduledExecutorService sch2 = Executors.newScheduledThreadPool(2);

        sch2.scheduleAtFixedRate(() -> System.out.println("Hello from 2nd executor"), 5, 3, TimeUnit.SECONDS);

        sch2.schedule(() -> {
            System.out.println("Initiating executor shutdown");
            sch2.shutdown();
        }, 12, TimeUnit.SECONDS);

        ScheduledExecutorService sch3 = Executors.newScheduledThreadPool(4);

        // It starts the task one after another with a fixed delay
        sch3.scheduleWithFixedDelay(() -> System.out.println("Hello from 3rd executor"), 5, 3, TimeUnit.SECONDS);

        sch3.schedule(() -> {
            System.out.println("Initiating executor shutdown");
            sch3.shutdown();
        }, 21, TimeUnit.SECONDS);

        ExecutorService csh1 = Executors.newCachedThreadPool();

    }
}
