package ru.home.reflection;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReflectionExample {
    public static void main(String[] args) throws Exception {
        Class<Cat> cl = Cat.class;
//        Class cl2 = Class.forName("ru.home.reflection.Cat.java");
//        Class cl3 = new Cat().getClass();
//        System.out.println(cl.getName());
//        System.out.println(cl.getSimpleName());

//        Method[] methods = cl.getMethods();
//        for (Method m : methods)
//            System.out.println(m);

//        Method[] declaredMethods = cl.getDeclaredMethods();
//        for (Method dm : declaredMethods)
//            System.out.println(dm);
//
//        Method add2 = cl.getDeclaredMethod("add", int.class, int.class);
//        System.out.println(add2);
//
//        Cat cat = new Cat();
//        int res = (int) add2.invoke(cat, 1, 2);
//        System.out.println(res);

//        Field[] fields = cl.getDeclaredFields();
//        for (Field f : fields)
//            System.out.println(f);

//        final Cat cat = new Cat(10, 1000);
//        Field field = cl.getField("publicD");
//        System.out.println(field.get(cat));
//        Field declaredField = cl.getDeclaredField("privateA");
//        declaredField.setAccessible(true);
//        System.out.println(declaredField.get(cat));

//        Field f = cl.getDeclaredField("publicD");
//        int mods = f.getModifiers();
//
//        System.out.println(Modifier.isPrivate(mods));
//        System.out.println(Modifier.isFinal(mods));
//        System.out.println(Modifier.isStatic(mods));

//        Constructor<Cat> constructor = cl.getConstructor(int.class, int.class);
//        Cat cat = constructor.newInstance(1, 2);

//        final ClassLoader urlForReflection = new URLClassLoader(new URL[]{new File("/Users/alex/Documents/Study/Practice/Java/java_core/java-core-03/urlForReflection").toURL()});
//        Class<?> humanClass = urlForReflection.loadClass("Human");
//        Object humanObject = humanClass.getConstructor(String.class).newInstance("Jack");
//        Method method = humanClass.getDeclaredMethod("greeting");
//        method.invoke(humanObject);
//
//        Map<String, String> map = new HashMap<>();
//        map.put("A", "B");
//        Field f = HashMap.class.getDeclaredField("table");
//        f.setAccessible(true);
//        System.out.println(f.trySetAccessible());
//
//        Field[] fields = HashMap.class.getDeclaredFields();
//        System.out.println(Arrays.toString(fields));


//        Object[] array = (Object[]) f.get(map);
//        System.out.println(Arrays.toString(array));
    }

}

