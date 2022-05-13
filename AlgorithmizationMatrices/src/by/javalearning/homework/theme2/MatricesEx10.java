package by.javalearning.homework.theme2;

import java.util.Scanner;

//2.Algorithmisation
//Массивы массивов
//Задача 10. Найти положительные элементы главной диагонали квадратной матрицы.

public class MatricesEx10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер матрицы:");
        System.out.print("N=");
        int n = in.nextInt();
        if (n <= 0) {
            System.out.println("Размер матрицы не может быть нулевым или отрицательным!");
            System.exit(1);
        }
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Введите элемент матрицы [" + (j + 1) + "] [" + (i + 1) + "]: ");
                arr[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
        System.out.print("Положительные элементы главной диагонали: ");
        int q = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i][i] > 0) {
                System.out.print(arr[i][i] + " ");
                q++;
            }
        }
        if (q == 0)
            System.out.print(" не найдено.");
        System.out.println();
        in.close();
    }
}
