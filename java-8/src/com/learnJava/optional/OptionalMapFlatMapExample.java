package com.learnJava.optional;

import com.learnJava.data.Bike;
import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.Optional;

public class OptionalMapFlatMapExample {

    public static void optionalFlatMap() {
        Optional<Student> studentOptional = StudentDataBase.getOptionalStudent();
        if (studentOptional.isPresent()) {
            // must use 'flatMap' to reach the actual 'Bike' object wrapped inside
            // an Optional object nested in another already Optional object
            // e.g. 'bike' is an Optional inside the 'studentOptional'
            Optional<Bike> bikeOptional = studentOptional.flatMap(Student::getBike);
            System.out.println("bikeOptional : " + bikeOptional);
//            System.out.println("bikeOptional : " + bikeOptional.orElse(new Bike("No Bike", "No Bike")));
        }
    }

    public static void optionalFlatMap_in_lecture() {
        Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get()); // Error: no Bike object embedded
//        Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.getOptionalStudent().get());

        Optional<String> bikeName = studentOptional
                .filter(student -> student.getGpa() >= 3.5) // Optional< Student <Optional<Bike>> >
                .flatMap(Student::getBike) // Optional<Bike>
                .map(Bike::getName);

        bikeName.ifPresent(System.out::println);
    }

    public static void optionalMap() {
        Optional<Student> studentOptional = StudentDataBase.getOptionalStudent();

        if (studentOptional.isPresent()) {
            Optional<String> nameOptional = studentOptional.map(Student::getName);
            System.out.println("nameOptional : " + nameOptional);
//            System.out.println("nameOptional : " + nameOptional.orElse("No Name"));
        }
    }

    public static void optionalFilter() {
        Optional<Student> studentOptional = StudentDataBase.getOptionalStudent()
                .filter(student -> student.getGpa() >= 4.3);

        studentOptional.ifPresent(student -> System.out.println(student));
    }

    public static void optionalFilter_in_lecture() {
        Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());

        studentOptional
                .filter(student -> student.getGpa() >= 3.5)
                .ifPresent(System.out::println);
    }

    public static void main(String[] args) {
        optionalFlatMap();
        optionalFlatMap_in_lecture();
        optionalMap();
        optionalFilter();
        optionalFilter_in_lecture();
    }
}
