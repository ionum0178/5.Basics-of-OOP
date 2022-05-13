package by.javalearning.homework.theme2;

import java.util.Scanner;

//2.Algorithmisation
//Декомпозиция с использованием методов (подпрограммы).
//Задача 4. На плоскости заданы своими координатами n точек. Написать метод (методы), 
//определяющие, между какими из пар точек самое большое расстояние. Указание. Координаты точек занести в массив.

public class DecompositionEx4 {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество точек:");
        System.out.print("N=");
        int n = in.nextInt();
        if (n < 2) {
            System.out.println("Недостаточно точек");
            System.exit(1);
        }
        double[][] a = new double[2][n]; // [0, i] - x; [1, i] - y
        for (int i = 0; i < a[0].length; i++) {
            System.out.println("Введите координаты " + (i + 1) + "-й точки: ");
            System.out.print("X=");
            a[0][i] = in.nextDouble();
            System.out.print("Y=");
            a[1][i] = in.nextDouble();
        }
        pointsDistance(a);
        in.close();
    }

    // расстояние между точками А и В считаем по формуле d = sqrt((хА – хВ)^2 + (уА
    // – уВ)^2).
    // для удобства будем сравнивать квадраты расстояний (d^2)
    static void pointsDistance(double a[][]) {
        double maxD = -1; // Квадрат расстояния
        int maxI = 0;
        int maxJ = 0;
        for (int i = 0; i < (a[0].length - 1); i++) {
            for (int j = i + 1; j < a[0].length; j++) {
                double d = ((a[0][i] - a[0][j]) * (a[0][i] - a[0][j])) + ((a[1][i] - a[1][j]) * (a[1][i] - a[1][j]));
                if (d > maxD) {
                    maxD = d;
                    maxI = i;
                    maxJ = j;
                }
            }
        }
        System.out.println("Наибольшее расстояние между точками " + (maxI + 1) + " и " + (maxJ + 1));
    }
}
