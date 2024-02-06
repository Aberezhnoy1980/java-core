package ru.home.functionInterface.supplier.orElseGet;

import java.util.Optional;

public class OrElseGetApp {
    // public T orElseGet(Supplier<? extends T> supplier)
    // Если значение присутствует в Optional, возвращает значение, в противном случае возвращает результат,
    // полученный с помощью реализации Supplier.
    public static void main(String... args) {

        String[] names = new String[]{"Luke", "Darth", "Obi-Wan", "R2D2"};
        String firstLetter = "J";
        Optional<String> name = Optional.ofNullable(findByName(names, firstLetter));
        String result = name.orElseGet(() -> "Name not found. May the force be with you.");
        System.out.println(result);

    }

    public static String findByName(String[] names, String firstLetter) {
        for (String s : names) {
            if (s.startsWith(firstLetter)) {
                return s;
            }
        }
        return null;
    }
}
