package com.learnJava.functionalInterfaces;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

    static Consumer<Student>  c1= p -> System.out.println(p);

    static Consumer<Student>  c2= p -> System.out.print(p.getName().toUpperCase());

    static Consumer<Student>  c3= p -> System.out.println(p.getActivities());

    static Consumer<Student> c4 = p -> System.out.println(p.getGender());

    static Consumer<String> cd = s -> System.out.println(s.toUpperCase());


    public static void printName(){

        List<Student> personList = StudentDataBase.getAllStudents();

        personList.forEach(c1);

    }

    public static void printNameAndActivities(){
        System.out.println("\nprintNameAndActivities : ");
        List<Student> personList = StudentDataBase.getAllStudents();
        personList.forEach(c2.andThen(c3));
    }

    public static void printNameAndActivitiesUsingCondition(){
        System.out.println("\nprintNameAndActivitiesUsingCondition : ");
        List<Student> personList = StudentDataBase.getAllStudents();
        personList.forEach(student -> {
            if (student.getGradeLevel() >= 3 && student.getGpa() > 3.9) {
                c2.andThen(c3).andThen(c4).accept(student);
            }
        });
//        personList.forEach((s) -> {
//            if( s.getGradeLevel()>=3 && s.getGpa()>3.9){
//                c2.andThen(c3).accept(s);
//            }
//        });
    }

    public static void main(String[] args) {

        Consumer<String> c1 = (s) -> System.out.println(s.toUpperCase());

        c1.accept("\njava8");

        printName();
        printNameAndActivities();
        printNameAndActivitiesUsingCondition();

        cd.accept("\nabc");





    }
}
