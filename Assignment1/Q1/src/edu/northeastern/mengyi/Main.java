package edu.northeastern.mengyi;

//Write code in any language which will create 4 threads and run them in parallel.

public class Main {
    public static void main(String[] args) {
        //create 4 threads
        Thread T1 = new Thread(new ParallelTask(), "Thread 1");
        Thread T2 = new Thread(new ParallelTask(), "Thread 2");
        Thread T3 = new Thread(new ParallelTask(), "Thread 3");
        Thread T4 = new Thread(new ParallelTask(), "Thread 4");

        //start 4 threads
        T1.start();
        T2.start();
        T3.start();
        T4.start();
    }
}

class ParallelTask implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running");
    }
}
