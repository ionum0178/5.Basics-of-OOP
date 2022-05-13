package by.javalearning.homework.theme4;

/* 
 * 4. Programming with classes
 * Простейшие классы и объекты.
 * Задача 2. Создйте класс Test2 c двумя переменными. Добавьте конструктор с
 * входными параметрами. Добавьте конструктор, инициализирующий члены класса 
 * по умолчанию. Добавьте set-и get- методы для полей экземпляра класса.
 */

public class Main {
    
    public static Test2 test2;

    public static void main(String[] args) {
	
	test2=new Test2(3, 4);
	
	System.out.println("Значения по умолчанию:\n");
	printXY();
	
	//изменяем значения переменных
	test2.setX(15);
	test2.setY(11);
	
	//выводим значения на экран
	printXY();
	
    }

    
    public static void printXY() {
	System.out.println("x=" + test2.getX());
	System.out.println("y=" + test2.getY() + "\n");
    }

    
    public static int getSum() {
	return (test2.getX()+test2.getY());
    
    }
}
