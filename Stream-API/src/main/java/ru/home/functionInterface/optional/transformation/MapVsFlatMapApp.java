package ru.home.functionInterface.optional.transformation;

import ru.home.functionInterface.optional.common.Cat;

import java.util.Optional;

public class MapVsFlatMapApp {
    // Довольно проблематично отличить разницу между методами map и flatMap ведь оба возвращают Optional.
    // Разница заключается в том:
    // map — на основе значения генерирует новое значение. Стоит использовать когда нужно сослаться на метод который
    // принимает значение и возвращает значение.
    // flatMap — на основе значения генерируется новый Optional со значением.
    // Стоит использовать когда нужно сослаться на метод который принимает значение и возвращает Optional со значением.
    // По сути метод map для работы с кодом в котором не используется Optional, flatMap для работы с кодом в котором
    // методы его активно используют.
    public static void main(String... args) {

        final Cat cat = new Cat("Vaska", "Black");
        Optional<Cat> result = Optional.of(cat);

        Optional<Cat> repaintRegularCat = result.map(MapVsFlatMapApp::repaintRegularCat);
        Optional<Cat> repaintOptionalCat = result.flatMap(MapVsFlatMapApp::repaintOptionalCat);

        System.out.println(repaintRegularCat.orElse(cat));
        System.out.println(repaintOptionalCat.orElse(cat));
    }

    private static Optional<Cat> repaintOptionalCat(Cat cat) {
        return Optional.of(new Cat(cat.getName(), "Red"));
    }

    private static Cat repaintRegularCat(Cat cat) {
        return new Cat(cat.getName(), "White");
    }
}
