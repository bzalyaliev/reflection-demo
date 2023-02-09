package com.github.bzalyaliev.classes;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Scanner scanner = new Scanner(System.in);
        String className = scanner.next();

        // по имени класса получаем объект типа Class
        Class aClass = Class.forName(className);

        Field fields[] = aClass.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        // create instance from outside
        Object object = aClass.getDeclaredConstructor().newInstance();
        System.out.println(object);

    }
}
