package ru.home.functionInterface.comparable.training;

import java.util.Arrays;
import java.util.Objects;

public class First {
    // Создайте класс прямоугольник, с двумя полями - длинной и высотой прямоугольника.
    // Задайте отношение естественного порядка для объектов этого класса (реализуйте интерфейс Comparable)
    // на основании площади этого прямоугольника. Используйте эту реализацию для сортировки массива объектов класса прямоугольник.
    public static void main(String... args) {

        Rectangle[] rectangles = new Rectangle[]{
                new Rectangle(7, 6),
                new Rectangle(4, 3),
                new Rectangle(6, 7),
                new Rectangle(5, 8),
                new Rectangle(6, 4)};

        System.out.println(Arrays.toString(rectangles).replace(",", ""));

        Arrays.sort(rectangles);

        System.out.println(Arrays.toString(rectangles).replace(",", ""));
    }

    static class Rectangle implements Comparable<Rectangle> {
        private final Integer high; // Integer for invoke compareTo (int haven't this)

        private final int length;

        public Rectangle(int high, int length) {
            this.high = high;
            this.length = length;
        }

        private int getSquare() {
            return high * length;
        }

        @Override
        public String toString() {
            return "Rectangle: H = "
                    + high + " L = "
                    + length + " sqr = "
                    + (high * length) + "\n";
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) return true;
            if (o == null || !o.getClass().isInstance(this)) return false;
            Rectangle rec = (Rectangle) o;
            return this.high == rec.high && this.length == rec.length;
        }

        @Override
        public int hashCode() {
            return Objects.hash(high, length);
        }

        @Override
        public int compareTo(Rectangle r) {
            if (r == null) {
                throw new NullPointerException();
            }
            // return Integer.compare(this.getSquare(), r.getSquare());
            if (this.getSquare() > r.getSquare()) {
                return 1;
            }
            if (this.getSquare() < r.getSquare()) {
                return -1;
            }
            return this.high.compareTo(r.high);
        }
    }

}
