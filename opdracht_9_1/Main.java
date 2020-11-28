package com.jetbrains;

import java.util.ArrayList;

/**
 * program to generate random numbers and factorize them to primes, all via threads
 *
 * @author Jeroen Weltens
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>(10);
        Producer_thread p = new Producer_thread(arr);
        Consumer_thread c = new Consumer_thread(arr);
        p.start();
        c.start();
    }
}
