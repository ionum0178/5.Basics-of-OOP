package by.javalearning.homework.theme2;

import java.util.Scanner;

//2.Algorithmisation
//Декомпозиция с использованием методов (подпрограммы).
//Задача 8. Задан массив D. Определить следующие суммы: D[l]+D[2]+D[3];  D[3]+D[4]+D[5]; 
//D[4]+D[5]+D[6]. Пояснение. Составить метод (методы) для вычисления суммы трех 
//последовательно расположенных элементов массива с номерами от k до m.

public class DecompositionEx8 {
    
    public static double[] arrFill(int n) {
        @SuppressWarnings("resource")
	Scanner in = new Scanner(System.in);
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Введите элемент [" + (i + 1) + "]: ");
            arr[i] = in.nextDouble();
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println("Введите количество элементов в массиве: ");
        System.out.print("N=");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double[] d = new double[n];
        d = arrFill(n);
        System.out.println("Искомые суммы элементов равны " + sum(d, 1, 3) + ", " + sum(d, 3, 5) + ", " + sum(d, 4, 6));
        in.close();
    }

    // Расчет суммы элементов в интервале от k до m (для любого числа элементов)
    static double sum(double[] a, int k, int m) {
        double res = 0;
        if (--k >= a.length || k < 0) // если k выходит за границы массива, то считаем только последний элемент
            k = a.length - 1;
        if (--m >= a.length || m < 0) // если m выходит за границы массива, то считаем только по последний элемент
            m = a.length - 1;
        for (int i = k; i <= m; i++) {
            res += a[i];
        }
        return res;
    }
}
