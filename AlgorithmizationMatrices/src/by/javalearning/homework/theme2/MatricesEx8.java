package by.javalearning.homework.theme2;

import java.util.Scanner;

//2.Algorithmisation
//Массивы массивов
//Задача 8. В числовой матрице поменять местами два любых столбца, 
//т. е. все элементы одного столбца поставить на соответствующие им позиции другого, 
//а его элементы второго переместить в первый.Номера столбцов вводит пользователь с клавиатуры.

public class MatricesEx8 {
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
        System.out.println("Введите номера столбцов, которые нужно поменять местами:");
        System.out.print("ст1=");
        int rw1 = in.nextInt();
        System.out.print("ст2=");
        int rw2 = in.nextInt();
        int[] rw = new int[n];
        for (int i = 0; i < m; i++) {
            rw[i] = arr[i][rw1 - 1];
            arr[i][rw1 - 1] = arr[i][rw2 - 1];
            arr[i][rw2 - 1] = rw[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
        in.close();
    }
}
