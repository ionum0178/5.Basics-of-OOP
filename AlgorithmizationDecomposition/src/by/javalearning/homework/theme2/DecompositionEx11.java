package by.javalearning.homework.theme2;

import java.util.Scanner;

//2.Algorithmisation
//Декомпозиция с использованием методов (подпрограммы).
//Задача 11. Написать метод(методы), определяющий, в каком из данных двух чисел больше цифр.

public class DecompositionEx11 {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите два натуральных числа:");
        System.out.print("N=");
        int n = in.nextInt();
        System.out.print("M=");
        int m = in.nextInt();
        digits(n, m);
        in.close();
    }

    static void digits(int n, int m) {
        int rn = 0;
        int rm = 0;
        int nn = n;
        int mm = m;
        while (nn != 0) {
            rn++;
            nn /= 10;
        }
        while (mm != 0) {
            rm++;
            mm /= 10;
        }
        if (rn == rm)
            System.out.println("Количество цифр в числах одинаково");
        if (rn > rm)
            System.out.println("Количество цифр больше в числе " + n);
        if (rn < rm)
            System.out.println("Количество цифр больше в числе " + m);
    }
}
