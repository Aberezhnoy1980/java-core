package ru.home.io.staticimport;

// импорт статических членов класса. Маска * для импортирует все статические члены.
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

// Вычисляем длину гипотенузы прямоугольного треугольника
public class Hypot {
    public static void main(String[] args) {
        double side1, side2;
        double hypot;

        side1 = 3.0;
        side2 = 4.0;

        // обратить внимание на то, что имена методов sqrt()
        // и pow() должны быть уточнены именем их класса Math
        // hypot = Math.sqrt(Math.pow(side1, 2) + Math.pow(side2, 2));
        // так можно программировать если сделать импорт статических членов
        hypot = sqrt(pow(side1, 2) + pow(side2, 2));

        System.out.printf("При заданной длине сторон %s и %s гипотенуза равна %s%n", side1, side2, hypot);
    }
}
