package by.javalearning.homework.theme2;

import java.util.Scanner;

//2.Algorithmisation
//Декомпозиция с использованием методов (подпрограммы).
//Задача 1. Написать метод (методы) для нахождения наибольшего общего делителя 
//и наименьшего общего кратного двух натуральных чисел.

public class DecompositionEx1 {
    
    int nod;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите два натуральных числа:");
        System.out.print("A=");
        int a = in.nextInt();
        System.out.print("B=");
        int b = in.nextInt();
        System.out.println("Наибольший общий делитель равен: " + nod(a, b));
        System.out.println("Наименьшее общее кратное равно: " + nok(a, b));
        in.close();
    }

    // Наименьшее общее кратное
    static int nok(int a, int b) {
        return (a * b) / nod(a, b);
    }

    // Наибольший общий делитель
    static int nod(int a, int b) {
        int nod = 1;
        int r = 1;
        if (a == b)
            nod = a;
        while (r != 0) {
            if (a > b) {
                r = a % b;
                if (r == 0) {
                    nod = b;
                    break;
                } else {
                    a = b;
                    b = r;
                }
            } else {
                r = b % a;
                if (r == 0) {
                    nod = a;
                    break;
                } else {
                    b = a;
                    a = r;
                }
            }
        }
        return nod;
    }
}
