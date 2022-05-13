package by.javalearning.homework.theme2;

import java.util.Scanner;

//2.Algorithmisation
//Декомпозиция с использованием методов (подпрограммы).
//Задача 17. Из заданного числа вычли сумму его цифр. Из результата вновь вычли 
//сумму его цифр и т.д. Сколько таких действий надо произвести, чтобы получился нуль?
//Для решения задачи использовать декомпозицию.

public class DecompositionEx17 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число:");
        System.out.print("N=");
        int n = in.nextInt();
        System.out.println("Чтобы получился ноль нужно " + decrease(n) + " вычитаний");
        in.close();
    }

    static int decrease(int n) {
        int d = 0; // количество вычитаний
        while (n != 0) {
            n = n - digitSum(n);
            d++;
        }
        return d;
    }

    static int digitSum(int n) { // сумма цифр числа
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
