package com.learnJava.streams;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

public class CollectionsVsStreams {

    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();
        names.add("Adam");
        names.add("Jim");
        names.add("Jenny");

        Stream<String> namesStream = names.stream();
        namesStream.forEach(System.out::println);
        //namesStream.forEach(System.out::println); // a stream can only be used once

        names.stream().filter(name -> Objects.equals(name, "Adam")).forEach(System.out::println);
        names.stream().forEach(System.out::println);

        names.forEach(System.out::println);


    }
}
