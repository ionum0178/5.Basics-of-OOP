package by.javalearning.homework.theme2;

import java.util.Scanner;

//2.Algorithmisation
//Массивы массивов
//Задача 5. Сформировать квадратную матрицу порядка n по заданному образцу(n-четное):
//       1   1   1  ...  1   1   1
//       2   2   2  ...  2   2   0
//       3   3   3  ...  3   0   0
//      ... ... ... ... ... ... ...
//      n-1 n-1  0  ...  0   0   0
//       n   0   0  ...  0   0   0

public class MatricesEx5 {
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
            for (int j = 0; j < n - i; j++) 
                arr[i][j] = i + 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
        in.close();
    }
}
