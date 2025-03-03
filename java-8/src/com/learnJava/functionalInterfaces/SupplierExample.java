package com.learnJava.functionalInterfaces;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {

    public static Supplier<Student> studentSupplier = () -> {
        return new Student("Adam", 2, 4.0, "male", Arrays.asList("swimming", "basketball", "volleyball"));
    };

    public static Supplier<Student> anotherStudentSupplier = () ->
            new Student("Emily", 3, 3.9, "female", Arrays.asList("swimming", "basketball", "volleyball"));

    public static Supplier<List<Student>> allStudentsSupplier = () -> StudentDataBase.getAllStudents();

    public static void main(String[] args) {
        Student student = studentSupplier.get();
        System.out.println("Student is : " + student);

        System.out.println("Another student is : " + anotherStudentSupplier.get());

        System.out.println("Students are : " + allStudentsSupplier.get());
    }
}
