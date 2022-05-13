package by.javalearning.homework.theme2;

import java.util.Scanner;

// 2.Algorithmisation
// Декомпозиция с использованием методов (подпрограммы).
// Задача 15. Найти все натуральные n-значные числа, цифры в которых образуют строго 
// возрастающую последовательность (например, 1234, 5789). Для решения задачи использовать декомпозицию.

public class DecompositionEx15 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите N:");
        System.out.print("N=");
        int n = in.nextInt();
        if (n > 9 || n < 1) {
            System.out.println("Таких чисел не существует");
            System.exit(1);
        }
        increaseSearch(n);
        in.close();
    }

    static void increaseSearch(int n) {
        int fff = 0;
        int f = 0;
        for (int i = 1; i <= n; i++) // создаем число из единиц вида 11111, которое потом прибавляем к результату
            f += Math.pow(10, (n - i));
        for (int i = 1; i <= n; i++) // создаем искомое число-последовательность, начинающееся с 1.
            fff += i * Math.pow(10, (n - i));
        for (int x = 0; x < (10 - n); x++) // выводим числа
            System.out.print((fff + x * f) + " ");
    }
}
