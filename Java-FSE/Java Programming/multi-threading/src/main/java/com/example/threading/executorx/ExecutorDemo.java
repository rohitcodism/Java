package com.example.threading.executorx;

// Excecutor Framework was introduced on Java 5
// It is used to build concurrent applications
// It abstracts away the complexity of creating and managing threads

/*
* The disadvantages of Manual Multithreading is
* Manual thread management overhead
* Resource Management overhead
* Scalability Issues
* Thread reuse
* Error Handling
*/

/*
    * Executor Framework has three different section
    * 1. Executor
    * 2. ExecutorService
    * 3. ScheduledExecutorService
*/

// * .execute() method does not return anything its just void, it is used for fire-and-forget tasks
// * .submit() method returns a future object, it is used when we need the result of the task or any feedback regarding the task or even if we want to cancel it

/*
    * future.get() is a blocking call it can lead to high latency and effect the performance of the application
 */

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorDemo {
    public static void main(String[] args) {
        // Thread[] threads = new Thread[10]; // -> No Reuse of threads and also manual resource management overhead

        // Using Executors Framework
        ExecutorService executorService = Executors.newFixedThreadPool(9);

        // Single Thread creation
        ExecutorService singleExecutor = Executors.newSingleThreadExecutor();
        long startTime = System.currentTimeMillis();
        for(int i = 1; i <= 10;i++){
            final int finalli = i;

            Future<?> future = executorService.submit((Runnable) () -> System.out.println(factorial(finalli)),
                    "Success");

            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        // Shut down the service if we do not need it
        executorService.shutdown();

        System.out.println(executorService.isShutdown());

        try{
           // executorService.awaitTermination(100, TimeUnit.SECONDS); // Timed waiting

            while(!executorService.isTerminated()){ // Infinite Waiting

            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            Thread.currentThread().interrupt();
        }

        System.out.println("Time needed: "+(System.currentTimeMillis() - startTime));

        // Invoking tasks

    }

    public static int factorial(int n) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (n < 0) {
            throw new IllegalArgumentException("Number must be non-negative");
        }
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
