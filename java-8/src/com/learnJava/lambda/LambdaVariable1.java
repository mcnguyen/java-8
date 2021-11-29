package com.learnJava.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdaVariable1 {


    public static void main(String[] args) {

        int i=0; //Repeated variable name not allowed
        //Consumer<Integer> c1 = (i) -> {    // error: lambda param "i" is the same as local variable "i"
        Consumer<Integer> c1 = (a) -> {
            //int i=0;      // error: lambda local var "i" is the same as outer local var "i"
            System.out.println(i);
        };

    }
}
