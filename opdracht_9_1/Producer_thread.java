package com.jetbrains;
import java.util.ArrayList;
import java.util.Random;

/***
 * this class will add random numbers to the array as a thread
 *
 * @author Jeroen Weltens
 */
public class Producer_thread extends Thread {
    private ArrayList<Integer> arr;

    /**
     * @param array the array to put random numbers into
     */
    public Producer_thread(ArrayList<Integer> array){
        arr = array;
    }

    /**
     * The main functionality of the thread
     */
    public void run(){
        Random rand = new Random();
        int i = 0, rem = 100;
        while(i++ < rem){ //loop till "rem" is reached
            if(arr.size() >= 10){ //if array is full, let other thread work
                try{sleep(100);}catch (InterruptedException e){}
                System.out.println("prodcer sleeps");
            } else{
                arr.add(rand.nextInt(99000) + 1000);
                System.out.println("producer added number");
            }
        }
    }
}
