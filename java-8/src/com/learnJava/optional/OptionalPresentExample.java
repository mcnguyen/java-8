package com.learnJava.optional;

import java.util.Optional;

public class OptionalPresentExample {

    public static void main(String[] args) {
        Optional<String> stringOptional = Optional.of("Hello Optional");
//        Optional<String> stringOptional = Optional.ofNullable(null);
//        Optional<String> stringOptional = Optional.empty();

        System.out.println(stringOptional.isPresent());

        if (stringOptional.isPresent()) {
            System.out.println(stringOptional.get());
        }

        stringOptional.ifPresent(s -> System.out.println("value is : " + s));
    }
}
