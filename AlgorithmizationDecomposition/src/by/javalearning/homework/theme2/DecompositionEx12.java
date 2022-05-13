package by.javalearning.homework.theme2;

import java.util.Scanner;

//2.Algorithmisation
//Декомпозиция с использованием методов (подпрограммы).
//Задача 12. Даны натуральные числа К и N. Написать метод (методы) формирования 
//массива А, элементами которого являются числа, сумма цифр которых равна К и которые не больше N.

public class DecompositionEx12 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите К и N:");
        System.out.print("K=");
        int k = in.nextInt();
        System.out.print("N=");
        int n = in.nextInt();

        // вывод массива
        for (int a : makeArray(k, n))
            System.out.print(a + "\t");
        System.out.println();
        
        in.close();
    }

    static int[] makeArray(int k, int n) {
        // K не может быть больше, чем N.
        int el = 0;
        for (int i = 0; i < n; i++) { // считаем количество элементов массива
            if (digitSum(i) == k)
                el++;
        }
        int[] a = new int[el]; // объявляем массив
        int j = 0;
        int t = 0;
        while (j < n) { // заполняем
            if (digitSum(j) == k) {
                a[t] = j;
                t++;
            }
            j++;
        }
        return a;
    }
    
    static int digitSum(int n) { // сумма цифр числа
        int nn = n;
        int sum = 0;
        while (nn != 0) {
            sum += nn % 10;
            nn /= 10;
        }
        return sum;
    }
}
