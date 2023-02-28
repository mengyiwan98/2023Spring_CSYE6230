package edu.northeastern.mengyi;

//Write code in any language which will write code to Multiply every value
// in an array with Random value between 0.1 to 0.9 Calculate the sum of
// the array in parallel and serial and compute the time difference.

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int arraySize = 1000000;
        int[] arr = new int[arraySize];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt();
        }

        // Calculate the sum in parallel
        long startP = System.currentTimeMillis();
        double sumParallel = calculateParallelSum(arr);
        long endP = System.currentTimeMillis();
        System.out.println("Parallel sum: " + sumParallel);
        System.out.println("Time for parallel: " + (endP - startP) + " ms");

        // Calculate the sum in serial
        long startS = System.currentTimeMillis();
        double sumSerial = calculateSerialSum(arr);
        long endS = System.currentTimeMillis();
        System.out.println("Serial sum: " + sumSerial);
        System.out.println("Time for serial: " + (endS - startS) + " ms");
    }

    public static double calculateParallelSum(int[] arr) {
        Random r = new Random();
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            double randomValue = 0.1 + r.nextDouble() * 0.8;
            sum += randomValue * arr[i];
        }
        return Arrays.stream(arr).parallel().sum();
    }

    public static double calculateSerialSum(int[] arr) {
        Random r = new Random();
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            double randomValue = 0.1 + r.nextDouble() * 0.8;
            sum += randomValue * arr[i];
        }
        return sum;
    }
}