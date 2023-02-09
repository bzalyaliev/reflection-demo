package com.github.bzalyaliev;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        SomeClass someObject = new SomeClass();

        Class<SomeClass> someClassAsClass = (Class<SomeClass>) someObject.getClass();
        Field someField = someClassAsClass.getField("someField");
        System.out.println(someField.getType());

        // get all fields
        Field[] fields = someClassAsClass.getFields();
        for (Field field : fields) {
            System.out.println(field.getType() + " " + field.getName());
        }

        // initialization outside
        System.out.println(someObject.someField);
        someField.set(someObject, 10);
        System.out.println(someObject.someField);

        // how to access private fields
        Field somePrivateField = someClassAsClass.getDeclaredField("somePrivate");
        // set true for modify private fields
        somePrivateField.setAccessible(true);
        System.out.println(somePrivateField.getName());
        somePrivateField.set(someObject, "Ha-ha");
        System.out.println(someObject.getSomePrivate());

        // working with method
        Method someMethod = someClassAsClass.getMethod("test");
        System.out.println(someMethod.getName());
        someMethod.invoke(someObject);

    }
}
