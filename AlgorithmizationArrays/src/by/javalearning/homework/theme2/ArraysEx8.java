package by.javalearning.homework.theme2;

import java.util.Scanner;

//2.Algorithmisation
//Одномерные массивы 
//Задача 8. Дана последовательность целых чисел a1,a2,...,an. Образовать новую последовательность, 
//выбросив из исходной те члены, которые равны min(a1,a2,...,an). 

public class ArraysEx8 {
    public static void main(String[] args) {
        System.out.println("Введите длину массива:");
        Scanner in = new Scanner(System.in);
        System.out.print("N=");
        int n = in.nextInt();
        if (n <= 0) {
            System.out.println("Длина массива не может быть нулевой или отрицательной!");
            System.exit(1);
        }
        int[] arr = new int[n];
        for (int j = 0; j < n; j++) {
            System.out.println("Введите " + (j + 1) + " элемент массива: ");
            arr[j] = in.nextInt();
        }
        int minimum = arr[0];
        int numout = 0;
        for (int i = 0; i < n; i++) { // ищем минимальное значение
            if (arr[i] < minimum) {
                minimum = arr[i];
            }
        }
        for (int i = 0; i < n; i++) { // считаем количество минимальных
            if (arr[i] == minimum)
                numout++;
        }
        int[] a_new = new int[n - numout]; // выбрасываем минимальные элементы
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == minimum)
                continue;
            a_new[j] = arr[i];
            System.out.print(a_new[j++] + " ");
        }
        in.close();
    }
}
