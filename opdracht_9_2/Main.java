package com.jetbrains;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/***
 * program that calculates the faculties of an array of integers via threads
 *
 * @author Jeroen Weltens
 */
public class Main {

    /**
     * method to calculate all faculties of an array of integers via threading
     * @param lijstje the array of numbers to be converted
     * @return the converted array
     */
    private static ArrayList<Number> faculteitMultiplex(ArrayList<Number> lijstje){
        for(int i = 0; i < lijstje.size(); ++i){
            FacultyThread t = new FacultyThread(lijstje, i);
        }
        return lijstje;
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Number> lijstje = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            lijstje.add(i);
        }
        System.out.println(lijstje); // print before conversion
        faculteitMultiplex(lijstje);
        TimeUnit.MILLISECONDS.sleep(100); // wait for threads to finish
        System.out.println(lijstje); // print after conversion
    }
}
