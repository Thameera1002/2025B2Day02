package com.java.streamandlambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q5 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Dilmi","Oshadhi","Lochi","Osindu");
        List<String> namesStartsWithO= names.stream().filter(x->x.startsWith("O")).toList();
        System.out.println(namesStartsWithO);
    }
}
