package com.learnJava.optional;

import java.util.Optional;

public class OptionalOfEmptyNullableExample {

    public static Optional<String> ofNullable(){
       return  Optional.ofNullable("Hello");
    }

    public static Optional<String> of(){
        return  Optional.of("Hello");
       // return  Optional.of(null);
    }

    public static Optional<String> empty(){
        return  Optional.empty();
        // return  Optional.of(null);
    }

    public static void main(String[] args) {
        System.out.println(ofNullable());
        System.out.println(of());
        System.out.println(empty());

        // To print the enclosed object in the Optional, use 'orElse();
        // to specify a default action when the Optional is empty.
        System.out.println(ofNullable().orElse(""));
        System.out.println(of().orElse(""));
        System.out.println(empty().orElse(""));

        // Must call 'isPresent()' before calling 'get()'
        System.out.println(ofNullable().get());
        System.out.println(of().get());
        System.out.println(empty().get());
    }
}
