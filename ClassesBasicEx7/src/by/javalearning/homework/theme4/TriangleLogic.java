package by.javalearning.homework.theme4;

/* 
 * 4. Programming with classes
 * Простейшие классы и объекты.
 * Задача 7. Описать класс, представляющий треугольник. Предусмотреть методы 
 * для создания объектов, вычисления площади, периметра и точки пересечения 
 * медиан.
 */

public class TriangleLogic {

    private double sideAB; // длины сторон
    private double sideBC;
    private double sideAC;

    private double pp; // периметр
    private double s; // площадь

    private double mX; // координаты точки пересечения медиан
    private double mY;

    public Triangle makeTriangle(double xA, double yA, double xB, double yB, double xC, double yC) {

	// проверяем, можно ли построить такой треугольник
	double a = yB - yA;
	double b = xA - xB;
	double c = xA * (yA - yB) + yA * (xB - xA);
	double z = a * xC + b * yC + c;
	if (z == 0d)
	    return null;
	else
	    return new Triangle(xA, yA, xB, yB, xC, yC);
    }

    public void calcTriangle(Triangle t) {

	this.sideAB = calcSide(t.getxA(), t.getyA(), t.getxB(), t.getyB()); // определяем длины сторон
	this.sideBC = calcSide(t.getxB(), t.getyB(), t.getxC(), t.getyC());
	this.sideAC = calcSide(t.getxA(), t.getyA(), t.getxC(), t.getyC());
	this.pp = calcPerimeter(getSideAB(), getSideBC(), getSideAC()); // периметр
	this.s = calcArea(getPp(), getSideAB(), getSideBC(), getSideAC()); // площадь
	this.mX = calcMedianCrossXY(t.getxA(), t.getxB(), t.getxC()); // координаты точки пересечения медиан
	this.mY = calcMedianCrossXY(t.getyA(), t.getyB(), t.getyC());

    }

    private double calcMedianCrossXY(double xA, double xB, double xC) {
	return (xA + xB + xC) / 3;
    }

    private double calcArea(double pp, double sideAB, double sideBC, double sideAC) {
	double p = pp / 2; // полупериметр
	return (Math.sqrt(p * (p - sideAB) * (p - sideBC) * (p - sideAC)));
    }

    private double calcPerimeter(double sideAB, double sideBC, double sideAC) {
	return sideAB + sideBC + sideAC;
    }

    private double calcSide(double x1, double y1, double x2, double y2) {
	return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
    }

    public double getSideAB() {
	return sideAB;
    }

    public double getSideBC() {
	return sideBC;
    }

    public double getSideAC() {
	return sideAC;
    }

    public double getPp() {
	return pp;
    }

    public double getS() {
	return s;
    }

    public double getmX() {
	return mX;
    }

    public double getmY() {
	return mY;
    }

    public void setSideAB(double sideAB) {
	this.sideAB = sideAB;
    }

    public void setSideBC(double sideBC) {
	this.sideBC = sideBC;
    }

    public void setSideAC(double sideAC) {
	this.sideAC = sideAC;
    }

    public void setPp(double pp) {
	this.pp = pp;
    }

    public void setS(double s) {
	this.s = s;
    }

    public void setmX(double mX) {
	this.mX = mX;
    }

    public void setmY(double mY) {
	this.mY = mY;
    }

}
