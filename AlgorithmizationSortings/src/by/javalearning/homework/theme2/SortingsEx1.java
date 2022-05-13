package by.javalearning.homework.theme2;

import java.util.Scanner;

//2.Algorithmisation
//Одномерные массивы. Сортировки
//Задача 1. Заданы два одномерных массива с различным количеством элементов и натуральное число k.
//Объединить их в один массив, включив второй массив между k-м и (k+1)-м элементами 
//первого, при этом не используя дополнительный массив.

public class SortingsEx1 {
    
    public static int[] arrFill(int n) {
        int[] arr = new int[n];
        @SuppressWarnings("resource")
	Scanner in = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.println("Введите элемент массива [" + (i + 1) + "]: ");
            arr[i] = in.nextInt();
        }
        return arr;
    }

    public static void main(String[] args) {
        @SuppressWarnings("resource")
	Scanner in = new Scanner(System.in);
        System.out.println("Введите длину массива 1:");
        System.out.print("N=");
        int n = in.nextInt();
        System.out.println("Введите длину массива 2:");
        System.out.print("M=");
        int m = in.nextInt();
        if (n <= 0 || m <= 0) {
            System.out.println("Размер массива не может быть нулевым или отрицательным!");
            System.exit(1);
        }
        int a1[] = new int[n];
        int a2[] = new int[m];
        a1 = arrFill(n);
        a2 = arrFill(m);
        int[] ar = new int[(n + m)];
        System.out.println("Введите k:");
        System.out.print("k=");
        int k = in.nextInt();
        if ((k - 1) > n) {
            System.out.println("k не может быть больше длины массива 1!");
            System.exit(1);
        }
        int i = 0;
        while (i < k) {
            ar[i] = a1[i];
            i++;
        }
        for (i = 0; i < a2.length; i++)
            ar[k + i] = a2[i];
        i = k + a2.length;
        int j = k;
        while (i < ar.length) {
            ar[i] = a1[j];
            i++;
            j++;
        }
        for (int a : ar) {
            System.out.print(a + "\t");
        }
        System.out.println();
    }
}
