package ru.home.functionInterface.predicate.training;

import java.util.ArrayList;
import java.util.List;

public class Second {
    // Используя реализацию Predicate<String> реализуйте удаление со списка строк,
    // строки первая буква которых задается отдельным массивом символов.
    // Например если этот массив содержит ['h','a','t'] то со списка стоит удалить все строки которые начинаются с этих букв.
    public static void main(String... args) {

        List<String> namesList = new ArrayList<>(List.of("Anna", "Fatima", "Svetlana", "Tatiana", "Fekla", "Olga", "Frida", "Katerina", "Zlata"));

        String[] prefix = {"A", "S", "K"};

        namesList.removeIf(Second::removeNameStartsWithPrefix);

        namesList.removeIf(name -> {
            for (var p : prefix) {
                if (name.startsWith(p))
                    return true;
            }
            return false;
        });

        System.out.println(namesList);
    }

    public static boolean removeNameStartsWithPrefix(String name) {
        String[] pref = {"F", "O", "T"};
        for (int i = 0; i < pref.length; i++) {
            if (name.startsWith(pref[i]))
                return true;
        }
        return false;
    }
}