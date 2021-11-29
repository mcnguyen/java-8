package com.learnJava.defaults;

public class Client123 implements Interface1, Interface2, Interface3 {

    public static void main(String[] args) {
        Client123 client123 = new Client123();
        client123.methodA(); // resolves to child Interface Implementation
        client123.methodB();
        client123.methodC();
    }

    // Order of resolving the inheritance hierarchy
    // 1. the class that implements the interface
    // 2. the sub-interface that extends the interface
    // => 'methodA' in the class 'Client123' is invoked!

    // Note: 'default' keyword is NOT allowed in the class, but only in the interface
    public void methodA() { //overriding the default method in the implementation class.
        System.out.println("Inside method A " + Client123.class);
    }
}
