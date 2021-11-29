package com.learnJava.streams_terminal;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;

public class StreamsPartitioningExample {

    public static void partitioningBy_1() {
        Predicate<Student> gpaPredicate = (student) -> student.getGpa() >= 3.8;
        BiPredicate<Student, Double> gpaBiPredicate = (student, gpa) -> student.getGpa() >= gpa;
        BiFunction<Student, Double, Boolean> gpaBiFunction = (student, gpa) -> student.getGpa() >= gpa;

        Map<Boolean, List<Student>> studentMap = StudentDataBase.getAllStudents()
                .stream()
//                .collect(partitioningBy(gpaPredicate));
                .collect(partitioningBy(s -> gpaBiPredicate.test(s, 3.8)));
//                .collect(partitioningBy(s -> gpaBiFunction.apply(s, 3.8)));

        System.out.println("studentMap : " + studentMap);
    }

    public static void partitioningBy_2() {
        Predicate<Student> gpaPredicate = (student) -> student.getGpa() >= 3.8;

        Map<Boolean, Set<Student>> studentMap = StudentDataBase.getAllStudents()
                .stream()
                .collect(partitioningBy(gpaPredicate, toSet()));

        System.out.println("studentMap : " + studentMap);
    }

    public static void partitioningBy_3() {
        Predicate<Student> gpaPredicate = (student) -> student.getGpa() >= 3.8;

        Map<Boolean, Map<String, List<String>>> studentMap = StudentDataBase.getAllStudents()
                .stream()
                .collect(partitioningBy(gpaPredicate, toMap(Student::getName, Student::getActivities)));

        System.out.println("studentMap : " + studentMap);
    }

    public static void main(String[] args) {
        partitioningBy_1();
        partitioningBy_2();
        partitioningBy_3();
    }
}
