package com.java.streamandlambda;

import java.util.Arrays;
import java.util.List;

public class Q3 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Dilmi","Oshadhi","Lochi","Osindu");
        System.out.println(names);
        List<String> newNames =names.stream().map(String::toUpperCase).toList();
        System.out.println(newNames);
    }
}
