package by.javalearning.homework.theme4;

import java.util.Scanner;

/* 
 * 4. Programming with classes
 * Простейшие классы и объекты.
 * Задача 7. Описать класс, представляющий треугольник. Предусмотреть методы 
 * для создания объектов, вычисления площади, периметра и точки пересечения 
 * медиан.
 */

public class Main {

    public static TriangleLogic tr;
    public static Triangle triangle;

    public static void main(String[] args) {

	tr = new TriangleLogic();
	triangle = makeTriangle();

	if (triangle == null) {
	    System.out.println("Эти точки лежат на одной прямой, треугольник построить невозможно!");
	} else {
	    tr.calcTriangle(triangle);

	    System.out.println("Длины сторон треугольника:");
	    System.out.print("A=" + tr.getSideAB() + ", ");
	    System.out.print("B=" + tr.getSideBC() + ", ");
	    System.out.print("C=" + tr.getSideAC() + "\n");
	    System.out.println("Периметр треугольника:");
	    System.out.println("P=" + tr.getPp());
	    System.out.println("Площадь треугольника:");
	    System.out.println("S=" + tr.getS());
	    System.out.println("Координаты точки пересечения медиан треугольника:");
	    System.out.println("Xm=" + tr.getmX());
	    System.out.println("Ym=" + tr.getmY());
	}

    }

    public static Triangle makeTriangle() {

	System.out.println("Введите координаты вершин треугольника:");
	System.out.print("xA=");
	double xA = input();
	System.out.print("yA=");
	double yA = input();
	System.out.print("xB=");
	double xB = input();
	System.out.print("yB=");
	double yB = input();
	System.out.print("xC=");
	double xC = input();
	System.out.print("yC=");
	double yC = input();

	triangle = tr.makeTriangle(xA, yA, xB, yB, xC, yC);

	return triangle;
    }

    private static double input() {
	@SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
	double i;
	while (true) {
	    if (sc.hasNextDouble()) {
		i = sc.nextDouble();
		break;
	    } else
		sc.nextLine();
	}
	return i;
    }
}
