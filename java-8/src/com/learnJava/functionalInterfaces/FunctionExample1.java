package com.learnJava.functionalInterfaces;

public class FunctionExample1 {

    public static String appendDefault(String input){

        return FunctionExample.addSomeString.apply(input);
    }

    public static void main(String[] args) {

        String result = appendDefault("hello");
        System.out.println("Result after appending 'default': " + result);
    }

}
