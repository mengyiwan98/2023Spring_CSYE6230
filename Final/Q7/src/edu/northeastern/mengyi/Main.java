package edu.northeastern.mengyi;

public class Main {

    public static void main(String[] args) {
	// write your code here
        BankAccount account = new BankAccount();
        Thread[] depositThreads = new Thread[4];
        Thread[] withdrawThreads = new Thread[5];
        // 4 threads adding money in the bank account
        for (int i = 0; i < depositThreads.length; i++) {
            depositThreads[i] = new Thread(() -> {
                for (int j = 0; j <= 4; j++) {
                    account.deposit(100);
                }
            }, "Deposit Thread " + (i + 1));
        }
        // 5 threads taking money out of the bank account
        for (int i = 0; i < withdrawThreads.length; i++) {
            withdrawThreads[i] = new Thread(() -> {
                for (int j = 0; j <= 5; j++) {
                    account.withdraw(100);
                }
            }, "Withdraw Thread " + (i + 1));
        }
        for (Thread thread : depositThreads) {
            thread.start();
        }

        for (Thread thread : withdrawThreads) {
            thread.start();
        }
    }
}
