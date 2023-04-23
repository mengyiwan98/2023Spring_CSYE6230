package edu.northeastern.mengyi;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance;
    private Lock lock;

    public BankAccount() {
        this.balance = 0;
        this.lock = new ReentrantLock();
    }

    public void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited " + amount + ". New balance: " + balance);
    }

    public void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ". New balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " cannot withdraw " + amount + ". Insufficient balance.");
        }
    }
}

