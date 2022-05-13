package by.javalearning.homework.theme2;

import java.util.Scanner;

// 2.Algorithmisation
// Декомпозиция с использованием методов (подпрограммы).
// Задача 14. Натуральное число, в записи которого n цифр, называется числом Армстронга, 
// если сумма его цифр, ВОЗВЕДЕННЫХ в степень n, равна самому числу. Найти все числа
// Армстронга от 1 до k. Для решения задачи использовать декомпозицию.

public class DecompositionEx14 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите k:");
        System.out.print("k=");
        int k = in.nextInt();
        armstrongSearch(k);
        in.close();
    }

    static void armstrongSearch(int k) {
        int z = 0;
        System.out.print("Числа Армстронга: ");
        for (int i = 1; i <= k; i++) {
            if (digitSum(i) == i) {
                System.out.print(i + " ");
                z++;
            }
        }
        if (z == 0)
            System.out.print("не найдено");
    }

    static int digits(int nn) { // количество цифр числа
        int rn = 0;
        while (nn != 0) {
            rn++;
            nn /= 10;
        }
        return rn;
    }

    static int digitSum(int n) { // сумма цифр числа, возведенных в степень n
        int nn = n;
        int sum = 0;
        while (nn != 0) {
            sum += Math.pow((nn % 10), digits(n));
            nn /= 10;
        }
        return sum;
    }
}
