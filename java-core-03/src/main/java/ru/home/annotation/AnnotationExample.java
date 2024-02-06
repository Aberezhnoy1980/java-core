package ru.home.annotation;

import java.lang.reflect.Method;

public class AnnotationExample {
    public static void main(String[] args) throws Exception {
        Class<?> cl = DemoClass.class;
        Method[] methods = cl.getDeclaredMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(MyAnno.class)) {
                System.out.println("Method priority: " + m.getAnnotation(MyAnno.class).priority());
                m.invoke(null);
            }
        }
    }
}
