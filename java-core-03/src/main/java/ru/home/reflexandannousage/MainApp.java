package ru.home.reflexandannousage;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class MainApp {
    public static void main(String[] args) {
        System.out.println(prepareCreateTableAQL(Cat.class));
        System.out.println(prepareCreateTableAQL(User.class));

    }

    // 'CREATE TABLE cats (id INTEGER, name TEXT);'
    public static String prepareCreateTableAQL(Class<?> cl) {
        if (!cl.isAnnotationPresent(AppTable.class)) {
            throw new IllegalArgumentException("Класс не предназначен для авто-генерации запроса CREATE TABLE");
        }

        Map<Class<?>, String> typeMapper = new HashMap<>();
        typeMapper.put(String.class, "TEXT");
        typeMapper.put(int.class, "INTEGER");
        StringBuilder sb = new StringBuilder("CREATE TABLE ");
        // 'CREATE TABLE '
        sb.append(cl.getAnnotation(AppTable.class).title());
        // 'CREATE TABLE cats'
        sb.append(" (");
        // 'CREATE TABLE cats ('
        Field[] fields = cl.getDeclaredFields();
        for (Field f : fields) {
            if (f.isAnnotationPresent(AppField.class)) {
                sb.append(f.getName()).append(" ").append(typeMapper.get(f.getType())).append(", ");
            }
        }
        // 'CREATE TABLE cats (id INTEGER, name TEXT, '
        sb.setLength(sb.length() - 2);
        // 'CREATE TABLE cats (id INTEGER, name TEXT'
        sb.append(");");
        // 'CREATE TABLE cats (id INTEGER, name TEXT);'
        return sb.toString();
    }
}
