package by.javalearning.homework.theme2;

import java.util.Scanner;

//2.Algorithmisation
//Декомпозиция с использованием методов (подпрограммы).
//Задача 5. Составить программу, которая в массиве A[N] находит второе по величине число 
//(вывести на печать число, которое меньше максимального элемента массива, но больше всех других элементов).

public class DecompositionEx5 {

    static int[] arrFill(int n) {
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
        System.out.println("Введите длину массива:");
        System.out.print("N=");
        int n = in.nextInt();
        if (n <= 0) {
            System.out.println("Размер массива не может быть нулевым или отрицательным!");
            System.exit(1);
        }
        int ar[] = new int[n];
        ar = arrFill(n);

        for (int a : ar)
            System.out.print(a + "\t");
        System.out.println();

        System.out.println("Второе по величине число в массиве равно " + secondElement(ar));
        
        in.close();
    }

    static int secondElement(int aa[]) {
        int maxEl = aa[0];
        int sec= Integer.MIN_VALUE;
        for (int i = 0; i < aa.length; i++) { // ищем первый
            if (aa[i] > maxEl) {
                maxEl = aa[i];
            }
        }
        for (int i = 0; i < aa.length; i++) { // ищем второй
            if (aa[i] > sec && aa[i] < maxEl)
                sec = aa[i];
        }
        return sec;
    }
}
