package com.bcsimulator;

import com.google.gson.GsonBuilder;
import java.util.Random;
public class Tasks {
    static Random r = new Random();
    //Short hand helper to turn Object into a json string
    public static String getJson(Object o) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(o);
    }
    public static void topology(){
        try{Thread.sleep(4000);}catch(InterruptedException e){System.out.println(e);}
    }
    public static void Wait(){
        try{Thread.sleep(2000);}catch(InterruptedException e){System.out.println(e);}
    }
    //Returns difficulty string target, to compare to hash.
    // For example: if given an difficulty value of 4 it will return "00000"
    public static String getDificultyString(int difficulty) {
        return new String(new char[difficulty]).replace('\0', '0');
    }
    static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        return r.nextInt((max - min) + 1) + min;
    }
    static void printInRed(String temp){
        System.out.println("\u001B[31m"+temp+"\u001B[0m");
    }
    static void printInGreen(String tempG){
        System.out.println("\u001B[32m"+tempG+"\u001B[0m");
    }
}
