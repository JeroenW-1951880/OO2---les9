package com.jetbrains;

import java.util.ArrayList;

/***
 * class that calculates the faculty of an array element as a thread
 *
 * @author Jeroen Weltens
 */
public class FacultyThread extends Thread {
    private ArrayList<Number> m_numbers;
    private int m_index;

    /**
     * constructor that also lets the thread run
     * @param numbers array of numbers to be converted
     * @param index the index of the number to convert
     * @pre 0 <= index < numbers.size()
     */
    public FacultyThread(ArrayList<Number> numbers, int index){
        m_numbers = numbers;
        m_index = index;
        start();
    }

    /**
     * method that calculates the faculty
     */
    public void run(){
        int result = (int)m_numbers.get(m_index),  copy = result - 1;
        while(copy > 0){
            result *= copy;
            copy--;
        }
        m_numbers.set(m_index, result);
        System.out.println("index " + m_index + " is done"); // let know that the thread is done
    }
}
