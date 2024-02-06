package ru.home.functionInterface.consumer.accept;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BySideEffectApp {
    // Побочный эффект функции (метода)- возможность функции в процессе выполнения:
    // читать и модифицировать значения глобальных переменных или полей класса; осуществлять операции ввода-вывода;
    // реагировать на исключительные ситуации, вызывать их обработчики.
    // Если вызвать функцию с побочным эффектом дважды с одним и тем же набором значений входных аргументов,
    // может случиться так, что в качестве результата будут возвращены разные значения.
    // Очень часто реализация этого интерфейса опирается именно на побочные эффекты.
    public static void main(String... args) {

        List<String> result = new ArrayList<>();

        String filter = "J";

        Consumer<String> cons = a -> {
            if (a.startsWith(filter)) {
                result.add(a);
            }
        };

        cons.accept("Java");
        cons.accept("Julia");
        cons.accept("Python");

        System.out.println(result);
    }
}
