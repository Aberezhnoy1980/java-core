package ru.home.testhomework07.mytestapi;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

public class ClassTest {
    public static void start(Class<?> cl) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        Method[] methods = cl.getDeclaredMethods();
        Object object = cl.getDeclaredConstructor().newInstance();
        // @BeforeSuite handler
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].isAnnotationPresent(BeforeSuite.class)) {
                for (int j = i + 1; j < methods.length; j++) {
                    if (methods[j].isAnnotationPresent(BeforeSuite.class)) {
                        throw new RuntimeException("You can't use the @BeforeSuite annotation more than once");
                    }
                }
                int mods = methods[i].getModifiers();
                if (Modifier.isStatic(mods)) {
                    methods[i].invoke(null);
                } else {
                    // try to receive fields type and give them to constructor parameters
//                    Field[] fields = cl.getDeclaredFields();
//                    for (Field f : fields) {
//                        f.getType().
//                    }
                    // needs default constructor (public empty)
                    methods[i].invoke(object);
                }
            }
        }
        // @Test handler
        Map<Integer, Method> sortMapByPriority = new TreeMap<>();
        for (Method m : methods) {
            if (m.isAnnotationPresent(Test.class)) {
                sortMapByPriority.put(m.getAnnotation(Test.class).priority(), m);
            }
        }
        for (Map.Entry<Integer, Method> entry : sortMapByPriority.entrySet()) {
            int mods = entry.getValue().getModifiers();
            if (Modifier.isStatic(mods)) {
                entry.getValue().invoke(null);
            } else entry.getValue().invoke(object);
        }
        // @AfterSuite handler
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].isAnnotationPresent(AfterSuite.class)) {
                for (int j = i + 1; j < methods.length; j++) {
                    if (methods[j].isAnnotationPresent(AfterSuite.class)) {
                        throw new RuntimeException("You can't use the @AfterSuite annotation more than once");
                    }
                }
                int mods = methods[i].getModifiers();
                if (Modifier.isStatic(mods)) {
                    methods[i].invoke(null);
                } else methods[i].invoke(object);
            }
        }
    }

    public static void start(String className) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        Class<?> cl = Class.forName(className);
        Method[] methods = cl.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].isAnnotationPresent(BeforeSuite.class)) {
                for (int j = i + 1; j < methods.length; j++) {
                    if (methods[j].isAnnotationPresent(BeforeSuite.class)) {
                        throw new RuntimeException("You can't use the @BeforeSuite annotation more than once");
                    }
                }
                int mods = methods[i].getModifiers();
                if (Modifier.isStatic(mods)) {
                    methods[i].invoke(null);
                } else {
                    throw new RuntimeException("no Class instance to non static method invoke");
                }
            }
        }
        // @Test handler
        Map<Integer, Method> sortMapByPriority = new TreeMap<>();
        for (Method m : methods) {
            if (m.isAnnotationPresent(Test.class)) {
                sortMapByPriority.put(m.getAnnotation(Test.class).priority(), m);
            }
        }
        for (Map.Entry<Integer, Method> entry : sortMapByPriority.entrySet()) {
            int mods = entry.getValue().getModifiers();
            if (Modifier.isStatic(mods)) {
                entry.getValue().invoke(null);
            } else
                throw new RuntimeException("no Class instance to non static method invoke");
        }
        // @AfterSuite handler
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].isAnnotationPresent(AfterSuite.class)) {
                for (int j = i + 1; j < methods.length; j++) {
                    if (methods[j].isAnnotationPresent(AfterSuite.class)) {
                        throw new RuntimeException("You can't use the @AfterSuite annotation more than once");
                    }
                }
                int mods = methods[i].getModifiers();
                if (Modifier.isStatic(mods)) {
                    methods[i].invoke(null);
                } else
                    throw new RuntimeException("no Class instance to non static method invoke");
            }
        }
    }

    public static void start(Object obj) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        Class<?> cl = obj.getClass();
        Method[] methods = cl.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].isAnnotationPresent(BeforeSuite.class)) {
                for (int j = i + 1; j < methods.length; j++) {
                    if (methods[j].isAnnotationPresent(BeforeSuite.class)) {
                        throw new RuntimeException("You can't use the @BeforeSuite annotation more than once");
                    }
                }
                int mods = methods[i].getModifiers();
                if (Modifier.isStatic(mods)) {
                    methods[i].invoke(null);
                } else
                    methods[i].invoke(obj);
            }
        }
        // @Test handler
        Map<Integer, Method> sortMapByPriority = new TreeMap<>();
        for (Method m : methods) {
            if (m.isAnnotationPresent(Test.class)) {
                sortMapByPriority.put(m.getAnnotation(Test.class).priority(), m);
            }
        }
        for (Map.Entry<Integer, Method> entry : sortMapByPriority.entrySet()) {
            int mods = entry.getValue().getModifiers();
            if (Modifier.isStatic(mods)) {
                entry.getValue().invoke(null);
            } else
                entry.getValue().invoke(obj);
        }
        // @AfterSuite handler
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].isAnnotationPresent(AfterSuite.class)) {
                for (int j = i + 1; j < methods.length; j++) {
                    if (methods[j].isAnnotationPresent(AfterSuite.class)) {
                        throw new RuntimeException("You can't use the @AfterSuite annotation more than once");
                    }
                }
                int mods = methods[i].getModifiers();
                if (Modifier.isStatic(mods)) {
                    methods[i].invoke(null);
                } else
                    methods[i].invoke(obj);
            }
        }
    }
}