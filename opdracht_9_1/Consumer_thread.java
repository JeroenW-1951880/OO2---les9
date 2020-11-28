package com.jetbrains;
import java.util.ArrayList;

/***
 * this class will factorize the numbers in the array as a thread
 *
 * @author Jeroen Weltens
 */
public class Consumer_thread extends Thread {
    private ArrayList<Integer> arr;

    /**
     * @param array the array where the consumer will take the numbers to process from
     */
    Consumer_thread(ArrayList<Integer> array){
        arr = array;
    }

    /**
     * The main functionality of the thread
     */
    public void run(){
        int i = 0, rem = 100;
        while(i++ < rem){ //loop till "rem" is reached
            if (arr.size() == 0){ //if array is empty, let other thread work
                try{sleep(100);}catch (InterruptedException e){}
                System.out.println("consumer sleeps");
            } else {
                factorize(arr.remove(0));
            }
        }
    }

    /**
     * method to factorize a number to primes
     * @param number the number to factorize
     * @pre number > 0
     */
    private void factorize(int number){
        String output = number + ": ";
        int currentprime = 2;
        while(number != 1){
            if(number % currentprime == 0){
                number /= currentprime;
                output += currentprime + ", ";
            } else {
                while(!isPrime(++currentprime)){}
            }
        }
        System.out.println(output);
    }

    /***
     * method to check if a number is a prime number
     * @param n the number to check
     * @return boolean representing the result
     */
    private boolean isPrime(int n) {
        for(int i=2;i<n;i++) {
            if(n%i==0)
                return false;
        }
        return true;
    }
}
