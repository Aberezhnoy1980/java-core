package ru.home.functionInterface.supplier.training;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.List;
// import java.util.Optional;
// import java.util.function.Predicate;

public class Second {
    //Реализуйте Supplier<String> с помощью Predicate<String> реализующий следующий функционал: возвращать
    // из List<String> только строки соответствующие реализации Predicate. Например если у вас есть список
    // [«Hello», «world», «Java»], а Predicate возвращает true только если слово начинается с большой буквы,
    // ваша реализация Supplier должна последовательно вернуть «Hello», «Java» и после чего возвращать null (закончились подходящие значения).
    public static void main(String... args) {

        final List<String> strings = List.of("Hello", "world", "Java");

        Predicate<String> checkFirstChar = s -> s.substring(0, 1).matches("[A-Z]");


        for (String s : strings) {
            Supplier<String> sup = () -> checkFirstChar.test(s) ? s : null;
            System.out.println(sup.get());
        }

        for (Optional<String> s : findStrings(strings, checkFirstChar)) {
            System.out.println(s.orElseGet(() -> "Fuck!"));
        }

        for (String s : strings) {
            System.out.println(new FindStringsStartsWithUpperCase(s, checkFirstChar));
        }
    }

    public static List<Optional<String>> findStrings(List<String> strings, Predicate<String> checkFirstChar) {
        final List<Optional<String>> filteredStrings = new ArrayList<>();
        for (String s : strings) {
            if (checkFirstChar.test(s)) filteredStrings.add(Optional.ofNullable(s));
            else filteredStrings.add(Optional.empty());
        }
        return filteredStrings;
    }

}

class FindStringsStartsWithUpperCase implements Supplier<String> {
    private final String string;
    private final Predicate<String> checkFirstChar;

    public FindStringsStartsWithUpperCase(String string, Predicate<String> checkFirstChar) {
        this.string = string;
        this.checkFirstChar = checkFirstChar;
    }

    @Override
    public String get() {
        return checkFirstChar.test(string) ? string : null;
    }

    @Override
    public String toString() {
        return get();
    }
}

