package by.javalearning.homework.theme2;

import java.util.Scanner;
// 2.Algorithmisation
// Одномерные массивы 
// Задача 1. В массив A[N] занесены натуральные числа. Найти сумму тех элементов, которые кратны данному К.

public class ArraysEx1 {

    public static void main(String[] args) {

	System.out.println("Введите длину массива:");
	Scanner in = new Scanner(System.in);
	System.out.print("N=");
	int n = in.nextInt();
	if (n <= 0) {
	    System.out.println("Длина массива не может быть нулевой или отрицательной!");
	    System.exit(1);
	}
	int[] a = new int[n];
	System.out.println("Введите кратность:");
	System.out.print("К=");
	int k = in.nextInt();
	int sum = 0;
	for (int i = 0; i < n; i++) {
	    System.out.println("Введите " + (i + 1) + " элемент массива: ");
	    a[i] = in.nextInt();
	    if (a[i] % k == 0)
		sum += a[i];
	}
	System.out.println("Сумма элементов массива, кратных К, равна " + sum);
	in.close();
    }

}
