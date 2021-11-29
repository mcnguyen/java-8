package com.learnJava.defaults;

public class Client14 implements Interface1, Interface4 {

    public static void main(String[] args) {
        Client14 client14 = new Client14();
        client14.methodA();
    }

    // Note: when there is a conflict due to the same methods are
    // defaulted in multiple interfaces, the ONLY way to resolve
    // the conflict in Java 8 is to implement that conflicting
    // method in the class that implements the interfaces and then
    // call the default method in the desired interface.
    @Override
    public void methodA() {
        Interface1.super.methodA();
//        Interface4.super.methodA();
    }

    // It is also possible to override and provide the entirely new
    // method in the client class as well.
//    public void methodA() {
//        System.out.println("Inside method A " + Client14.class);
//    }
}
