package by.javalearning.homework.theme2;

import java.util.Scanner;

//2.Algorithmisation
//Одномерные массивы. Сортировки
//Задача 3. Сортировка выбором. Дана последовательность чисел a1<=a2<=...<=an. 
//Требуется переставить элементы так, чтобы они были расположены по убыванию. 
//Для этого в массиве, начиная с первого, выбирается наибольший элемент и ставится 
//на первое место, а первый -на место наибольшего. Затем, начиная со второго, эта 
//процедура повторяется. Написать алгоритм сортировки выбором.

public class SortingsEx3 {

    public static int[] arrFill(int n) {
        @SuppressWarnings("resource")
	Scanner in = new Scanner(System.in);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Введите элемент [" + (i + 1) + "]: ");
            arr[i] = in.nextInt();
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите длину последовательности:");
        System.out.print("N=");
        int n = in.nextInt();
        if (n <= 0) {
            System.out.println("Размер последовательности не может быть нулевым или отрицательным!");
            System.exit(1);
        }
        System.out.println("Введите неубывающую последовательность:");
        int ar[] = new int[n];
        ar = arrFill(n);

        // до сортировки
        for (int a : ar)
            System.out.print(a + "\t");
        System.out.println();

        int sw;
        for (int i = 0; i < ar.length; i++) {
            int ind = i;
            for (int j = i + 1; j < ar.length; j++) {
                if (ar[j] > ar[ind])
                    ind = j;
            }
            sw = ar[ind];
            ar[ind] = ar[i];
            ar[i] = sw;
        }
        // после сортировки
        for (int a : ar)
            System.out.print(a + "\t");
        System.out.println();
        in.close();
    }
}
