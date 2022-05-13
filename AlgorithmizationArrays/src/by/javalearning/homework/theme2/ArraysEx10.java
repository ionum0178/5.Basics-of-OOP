package by.javalearning.homework.theme2;

import java.util.Scanner;

//2.Algorithmisation
//Одномерные массивы 
//Задача 10. Дан целочисленный массив с количеством элементов п. Сжать массив, 
//выбросив из него каждый второй элемент (освободившиеся элементы заполнить нулями).
//Примечание. Дополнительный массив не использовать

public class ArraysEx10 {
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
        for (int i = 1; i < n; i += 2)
            arr[i] = 0;
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
        in.close();
    }
}
