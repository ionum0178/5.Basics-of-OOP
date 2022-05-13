package by.javalearning.homework.theme2;

import java.util.Scanner;

//2.Algorithmisation
//Одномерные массивы 
//Задача 6. Задана последовательность Nвещественных чисел. Вычислить сумму чисел, 
//порядковые номера которых являются простыми числами

public class ArraysEx6 {
    public static void main(String[] args) {
        System.out.println("Введите длину массива:");
        Scanner in = new Scanner(System.in);
        System.out.print("N=");
        int n = in.nextInt();
        if (n <= 0) {
            System.out.println("Длина массива не может быть нулевой или отрицательной!");
            System.exit(1);
        }
        boolean f = true;
        double sum = 0;
        double[] arr = new double[n];
        for (int j = 0; j < n; j++) {
            System.out.println("Введите " + (j + 1) + " элемент массива: ");
            arr[j] = in.nextDouble();
            f = true;
            if ((j + 1) > 1) {
                for (int i = 2; i < (j + 1); i++) {
                    if ((j + 1) % i == 0)
                        f = false;
                }
                if (f)
                    sum += arr[j];
            }
        }
        System.out.print("Сумма элементов: " + sum);
        in.close();
    }
}
