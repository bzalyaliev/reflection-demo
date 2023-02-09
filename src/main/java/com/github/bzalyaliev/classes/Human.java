package com.github.bzalyaliev.classes;

public class Human {
    public int age;
    public String name;

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public Human() {
        this.age = 1;
        this.name = "DEFAULT_NAME";
    }
}
