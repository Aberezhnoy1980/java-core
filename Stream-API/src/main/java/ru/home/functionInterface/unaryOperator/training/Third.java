package ru.home.functionInterface.unaryOperator.training;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class Third {
    //Создайте реализацию UnaryOperator<List<String>> где результатом будет список строк
    // (созданный на основе списка выступающего в качестве параметра) длинна которых больше 5 символов.
    public static void main(String[] args) {

        List<String> strings = new ArrayList<>(List.of("Java", "Python", "Fortran", "PHP", "JavaScript", "CQL", "Ruby"));
        List<String> strings1 = new ArrayList<>(List.of("Java", "Python", "Fortran", "PHP", "JavaScript", "CQL", "Ruby"));
        List<String> strings2 = new ArrayList<>(List.of("Java", "Python", "Fortran", "PHP", "JavaScript", "CQL", "Ruby"));

        UnaryOperator<List<String>> lengthLimit = Third::getStringsWithLimitedLength;

        Predicate<String> lengthCheck = s -> s.length() > 5;

        System.out.println(lengthLimit.apply(strings));

        strings1.removeIf(lengthCheck);
        System.out.println(strings);

        strings2.removeIf(checkLength().negate());
        System.out.println(strings);
    }

    private static List<String> getStringsWithLimitedLength(List<String> strings) {
        List<String> stringsWithLimitedLength = new ArrayList<>();
        for (String s : strings) {
            if (checkLength().test(s)) stringsWithLimitedLength.add(s);
        }
        return stringsWithLimitedLength;
    }

    private static Predicate<String> checkLength() {
        return s -> s.length() > 5;
    }
}
