package ru.home.generics;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericsRepeat {

    public static void main(String... args) {
        final SimpleBox box1 = new SimpleBox("Java");
        final SimpleBox box2 = buildSimpleBox("Python");
        final SimpleBox box3 = buildSimpleBox(100);


        System.out.println(Arrays.asList(box1, box2, box3));

        String castResult = (String) box1.getObject() + box2.getObject();

        var castResult2 = (String) box2.getObject() + box3.getObject();

        System.out.println(castResult + "\n" + castResult2);


        // Local inner class
        class InnerBox {
            private final Object object;

            public InnerBox(Object object) {
                this.object = object;
            }
        }

        final InnerBox innerBox = new InnerBox("Swing");

        System.out.println(Arrays.asList(innerBox.object, box1, box2, box3));

        final GenericsRepeat genericsRepeat = new GenericsRepeat();

        GenericsRepeat.GenBox<Integer> genBox1 = genericsRepeat.new GenBox<>(100);
        GenericsRepeat.GenBox<Integer> genBox2 = genericsRepeat.new GenBox<>(200);
        genBox1.setObj(500);
        var genericResult = genBox1.getObj() + genBox2.getObj();
        System.out.println(genericResult);

        final BoxWithNumbers<Float> boxWithNumbers1 = new BoxWithNumbers<>(1.0f, 2.0f, 3.0f);
        System.out.println(boxWithNumbers1.sum());

        final BoxWithNumbers<Integer> boxWithNumbers2 = new BoxWithNumbers<>(1, 2, 3);
        System.out.println(boxWithNumbers2.sum());

        final BoxWithNumbers<Integer> boxWithNumbers3 = new BoxWithNumbers<>(3, 2, 1);
        System.out.println(boxWithNumbers2.compareBySum(boxWithNumbers3));

        System.out.println(boxWithNumbers1.compareBySum(boxWithNumbers3));

        final ArrayList<Float> floatArraylist = new ArrayList<>(Arrays.asList(1f, 2f, 3f));
        System.out.println(avg(floatArraylist));

        final ArrayList<String> stringArrayList = new ArrayList<>(Arrays.asList("A", "B", "C"));

        System.out.println(getFirstElement(floatArraylist));

        System.out.println(getFirstElement(stringArrayList));

    }

    public static <T> T getFirstElement(List<T> list) {
        return list.get(0);
    }

    public static double avg(List<? extends Number> list) {
        double avgResult = 0.0;
        for (Number e : list) {
            avgResult += e.doubleValue();
        }
        avgResult /= list.size();
        return avgResult;
    }

    // Inner class (non-static)
    private class GenBox<T> {
        private T obj;

        public GenBox(T obj) {
            this.obj = obj;
        }

        public T getObj() {
            return obj;
        }

        public void setObj(T obj) {
            this.obj = obj;
        }
    }

    private static SimpleBox buildSimpleBox(Object object) {
        return new SimpleBox(object);
    }

    // Static nested class
    private static class SimpleBox {
        private Object object;

        public SimpleBox(Object object) {
            this.object = object;
        }

        public Object getObject() {
            return object;
        }

        public void setObject(Object object) {
            this.object = object;
        }

        @Override
        public String toString() {
            return String.format(object + " inside this one");
        }
    }

    private static class DoubleGenBox<T, K> {
        private T type1;
        private T type2;
        private K key1;

        public DoubleGenBox(T type1, T type2, K key1) {
            this.type1 = type1;
            this.type2 = type2;
            this.key1 = key1;
        }

        public T getType1() {
            return type1;
        }

        public void setType1(T type1) {
            this.type1 = type1;
        }

        public T getType2() {
            return type2;
        }

        public void setType2(T type2) {
            this.type2 = type2;
        }

        public K getKey1() {
            return key1;
        }

        public void setKey1(K key1) {
            this.key1 = key1;
        }
    }

}
