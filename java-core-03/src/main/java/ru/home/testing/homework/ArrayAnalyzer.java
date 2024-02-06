package ru.home.testing.homework;

import java.lang.reflect.Executable;
import java.util.Arrays;

public class ArrayAnalyzer {
    public static void main(String[] args) {
        //           0  1  2  3  4  5  6  7  8
        int[] arr = {0, 2, 3, 5, 4, 7, 9, 6, 7};
        int[] arrForCheckMethod = {1, 4, 4, 4, 4, 4, 4};
        System.out.println(Arrays.toString(modifyArray(arr)));
        System.out.println(checkArray(arrForCheckMethod));
    }

    public static int[] modifyArray(int[] arr) {
        for (int i = arr.length - 1; i > -1; i--) {
            if (arr[i] == 4) {
                int modifiedArrayLength = arr.length - i - 1;
                int[] modifiedArray = new int[modifiedArrayLength];
                for (int j = 0; j < modifiedArray.length; j++) {
                    modifiedArray[j] = arr[i + 1 + j];
                }
                return modifiedArray;
            }
        }
        throw new RuntimeException("argument not found");
    }

    public static boolean checkArray(int[] arrForCheckMethod) {
        // отдельная главная проверка на валидность входных аргументов
        for (int i = 0; i < arrForCheckMethod.length; i++) {
            if (arrForCheckMethod[i] != 1 && arrForCheckMethod[i] != 4)
                return false;
        }
        // проверка отсутствия любого одного
        for (int i = 0; i < arrForCheckMethod.length; i++) {
            if (arrForCheckMethod[i] == 1) {
                for (int j = 0; j < arrForCheckMethod.length; j++) {
                    if (arrForCheckMethod[j] == 4)
                        return true;
                }
            }
        }
        return false;
    }
}
