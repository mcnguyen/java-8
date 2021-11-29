package com.learnJava.numericstreams;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreamBoxingUnboxingExample {

    // Boxing: Converting primitive int's to wrapper Integer
    public static List<Integer> boxing() {
        return IntStream.rangeClosed(1, 25) // IntStream, aka Stream<int>
                .boxed() //Stream<Integer>
                //all the elements will be passed one by one to get to the result as the collection.
                .collect(Collectors.toList());
    }

    // Unboxing: Converting wrapper Integer to primitive int
    public static int unBoxing(List<Integer> integerList) { // List<Integer>
        int sum = integerList.stream() // Stream<Integer>
                .mapToInt(Integer::intValue) // IntStream, aka Stream<int>
                .sum(); // int's are summable
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Converting PrimitiveStream to List : " + boxing());

        List<Integer> integers = boxing();
        System.out.println("Sum using Unboding : " + unBoxing(integers));
    }
}
