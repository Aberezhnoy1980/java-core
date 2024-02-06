package ru.home.functionInterface.predicate.isEqual;

import ru.home.functionInterface.predicate.common.Cat;
import ru.home.functionInterface.predicate.common.GetListOfCats;
import ru.home.functionInterface.predicate.common.ListOfCat;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class IsEqualMethodApp {
    // static <T> Predicate<T> isEqual(Object targetRef)
    // Возвращает предикат, который проверяет, равны ли два аргумента согласно
    // Objects.equals(Object, Object). Объект с которым будут сравниваться другие задается параметром targetRef
    public static void main(String[] args) {

        List<String> names = new ArrayList<>(List.of("Anna", "Ira", "Sveta", "Katia", "Anna", "Sveta", "Anna"));

        Predicate<String> pr = Predicate.isEqual("Anna");

        names.removeIf(pr);

        System.out.println(names);

        Predicate<String> pr2 = new NamePredicate<>("Sveta");

        names.removeIf(pr2);

        System.out.println(names);
    }

    static class NamePredicate<T> implements Predicate<T> {
        private final T baseElement;

        public NamePredicate(T baseElement) {
            super();
            this.baseElement = baseElement;
        }

        @Override
        public boolean test(T t) {
            return Objects.equals(t, baseElement);
        }
    }

}
