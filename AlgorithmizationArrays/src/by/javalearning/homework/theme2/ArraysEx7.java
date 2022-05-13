package by.javalearning.homework.theme2;

import java.util.Arrays;
import java.util.Scanner;

//2.Algorithmisation
//Одномерные массивы 
//Задача 7. Даны действительные числа a1,a2,...,a2n. Найти max(a1+a2n, a2+a2n-1, ...an+an+1).

public class ArraysEx7 {
    public static void main(String[] args) {
        System.out.println("Введите длину массива (четное число):");
        Scanner in = new Scanner(System.in);
        System.out.print("N=");
        int n = in.nextInt();
        if (n <= 0) {
            System.out.println("Длина массива не может быть нулевой или отрицательной!");
            System.exit(1);
        }
        if ((n % 2) != 0) {
            System.out.println("Вы ввели нечетное число!");
            System.exit(1);
        }
        double[] arr = new double[n];
        double[] aaa = new double[(n / 2)];
        for (int j = 0; j < n; j++) {
            System.out.println("Введите " + (j + 1) + " элемент массива: ");
            arr[j] = in.nextDouble();
        }
        for (int i = 0; i < (n / 2); i++) {
            aaa[i] = arr[i] + arr[n - 1 - i];
        }
        Arrays.sort(aaa);
        double max = aaa[aaa.length - 1];
        System.out.println(max);
        in.close();
    }
}
