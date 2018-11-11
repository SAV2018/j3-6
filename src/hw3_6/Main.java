package hw3_6;

import java.util.ArrayList;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) {
//  Написать метод, которому в качестве аргумента передается непустой одномерный целочисленный массив.
//  Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
//  идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку, иначе
//  в методе необходимо выбросить RuntimeException.
//  Написать набор тестов для этого метода (по 3-4 варианта входных данных).
//  Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].

        try {
            Integer[] a = {1, 2, 4, 4, 2, 3, 4, 1, 7};
            System.out.println("\n" + Arrays.toString(a));
            System.out.println(Arrays.toString(getNewArray(a)));

            Integer[] c = {1, 2, 3, 4};
            System.out.println("\n" + Arrays.toString(c));
            System.out.println(Arrays.toString(getNewArray(c)));

            Integer[] b = {};
            System.out.println("\n" + Arrays.toString(b));
            System.out.println(Arrays.toString(getNewArray(b)));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

//  Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хотя бы одной четверки или единицы,
//  то метод вернет false; Написать набор тестов для этого метода (по 3-4 варианта входных данных).

        System.out.println("\n" + checkArray(new Integer[]{1 ,1, 1, 4}));
        System.out.println(checkArray(new Integer[]{1, 1}));
        System.out.println(checkArray(new Integer[]{4}));
        System.out.println(checkArray(new Integer[]{}));
    }

    static Integer[] getNewArray(Integer[] array) {
        boolean found = false;
        int index = 0;

        // ищем последнее вхождение цифры 4 в массиве
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 4) { found = true; index = i; }
        }

        if (found) { // если цифра найдена хотя бы одна 4
            return Arrays.copyOfRange(array,index + 1, array.length); // возвращаем новый массив
        } else { // иначе выбрасываем исключение
            throw new RuntimeException("No 4 is in array!");
        }
    }

    static boolean checkArray(Integer[] array) {
        boolean one = false, four = false;

        for (int anArray : array) {
            if (anArray == 1) one = true;
            if (anArray == 4) four = true;
        }
        return (one && four);
    }
}
