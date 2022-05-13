package by.javalearning.homework.theme2;

import java.util.Scanner;

// 2.Algorithmisation
// Массивы массивов
// Задача 15.Найдите наибольший элемент матрицы и замените все нечетные элементы на него.

public class MatricesEx15 {
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
        // выводим
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
        System.out.println();
        // ищем максимальное
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                if (arr[i][j] > max)
                    max = arr[i][j];
        }
        // заменяем нечетные элементы
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                if (arr[i][j] % 2 != 0)
                    arr[i][j] = max;
        }
        // выводим
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
        System.out.println();
        in.close();
    }
}
