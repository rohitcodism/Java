package com.example.threading;

/*
 * Thread Methods
 * 1. start()
 * 2. run()
 * 3. join()
 * 4. sleep()
 * 5. setPriority() -> MIN_PRIORITY = 1 (lowest priority), NORM_PRIORITY = 5 (mid priority), MAX_PRIORITY = 10 (max priority)
 * 6. interrupt()
 * 7. yeild()
 */

/*
 * User Thread: A user thread is a thread created by your program. It runs your main tasks.
 * Daemon Thread: A daemon thread is a background thread used by Java for tasks like garbage collection.
 */

class MyTestThread extends Thread {

    MyTestThread(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Utha diya mereko: " + e);
            }
            System.out.println(Thread.currentThread().getName() + " - Priority - " + Thread.currentThread().getPriority() +  " Value - " + i );
            Thread.yield();
        }
    }
}

class Majdoor extends Thread {
    @Override
    public void run(){
        for(int i = 0;i<100000;i++){
            System.out.println("Hello from Daemon");
        }
        System.out.println("Ignore kar diya");
    }
}

public class ThreadMethods {
    public static void main(String[] args) {
        MyTestThread lpTest = new MyTestThread("LP thread");
        MyTestThread mpTest = new MyTestThread("MP Thread");
        MyTestThread hpTest = new MyTestThread("HP Thread");
        
        // * setPriority()
        // lpTest.setPriority(Thread.MIN_PRIORITY);
        // mpTest.setPriority(Thread.NORM_PRIORITY);
        // hpTest.setPriority(Thread.MAX_PRIORITY);
        
        
        //lpTest.start();
        //mpTest.start();
        //hpTest.start();

        // * interrupt()
        // lpTest.interrupt();

        // * yeild()
        //MyTestThread t1 = new MyTestThread("Bhai");
        //MyTestThread t2 = new MyTestThread("Bro");

        //t1.start();
        //t2.start();

        // * setDaemon()
        Majdoor m1 = new Majdoor();
        m1.setDaemon(true);
        m1.start();

        System.out.println("Main end");


    }
}