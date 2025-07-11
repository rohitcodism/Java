package com.example.threading;

import java.util.stream.Stream;

// * A process is an instance of a program that is being executed, when a program runs , the operating system createsa process to manage its execution

// * Example -> When we open MS Word it becomes a process in the operating system.

// * A thread is the smallest unit of execution within a process. A process can have multiple threads, which share same resources but can run independently.

// * For example -> Google chrome can use multiple thread for different tabs, with each tab running as a seperate thread

// * Multitasking allows an operating system to run multiple processes simultaneously. On single-core CPUs, this is done through time-sharing, rapidly switching between tasks. On multi-core CPUs, true parallel execution occurs, with tasks distributed across cores. The OS scheduler balances the load, ensuring efficient and responsive system performance.

// * Multithreading refers to the ability to execute multiple threads within a single process concurrently.

// * Multithreading enhances the efficiency of multitasking by breaking down individual tasks into smaller sub-tasks or threads. These threads can be processed simultaneously making better use of the CPU's capabilities.

// * In a single-core system: Both threads and processes are managed by the OS shceduler through time slicing and context switching to create the illusion of simultaneous execution.

// * In a multi-core system: Both threads and processes can run in true parallelism in different cores, with the OS shceduler distributing tasks across the cores to optimize performance.

// * Time Slicing -> It divides CPU time into smaller intervals called time slices or quanta

// * The OS scheduler allocates these time slices to different processes and threads, ensuring each gets a fair share of CPU time.

// * This prevents any single process or thread from monopolizing the CPU, improving responsiveness and enabling concurrent execution

// * Multitasking can be achieved through multithreading, Multitasking is more granular than multitasking.

// * Multithreading works on thread level, whereas multitasking works on process level

// * Multitasking involves managing resources between completely sepearate programs, which may have independent memory spaces and system resources

// * Multithreading involves managing resources within a single program, where threads share the same memory and resources

// * Java's multithreading capabilities are part of java.lang package making it easy to implement concurrent execution

// * In a single-core environment, Java's multithreading is managed by the JVM and the OS, which switch between threads to give the illusion of concurrency. The threads share the single core and time-slicing is used to manage thread execution

// * When a Java program starts, one thread begins running immediately, which is called main thread. This thread is responsible for executing the main method of a program

public class ThreadBasics {
    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println(Thread.currentThread().getName());

        // * To create a new thread in java we can either extend Thread class or
        // implement Runnable interface

        Test t1 = new Test();

        Bolt b1 = new Bolt();

        // * t1.run(); // * -> output main then 1 2 3 4 5 6 7 8 9 10, because this .run() method does not start a new thread its just execute like a normal so the thread remains the same

        t1.start(); // * -> output Thread-0 then 1 2 3 4 5 6 7 8 9 10, because this is proper way of creating a new thread, .start() method internally calls the .run() method after creating a new thread

        // * If we want to create a new thread by implementing Runnable Interface then we can do it by following

        // * We have to create a new Thread object then pass the object of the class that implements Runnable to the constructor of the new Thread object then we csn1
        Thread th1 = new Thread(b1);

        th1.start(); // * output Thread-1 then 1 2 4 8 16 32 64 128 256 512

    }
}

class Test extends Thread {
    @Override
    public void run() {
        System.out.println("Test: "+Thread.currentThread().getName());
        for (int i : Stream.iterate(1, x -> x + 1).limit(10).toList()) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {

        Test t1 = new Test();

        t1.start();
    }
}

class Bolt implements Runnable {
    @Override
    public void run() {
        System.out.println("Bolt: "+Thread.currentThread().getName());
        for (int i : Stream.iterate(1, x -> x * 2).limit(10).toList()) {
            System.out.println(i);
        }
    }
}