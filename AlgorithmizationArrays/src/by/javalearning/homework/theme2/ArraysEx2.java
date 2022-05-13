package by.javalearning.homework.theme2;

import java.util.Arrays;
import java.util.Scanner;

//2.Algorithmisation
//Одномерные массивы 
//Задача 2. Дана последовательность действительных чисел а1,а2 ,..., ап. 
//Заменить все ее члены, большие данного Z, этим числом. Подсчитать количество замен.

public class ArraysEx2 {
    public static void main(String[] args) {
	System.out.println("Введите длину массива:");
	Scanner in = new Scanner(System.in);
	System.out.print("N=");
	int n = in.nextInt();
	if (n <= 0) {
	    System.out.println("Длина массива не может быть нулевой или отрицательной!");
	    System.exit(1);
	}
	int[] arr = new int[n];
	System.out.println("Введите Z:");
	System.out.print("Z=");
	int z = in.nextInt();
	int zam = 0;
	for (int i = 0; i < n; i++) {
	    System.out.println("Введите " + (i + 1) + " элемент массива: ");
	    arr[i] = in.nextInt();
	    if (arr[i] > z) {
		arr[i] = z;
		zam++;
	    }
	}
	String arr_str = Arrays.toString(arr);
	System.out.println(arr_str);
	System.out.println("Количество замененных элементов массива равно " + zam);
	in.close();
    }
}
