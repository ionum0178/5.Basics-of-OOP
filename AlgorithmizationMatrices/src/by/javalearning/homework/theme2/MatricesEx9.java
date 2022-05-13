package by.javalearning.homework.theme2;

import java.util.Scanner;

//2.Algorithmisation
//Массивы массивов
//Задача 9. Задана матрица неотрицательных чисел. Посчитать сумму элементов 
//в каждом столбце. Определить, какой столбец содержит максимальную сумму.

public class MatricesEx9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число столбцов массива:");
        System.out.print("N=");
        int n = in.nextInt();
        System.out.println("Введите число строк массива:");
        System.out.print("M=");
        int m = in.nextInt();
        if (n <= 0 || m <= 0) {
            System.out.println("Число строк или столбцов не может быть нулевой или отрицательной!");
            System.exit(1);
        }
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Введите элемент массива [" + (j + 1) + "] [" + (i + 1) + "]: ");
                arr[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
        int[] rw = new int[n];
        int rw_max = 0;
        int rw_index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rw[i] += arr[j][i];
            }
            System.out.println("Сумма элементов столбца " + (i + 1) + " равна " + rw[i]);
            if (rw[i] > rw_max) {
                rw_max = rw[i];
                rw_index = i;
            }
        }
        System.out.println("Столбцец " + (rw_index + 1) + " имеет максимальную сумму элементов, равную " + rw_max);
        in.close();
    }
}
