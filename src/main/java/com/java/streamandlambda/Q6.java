package com.java.streamandlambda;

import java.util.Arrays;
import java.util.List;

public class Q6 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> sqList = numbers.stream().map(x->x*x).toList();
        System.out.println(sqList);
    }
}
