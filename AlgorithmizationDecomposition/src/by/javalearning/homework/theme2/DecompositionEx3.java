package by.javalearning.homework.theme2;

import java.util.Scanner;
import java.lang.Math;

// 2.Algorithmisation
// Декомпозиция с использованием методов (подпрограммы).
// Задача 3. Вычислить площадь правильного шестиугольника со стороной а, 
// используя метод вычисления площади треугольника.

public class DecompositionEx3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер стороны правильного шестиуголльника:");
        System.out.print("A=");
        double a = in.nextDouble();
        System.out.println("Площадь шестиугольника равна: " + (6 * s(a)));
    // Площадь правильного шестиугольника равна площади шести равносторонних
    // треугольников с длиной стороны, равной длине стороны шестиугольника.
        in.close();
}
    // Площадь равностороннего треугольника
    static double s(double a) {
        double s = Math.sqrt(3) * a * a / 4;
        return s;
    }
}
