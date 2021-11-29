package com.learnJava.streams_terminal;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.stream.Collectors;

public class StreamsSumAvgExample {

    public static int sum() {
        int totalNoOfNotebooks = StudentDataBase.getAllStudents()
                .stream()
//                .mapToInt(Student::getNoteBooks).sum();
                .collect(Collectors.summingInt(Student::getNoteBooks));

        return totalNoOfNotebooks;
    }

    public static double average() {
        double totalNoOfNotebooks = StudentDataBase.getAllStudents()
                .stream()
//                .mapToInt(Student::getNoteBooks).average(); // error: average() returns OptionalDouble
                .collect(Collectors.averagingInt(Student::getNoteBooks));

        return totalNoOfNotebooks;
    }

    public static void main(String[] args) {
        System.out.println("Total no of Notebooks : " + sum());

        System.out.println("Average no of Notebooks : " + average());
    }
}
