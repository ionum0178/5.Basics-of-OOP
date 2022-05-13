package by.javalearning.homework.theme2;

import java.util.Scanner;

//2.Algorithmisation
//Одномерные массивы 
//Задача 9. В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число. 
//Если таких чисел несколько, то определить наименьшее из них.

public class ArraysEx9 {
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
        int[] num = new int[n]; // Массив для сравнения с arr[]
        int[] freq = new int[n]; // Сколько раз встретился каждый элемент
        for (int i = 0; i < n; i++) {
            System.out.println("Введите " + (i + 1) + " элемент массива: ");
            arr[i] = in.nextInt();
            num[i] = arr[i];
        }
        for (int i = 0; i < n; i++) { // определяем, сколько раз встречается каждый элемент
            freq[i] = 0;
            for (int k = 0; k < n; k++) {
                if (arr[i] == num[k]) { // ищем среди остальных элементов такой же
                    freq[i]++;
                }
            }
        }
        int min = 0; // Индекс наименьшего из наиболее часто встречающихся чисел
        for (int j = 0; j < n; j++) {
            if (freq[j] > freq[min]) {
                min = j;
            } else if (freq[j] == freq[min])
                if (num[j] < num[min])
                    min = j;
        }
        System.out.println(num[min]);
        in.close();
    }
}
