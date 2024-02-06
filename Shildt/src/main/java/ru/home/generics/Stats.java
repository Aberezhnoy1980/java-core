package ru.home.generics;

public class Stats<T extends Number> {
    // В этом классе аргумент типа Т должен быть классом
    // Number или его наследникамии
    T[] nums;

    public Stats(T[] o) {
        nums = o;
    }

    double average() {
        double sum = 0.0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i].doubleValue();
        }
        return sum / nums.length;
    }

    boolean sameAvs(Stats<?> ob) {
//        return Math.abs(this.average() - ob.average()) < 0.0001;
        if (average() == ob.average())
            return true;
        return false;
    }
}
