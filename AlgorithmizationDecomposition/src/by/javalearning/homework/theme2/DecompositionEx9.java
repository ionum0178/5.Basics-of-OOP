package by.javalearning.homework.theme2;

import java.util.Scanner;

// 2.Algorithmisation
// Декомпозиция с использованием методов (подпрограммы).
// Задача 9. Даны числа X, Y, Z, Т —длины сторон четырехугольника. Написать метод 
// (методы) вычисления его площади, если угол между сторонами длиной X и Y—прямой.

public class DecompositionEx9 {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите длины сторон четырехугольника:");
        System.out.print("X=");
        double x = in.nextDouble();
        System.out.print("Y=");
        double y = in.nextDouble();
        System.out.print("Z=");
        double z = in.nextDouble();
        System.out.print("T=");
        double t = in.nextDouble();
        System.out.println("Площадь четырехугольника равна: " + s(x, y, z, t));
        in.close();
    }

    // Площадь четырехугольника: разбиваем его на два треугольника, один из них
    // прямоугольный
    static double s(double x, double y, double z, double t) {
        double s1 = x * y / 2;
        double r = Math.sqrt(x * x + y * y);
        double p = (z + t + r) / 2;
        double s2 = Math.sqrt(p * (p - z) * (p - t) * (p - r));
        return s1 + s2;
    }
}
