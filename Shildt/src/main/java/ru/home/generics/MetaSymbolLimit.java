package ru.home.generics;

public class MetaSymbolLimit {
    public static void main(String... args) {
        TwoD[] td = {
                new TwoD(0, 0),
                new TwoD(7, 9),
                new TwoD(18, 4),
                new TwoD(-1, -23)
        };

        Coords<TwoD> tdlocs = new Coords<>(td);

        System.out.println("Content of object tdlocs:");
        BoundedWildcard.showXY(tdlocs);
//        BoundedWildcard.showXYZ(tdlocs); error: tdlocs not an ThreeD type
//        BoundedWildcard.showAll(tdlocs); error: tdlocs not an FourD type

        FourD[] fd = {
                new FourD(1, 2, 3, 4),
                new FourD(6, 8, 14, 8),
                new FourD(22, 9, 4, 9),
                new FourD(3, -2, -23, 17)
        };

        Coords<FourD> fdlocs = new Coords<>(fd);

        System.out.println("Content of object fdlocs:");
        BoundedWildcard.showXY(fdlocs);
        BoundedWildcard.showXYZ(fdlocs);
        BoundedWildcard.showAll(fdlocs);
    }

    private static class TwoD {
        int x;
        int y;

        TwoD(int a, int b) {
            x = a;
            y = b;
        }
    }

    private static class ThreeD extends TwoD {
        int z;

        ThreeD(int a, int b, int c) {
            super(a, b);
            z = c;
        }
    }

    private static class FourD extends ThreeD {
        int t;

        FourD(int a, int b, int c, int d) {
            super(a, b, c);
            t = d;
        }
    }

    private static class Coords<T extends TwoD> {
        T[] coords;

        Coords(T[] o) {
            coords = o;
        }
    }

    private static class BoundedWildcard {
        static void showXY(Coords<?> c) {
            System.out.println("Coordinates X Y");
            for (int i = 0; i < c.coords.length; i++) {
                System.out.println(c.coords[i].x + " " + c.coords[i].y + "\n");
            }
        }

        static void showXYZ(Coords<? extends ThreeD> c) {
            System.out.println("Coordinates X Y Z");
            for (int i = 0; i < c.coords.length; i++) {
                System.out.println(c.coords[i].x + " "
                        + c.coords[i].y + " "
                        + c.coords[i].z + "\n");
            }
        }

        static void showAll(Coords<? extends FourD> c) {
            System.out.println("All coordinates");
            for (int i = 0; i < c.coords.length; i++) {
                System.out.println(c.coords[i].x + " "
                        + c.coords[i].y + " "
                        + c.coords[i].z + " "
                        + c.coords[i].t + "\n");
            }
        }
    }
}
