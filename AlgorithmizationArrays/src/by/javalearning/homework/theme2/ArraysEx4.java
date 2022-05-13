package by.javalearning.homework.theme2;

import java.util.Arrays;
import java.util.Scanner;

//2.Algorithmisation
//Одномерные массивы 
//Задача 4. Даны действительные числа а1,а2,..., аn. Поменять местами наибольший и наименьший элементы.

public class ArraysEx4 {
    public static void main(String[] args) {
        System.out.println("Введите длину массива:");
	Scanner in = new Scanner(System.in);
        System.out.print("N=");
        int n = in.nextInt();
        if (n <= 0) {
            System.out.println("Длина массива не может быть нулевой или отрицательной!");
            System.exit(1);
        }
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Введите " + (i + 1) + " элемент массива: ");
            arr[i] = in.nextDouble();
        }
        double minimum = arr[0];
        double maximum = arr[0];
        int minnum = 0;
        int maxnum = 0;
        for (int j = 0; j < n; j++) {
            if (arr[j] <= minimum) {
                minimum = arr[j];
                minnum = j;
            }
            if (arr[j] >= maximum) {
                maximum = arr[j];
                maxnum = j;
            }
        }
        String arr_str = Arrays.toString(arr);
        System.out.println("Содержимое массива до замены: " + arr_str);
        arr[minnum] = maximum;
        arr[maxnum] = minimum;
        arr_str = Arrays.toString(arr);
        System.out.println("Содержимое массива после замены: " + arr_str);
        in.close();
    }
}
