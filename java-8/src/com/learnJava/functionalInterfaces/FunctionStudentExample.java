package com.learnJava.functionalInterfaces;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionStudentExample {

    static Function<List<Student>, Map<String, Double>> mapGrade3AndAboveFunction = students -> {
        Map<String, Double> studentGradeMap = new HashMap<>();

        students.forEach(student -> {
            if (PredicateStudentExample.grade3AndAbove.test(student)) {
                studentGradeMap.put(student.getName(), student.getGpa());
            }
        });

        return studentGradeMap;
    };

    public static void main(String[] args) {
        System.out.println(mapGrade3AndAboveFunction.apply(StudentDataBase.getAllStudents()));
    }
}
