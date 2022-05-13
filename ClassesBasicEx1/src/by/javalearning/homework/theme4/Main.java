package by.javalearning.homework.theme4;

/* 
 * 4. Programming with classes
 * Простейшие классы и объекты.
 * Задача 1. Создайте класс Test1 с двумя переменными. Добавьте метод вывода 
 * на экран и методы изменения этих переменных. Добавьте метод, который 
 * находит сумму значений этих переменных, и метод,который находит наибольшее 
 * значение из этих двух переменных.
 */

public class Main {

    public static Test1 test1;

    public static void main(String[] args) {
	
	test1 = new Test1();
	System.out.println("Первоначально x=0, y=0");
	
	//изменяем значения переменных
	test1.setX(15);
	test1.setY(11);
	
	//выводим значения на экран
	printXY();
	
	//сумма x+y
	System.out.println("x+y=" + getSum() + "\n");
	
	//наибольшее значение
	System.out.println("Max value = " + getMax());
	
    }

    
    public static void printXY() {
	System.out.println("x=" + test1.getX());
	System.out.println("y=" + test1.getY() + "\n");
    }

    
    public static int getSum() {
	return (test1.getX()+test1.getY());
    }
    
    
    public static int getMax() {
	return test1.getX() > test1.getY() ? test1.getX() : test1.getY();
    }

}
