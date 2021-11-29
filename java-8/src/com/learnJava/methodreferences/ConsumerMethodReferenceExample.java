package com.learnJava.methodreferences;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.function.Consumer;

public class ConsumerMethodReferenceExample {

    /**
     * Class::instancemethod
     */
    static Consumer<Student> c0 = p -> System.out.println(p);
    static Consumer<Student> c1= System.out::println;


    /**
     * instance::instancemethod
     */
    static Consumer<Student> c2 = (student -> student.printListOfActivities());
    static Consumer<Student> c3 = (Student::printListOfActivities);

    public static void main(String[] args) {
        StudentDataBase.getAllStudents().forEach(c0);
        System.out.println();
        StudentDataBase.getAllStudents().forEach(c1);
        System.out.println();

        StudentDataBase.getAllStudents().forEach(c2);
        System.out.println();
        StudentDataBase.getAllStudents().forEach(c3);
    }

}
