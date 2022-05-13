package by.javalearning.homework.theme2;

import java.util.Scanner;

//2.Algorithmisation
//Одномерные массивы. Сортировки
//Задача 8. Даны дроби P1/Q1, P2/Q2, ..., Pn/Qn ( Pi, Qi - натуральные). Составить программу,
//которая приводит эти дроби к общему знаменателю и упорядочивает их в порядке возрастания.

public class SortingsEx8 {

    int q1;
    int q2;
    int nod;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество дробей:");
        System.out.print("N=");
        int n = in.nextInt();
        int[] p = new int[n];
        int[] q = new int[n];
        int qq = 1; // общий знаменатель
        for (int i = 0; i < n; i++) {
            System.out.println("Введите числитель " + (i + 1) + "-й дроби: ");
            p[i] = in.nextInt();
            System.out.println("Введите знаменатель " + (i + 1) + "-й дроби: ");
            q[i] = in.nextInt();
            if (q[i] == 0) {
                System.out.println("Делить на ноль нельзя!");
                System.exit(1);
            }
            qq = nok(q[i], qq);
        }
        // приводим числители к общему знаменателю
        for (int i = 0; i < n; i++) {
            p[i] = (qq / q[i]) * p[i];
        }
        // сортируем (сортировка выбором)
        int sw;
        for (int i = 0; i < p.length; i++) {
            int ind = i;
            for (int j = i + 1; j < p.length; j++) {
                if (p[j] < p[ind])
                    ind = j;
            }
            sw = p[ind];
            p[ind] = p[i];
            p[i] = sw;
        }
        // выводим
        for (int i = 0; i < n; i++) {
            System.out.print(p[i] + "/" + qq + " ");
        }
        System.out.println();
        in.close();
    }

    // Наименьшее общее кратное
    static int nok(int q1, int q2) {
        return (q1 * q2) / nod(q1, q2);
    }

    // Наибольший общий делитель
    static int nod(int q1, int q2) {
        int nod = 1;
        int r = 1;
        if (q1 == q2)
            nod = q1;
        while (r != 0) {
            if (q1 > q2) {
                r = q1 % q2;
                if (r == 0) {
                    nod = q2;
                    break;
                } else {
                    q1 = q2;
                    q2 = r;
                }
            } else {
                r = q2 % q1;
                if (r == 0) {
                    nod = q1;
                    break;
                } else {
                    q2 = q1;
                    q1 = r;
                }
            }
        }
        return nod;
    }
}
