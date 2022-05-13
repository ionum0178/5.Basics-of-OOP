package by.javalearning.homework.theme2;

import java.util.Scanner;

//2.Algorithmisation
//Одномерные массивы 
//Задача 5. Даны целые числа а1,а2 ,..., аn. Вывести на печать только те числа, для которых аi> i.

public class ArraysEx5 {
    public static void main(String[] args) {
        System.out.println("Введите длину массива:");
        Scanner in = new Scanner(System.in);
        System.out.print("N=");
        int n = in.nextInt();
        if (n <= 0) {
            System.out.println("Длина массива не может быть нулевой или отрицательной!");
            System.exit(1);
        }
        System.out.println("Введите i:");
        System.out.print("i=");
        int i = in.nextInt();
        int[] arr = new int[n];
        for (int j = 0; j < n; j++) {
            System.out.println("Введите " + (j + 1) + " элемент массива: ");
            arr[j] = in.nextInt();
        }
        int m = 0;
        System.out.print("Элементы массива, которые больше чем i: ");
        for (int k = 0; k < n; k++) {
            if (arr[k] > i) {
                System.out.print(arr[k] + ", ");
                m++;
            }
        }
        if (m == 0)
            System.out.print("не найдено");
        in.close();
    }
}
