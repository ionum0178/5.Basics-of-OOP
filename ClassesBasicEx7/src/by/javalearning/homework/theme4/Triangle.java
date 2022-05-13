package by.javalearning.homework.theme4;

/* 
 * 4. Programming with classes
 * Простейшие классы и объекты.
 * Задача 7. Описать класс, представляющий треугольник. Предусмотреть методы 
 * для создания объектов, вычисления площади, периметра и точки пересечения 
 * медиан.
 */

public class Triangle {

    private double xA; // координаты сторон
    private double yA;
    private double xB;
    private double yB;
    private double xC;
    private double yC;

    public Triangle(double xA, double yA, double xB, double yB, double xC, double yC) {
	this.setxA(xA);
	this.setyA(yA);
	this.setxB(xB);
	this.setyB(yB);
	this.setxC(xC);
	this.setyC(yC);
    }
        

    public double getxA() {
	return xA;
    }

    public void setxA(double xA) {
	this.xA = xA;
    }

    public double getyA() {
	return yA;
    }

    public void setyA(double yA) {
	this.yA = yA;
    }

    public double getxB() {
	return xB;
    }

    public void setxB(double xB) {
	this.xB = xB;
    }

    public double getxC() {
	return xC;
    }

    public void setxC(double xC) {
	this.xC = xC;
    }

    public double getyB() {
	return yB;
    }

    public void setyB(double yB) {
	this.yB = yB;
    }

    public double getyC() {
	return yC;
    }

    public void setyC(double yC) {
	this.yC = yC;
    }
    
}
