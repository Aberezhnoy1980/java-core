package ru.home.functionInterface.predicate.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class First {
    // С помощью реализации Predicate<String> реализуйте удаление со списка строк
    // начинающихся с определенной буквы. Например удалить все строки которые начинаются на букву F.
    public static void main(String[] args) {

        String[] names = {"Anna", "Fatima", "Svetlana", "Tatiana", "Fekla", "Olga", "Frida", "Katerina"};
        List<String> namesList = new ArrayList<>(List.of("Anna", "Fatima", "Svetlana", "Tatiana", "Fekla", "Olga", "Frida", "Katerina"));

        List<String> arrayNames = Arrays.asList(names);
//        arrayNames.removeIf(name -> name.equalsIgnoreCase("anna"));

        List<String> sortedNames = new ArrayList<>(List.of(names));
        sortedNames.removeIf(name -> name.startsWith("T"));

        namesList.removeIf(name -> name.startsWith("F"));

        System.out.println(sortedNames);
        System.out.println(namesList);

    }
}
