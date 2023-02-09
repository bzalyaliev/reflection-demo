package com.github.bzalyaliev;

public class SomeClass {

    public int someField;
    public String someStringField;
    private String somePrivate;

    public String getSomePrivate() {
        return somePrivate;
    }

    public static void main(String[] args) {
        System.out.println("Hello, I am method main()");
    }

    public void test() {
        System.out.println("Hello, I am method test()");
    }
}


