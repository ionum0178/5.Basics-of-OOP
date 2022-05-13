package by.javalearning.homework.theme2;

import java.util.Scanner;

//2.Algorithmisation
//Одномерные массивы. Сортировки
//Задача 4. Сортировка обменами. Дана последовательность чисел a1<=a2<=...<=an.
//Требуется переставить числа в порядке возрастания. Для этого сравниваются два соседних 
//числа ai и ai+1. Если ai>ai+1, то делается перестановка. Так продолжается до тех пор, 
//пока все элементы не станут расположены в порядке возрастания. Составить алгоритм сортировки, 
//подсчитывая при этом количества перестановок. 

public class SortingsEx4 {

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
        System.out.println("Введите последовательность:");
        int ar[] = new int[n];
        ar = arrFill(n);

        // до сортировки
        for (int a : ar)
            System.out.print(a + "\t");
        System.out.println();

        int sw;
        int ch = 0; // полное число перестановок
        int c = 1; // число перестановок за 1 проход цикла сортировки. Если с=0, массив
                   // отсортирован.
        while (c != 0) {
            c = 0;
            for (int i = 1; i < ar.length; i++) {
                if (ar[i] < ar[i - 1]) {
                    sw = ar[i - 1];
                    ar[i - 1] = ar[i];
                    ar[i] = sw;
                    ch++;
                    c++;
                }
            }
        }
        // после сортировки
        for (int a : ar)
            System.out.print(a + "\t");
        System.out.println();
        System.out.println("Сделано перестановок: " + ch);
        in.close();
    }
}
