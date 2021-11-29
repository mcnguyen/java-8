package com.learnJava.defaults;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class DefaultMethodExample2 {

    static Comparator<Student> nameComparator = Comparator.comparing(Student::getName);
    static Comparator<Student> gpaComparator = Comparator.comparing(Student::getGpa); // nice overloaded!
//    static Comparator<Student> gpaComparator = Comparator.comparingDouble(Student::getGpa);
    static Comparator<Student> genderComparator = Comparator.comparing(Student::getGender);
    static Comparator<Student> gradeComparator = Comparator.comparing(Student::getGradeLevel);
    static Consumer<Student> studentConsumer = student -> System.out.println("student : " + student);

    public static void sortByName(List<Student> studentList) {
        studentList.sort(Comparator.comparing(Student::getName)); // inline
        studentList.sort(nameComparator); // Using a reference
        System.out.println("After Sort BY Name : ");
        studentList.forEach(studentConsumer);
    }

    public static void sortByGPA(List<Student> studentList) {
        studentList.sort(gpaComparator);
        System.out.println("After Sort BY GPA : ");
        studentList.forEach(studentConsumer);
    }

    public static void sortByGender_with_null_object() {
        List<Student> studentList = StudentDataBase.getAllStudents();
//        studentList.add(null); // why can't I add 'null' to the list?
        Comparator<Student> nullLast = Comparator.nullsFirst(genderComparator);
        studentList.sort(nullLast);
        System.out.println("After Sort By Gender : ");
        studentList.forEach(studentConsumer);
    }

    public static void comparatorChaining() {
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.sort(gradeComparator.thenComparing(nameComparator)); // Comparator chaining!
        System.out.println("Comparator Chaining List");
        studentList.forEach(studentConsumer);
    }

    public static void main(String[] args) {
        List<Student> studentList = StudentDataBase.getAllStudents();
        System.out.println("Original List");
        studentList.forEach(student -> System.out.println("student : " + student));
        sortByGender_with_null_object();
//        sortByName(studentList);
//        sortByGPA(studentList);
//        comparatorChaining();
    }
}
