package by.javalearning.homework.theme2;

import java.util.Scanner;

//2.Algorithmisation
//Одномерные массивы 
//Задача 3. Дан  массив  действительных  чисел,  размерность  которого N. 
//Подсчитать,  сколько  в  нем  отрицательных, положительных и нулевых элементов.

public class ArraysEx3 {
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
        int pos = 0;
        int neg = 0;
        int zero = 0;
        for (int i = 0; i < n; i++) {
            System.out.println("Введите " + (i + 1) + " элемент массива: ");
            arr[i] = in.nextDouble();
            if (arr[i] > 0)
                pos++;
            if (arr[i] < 0)
                neg++;
            if (arr[i] == 0)
                zero++;
        }
        System.out.println("Количество положительных элементов массива равно " + pos);
        System.out.println("Количество отрийательных элементов массива равно " + neg);
        System.out.println("Количество нулевых элементов массива равно " + zero);
        in.close();
    }
}
