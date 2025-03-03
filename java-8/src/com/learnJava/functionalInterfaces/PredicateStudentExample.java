package com.learnJava.functionalInterfaces;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateStudentExample {

    static Predicate<Student> p1 = (s) -> s.getGradeLevel() >= 3;
    static Predicate<Student> grade3AndAbove = p1;

    static Predicate<Student> p2 = (s) -> s.getGpa() >= 3.9;
    static Predicate<Student> gpaAtLeast39 = p2;

    // Notes: A function that accept an integer and returns a predicate of integer
    static Function<Integer, Predicate<Integer>> gradePredicate = toCompare -> {
        System.out.println("toCompare: " + toCompare);
        return number -> {
            System.out.println("number: " + number);
            return number > toCompare;
        };
    };
    static Function<Double, Predicate<Double>> gpaPredicate = (toCompare) -> (number) -> number > toCompare;


    public static void main(String[] args) {

        List<Student> studentList = StudentDataBase.getAllStudents();

        List<Student> grade3AndAbove = studentList.stream()
                .filter(PredicateStudentExample.grade3AndAbove)
                .collect(Collectors.toList());
        System.out.println("Grade 3 and Above : " + grade3AndAbove);


        System.out.println("Grade 3 and Above (verified) : ");
        studentList.forEach((student -> {
            if (PredicateStudentExample.grade3AndAbove.test(student)) {
                System.out.println(student);
            }
        }));


        boolean result = gradePredicate.apply(2).test(5) && gpaPredicate.apply(3.6).test(3.9);
        System.out.println("Result from Predicate : " + result);

    }
}
