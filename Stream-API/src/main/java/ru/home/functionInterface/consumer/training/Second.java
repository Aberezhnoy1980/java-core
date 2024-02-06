package ru.home.functionInterface.consumer.training;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Second {
    // Реализуете Consumer<String> с побочным эффектом в виде занесения всех строк содержащих цифры во вспомогательный список.
    public static void main(String... args) {

        List<String> stringList = List.of("Java", "PHP12", "Python", "JS9", "Fortran", "Ruby34", "99");

        List<String> extStringList = new ArrayList<>();

        Predicate<String> checkStringForDigit = s -> s.matches("(.*[0-9]+.*)"); // \b\\w*\\d+\\w*,?\\b

        Consumer<String> cons = s -> {
            if(checkStringForDigit.test(s)) extStringList.add(s);
        };

        stringList.forEach(cons);

        System.out.println(extStringList);
    }

}
