package com.learnJava.methodreferences;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;
import com.learnJava.functionalInterfaces.SupplierExample;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class RefactorMethodReferenceExample {

    static Predicate<Student> predicateUsingLambda = (s) -> s.getGradeLevel()>=3;

    static Predicate<Student> predicateUsingMetRef = RefactorMethodReferenceExample::greaterThanGrade3;

    static BiPredicate<Student,Integer> predicateUsingMethodReference = RefactorMethodReferenceExample::greaterThanGrade;

    static public  boolean greaterThanGrade3(Student student){
        return student.getGradeLevel() >3;
    }

   static public  boolean greaterThanGrade(Student student,Integer grade){
        return student.getGradeLevel() >grade;
    }

    public static void main(String[] args) {
        System.out.println(predicateUsingLambda.test(StudentDataBase.studentSupplier.get()));

        System.out.println(predicateUsingMetRef.test(StudentDataBase.studentSupplier.get()));
        System.out.println(greaterThanGrade3(StudentDataBase.studentSupplier.get()));

        System.out.println(predicateUsingMethodReference.test(StudentDataBase.studentSupplier.get(),3));
        System.out.println(greaterThanGrade(StudentDataBase.studentSupplier.get(), 3));
    }
}
