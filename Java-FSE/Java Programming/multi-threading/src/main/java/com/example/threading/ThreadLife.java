package com.example.threading;

/*
 * Thread Life Cycle:
 * - New
 * - Runnable: In Java, there is no separate "Running" state; "Runnable" means the thread is either running or ready to run.
 * - Blocked / Waiting
 * - Terminated
 */

 // * .join() -> this method tells the current thread to wait until the other thread terminates.

public class ThreadLife extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("ThreadLife is runnning.");
        try {
            Thread.sleep(2000);
            System.out.println("Okay! Now its your turn main");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        ThreadLife tl = new ThreadLife();
        System.out.println(tl.getState());

        tl.start();
        System.out.println(tl.getState());

        System.out.println(Thread.currentThread().getName()); // * Just because we are inside main method this will print main

        Thread.sleep(100);

        System.out.println(tl.getState());

        tl.join(); // * -> In this case tl.join() is executed by the main thread so the main thread will wait till tl thread terminates and then main will continue to execute.

        System.out.println(tl.getState());

        System.out.println("Roger that!...tl"); 
        /*
         * -> here first will print "Okay! Now its your turn main then" then "Roger that!...tl" will print. Because `main` will wait till `tl` finishes its execution
         */
    }
}