package com.github.bzalyaliev.classes;

import java.lang.reflect.Constructor;
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
            System.out.println(field.getType() + " " + field.getName());
        }

        // create instance from outside
        //Object object = aClass.getDeclaredConstructor().newInstance();
        //System.out.println(object);

        // create array of types - needs to getDeclaredConstructor method
        Class types[] = new Class[fields.length];
        for (int i = 0; i < fields.length; i++) {
            types[i] = fields[i].getType();
        }

        // call not empty constructor from Human class with parameters types[]
        Constructor constructor = aClass.getDeclaredConstructor(types);
        for (Class parameterType : constructor.getParameterTypes()) {
            System.out.println(parameterType.getName());
        }

        // create instance and initialization fields from the CLI
        int intValue = 0;
        String stringValue = "";

        for (int i = 0; i < fields.length; i++) {
            if (types[i].getTypeName().equals("int")) {
                intValue = scanner.nextInt();
            } else if (types[i].getTypeName().equals("java.lang.String")) {
                stringValue = scanner.next();
            }
        }

        Object[] arguments = {intValue, stringValue};
        Object instance = constructor.newInstance(arguments);
        System.out.println(instance);
    }
}
