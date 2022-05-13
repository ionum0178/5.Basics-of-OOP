package by.javalearning.homework.theme2;

import java.util.Scanner;

//2.Algorithmisation
//Массивы массивов
//Задача 6. Сформировать квадратную матрицу порядка n по заданному образцу(n-четное):
//       1   1   1  ...  1   1   1
//       0   1   1  ...  1   1   0
//       0   0   1  ...  1   0   0
//      ... ... ... ... ... ... ...
//       0   0   1  ...  1   0   0
//       0   1   1  ...  1   1   0
//       1   1   1  ...  1   1   1

public class MatricesEx6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер матрицы:");
        System.out.print("n=");
        int n = in.nextInt();
        if ((n % 2) != 0) {
            System.out.println("Вы ввели нечетное число!");
            System.exit(1);
        }
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n - i; j++) {
                arr[i][j] = 1;
                arr[n - 1 - i][j] = arr[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
        in.close();
    }
}
