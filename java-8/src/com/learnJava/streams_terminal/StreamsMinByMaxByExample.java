package com.learnJava.streams_terminal;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StreamsMinByMaxByExample {

    public static Optional<Student> minBy() {
        Optional<Student> studentOptional = StudentDataBase.getAllStudents().stream()
//                .min(Comparator.comparing(Student::getGpa));
                .collect(Collectors.minBy(Comparator.comparing(Student::getGpa)));

        return studentOptional;
    }

    public static Optional<Student> maxBy() {
        Optional<Student> studentOptional = StudentDataBase.getAllStudents().stream()
//                .max(Comparator.comparing(Student::getGpa));
                .collect(Collectors.maxBy(Comparator.comparing(Student::getGpa)));

        return studentOptional;
    }

    public static List<Student> maxByMultipleStudents() {
        // Find the first max GPA student
        List<Student> maxStudents = new ArrayList<>();
        Optional<Student> studentOptional = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.maxBy(Comparator.comparing(Student::getGpa)));

//        Student maxStudent = studentOptional.isPresent() ? studentOptional.get() : null;
        Student maxStudent = studentOptional.orElse(null);
        if (maxStudent != null) {
            // Find all max GPA student using the first maxGPA found above
            maxStudents = StudentDataBase.getAllStudents().stream()
                    .filter(student -> maxStudent.getGpa() == student.getGpa())
                    .collect(toList());

            System.out.println("Max GPA Students are : " + maxStudents);
        }

        return maxStudents;
    }

    public static void main(String[] args) {
        System.out.println(minBy());

        System.out.println(maxBy());

        System.out.println(maxByMultipleStudents());
    }
}
