package by.javalearning.homework.theme2;

import java.util.Scanner;
import static java.lang.Math.*;

// 2.Algorithmisation
// Массивы массивов
// Задача 14. Сформировать случайную матрицу m x n, состоящую из нулей и единиц, 
// причем в каждом столбце число единиц равно номеру столбца.

public class MatricesEx14 {
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
        if (n > m) {
            System.out.println("Такую матрицу построить невозможно!");
            System.exit(1);
        }
        int[][] arr = new int[m][n];

        // заполняем
        int q = 2;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < (q - 1); i++) {
                arr[i][j] = 1;
            }
            q++;
        }
        // перемешиваем
        int a, index;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                index = (int) (random() * i);
                a = arr[index][j];
                arr[index][j] = arr[i][j];
                arr[i][j] = a;
            }
        }
        // выводим
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
        in.close();
    }
}
