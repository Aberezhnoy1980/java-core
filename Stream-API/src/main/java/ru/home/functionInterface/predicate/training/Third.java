package ru.home.functionInterface.predicate.training;

import ru.home.functionInterface.predicate.common.Cat;
import ru.home.functionInterface.predicate.common.SqliteDataBase;

import java.util.List;
import java.util.function.Predicate;

public class Third {
    // Используя реализацию Predicate<Cat> (в качестве Cat взять класс используемый в лекции)
    // и методы для логических функций, реализуйте удаление из списка Cat котов
    // возраст которых меньше определенного значения (задается как параметр),
    // а имя по алфавиту идет после буквы (задается так же как параметр).
    // Например если первый параметр задан как 5, а второй как 'C' то будет удален Cat [name=Timka, age=4], Cat [name=Kuzia, age=2].
    public static void main(String[] args) {

        final SqliteDataBase sqliteDataBase = new SqliteDataBase();
        sqliteDataBase.run();

        List<Cat> cats = sqliteDataBase.getCatsFromDB();

        Predicate<Cat> agePred = (cat -> cat.getAge() < 5);
        Predicate<Cat> namePred = (cat -> cat.getName().toLowerCase().startsWith("b"));
        Predicate<Cat> namePred1 = Third::nameTest;

        cats.removeIf(agePred.and(namePred1).or(namePred));

        System.out.println(cats);
    }
    public static boolean nameTest(Cat cat) {
        return cat.getName().substring(0, 1).matches("[D-Z]");
    }
}
