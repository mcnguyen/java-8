package com.learnJava.defaults;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DefaultMethodsExample1 {

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("Adam", "Jenny", "Alex", "Eric", "Mike");

        /**
         * Prior Java 8
         */

       /* Collections.sort(stringList);

        System.out.println("Sorted list using Collections.Sort() : " +  stringList);
       */

        /**
         * Java 8
         * sort list elements by the sort method in the List object
         */
        stringList.sort(Comparator.naturalOrder());
        System.out.println("Sorted list : " + stringList);

        stringList.sort(Comparator.reverseOrder());
        System.out.println("Reverse Sorted list : " + stringList);
    }
}
