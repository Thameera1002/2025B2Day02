package com.java.streamandlambda;

import java.util.Arrays;
import java.util.List;

public class Q2 {
    public static void main(String[] args) {
        //1,24,55,32,64,28,96,77,53,26
        List<Integer> numbers = Arrays.asList(1,24,55,32,64,28,96,77,53,26);
        System.out.println(numbers);
        //print even numbers as list
        List<Integer> evenNumbers= numbers.stream().filter(x-> x%2==0).toList();
        System.out.println(evenNumbers);
    }
}
