package com.example.threading.executorx;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class InvokeDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Callable<Integer> c1 = () -> {
            System.out.println("Task 1");
            Thread.sleep(1000);
            return 1;
        };
        Callable<Integer> c2 = () -> {
            System.out.println("Task 2");
            Thread.sleep(1000);
            return 2;
        };
        Callable<Integer> c3 = () -> {
            System.out.println("Task 3");
            Thread.sleep(1000);
            return 3;
        };

        List<Callable<Integer>> ls = Arrays.asList(c1, c2, c3);
        //List<Future<Integer>> futures = null;
        try {
             Integer x = executorService.invokeAny(ls);

            System.out.println("Result "+x);
        } catch (ExecutionException | InterruptedException | CancellationException e) {
            System.out.println(e.getMessage());
        }

        /*
        for(Future<Integer> f : futures) {
            try {
                System.out.println(f.get());
            } catch (InterruptedException | ExecutionException | CancellationException e) {
                System.out.println(e.getMessage());
            } finally {
                executorService.shutdown();

                if (executorService.isTerminated()) {
                    System.out.println("Executor has been terminated");
                }
            }
        }
        */

        executorService.shutdown();
        if(executorService.isTerminated()){
            System.out.println("Executor has been terminated");
        }
        System.out.println("Hello World!");
    }
}
