package by.javalearning.homework.theme4;

import java.util.Scanner;

/* 
 * 4. Programming with classes
 * Простейшие классы и объекты.
 * Задача 3. Создайте класс с именем Student, содержащий поля: фамилия и 
 * инициалы, номер группы, успеваемость (массив из пяти элементов). Создайте 
 * массив из десяти элементов такого типа. Добавьте возможность вывода фамилий 
 * и номеров групп студентов, имеющих оценки, равные только 9 или 10.
 */

public class Main {

    static Student[] student = { 
	    new Student("Иванов", "ИИ", 1, new int[] { 6, 10, 8, 6, 9 }),
	    new Student("Петров", "ПП", 2, new int[] { 7, 9, 6, 10, 10 }),
	    new Student("Сидоров", "СС", 3, new int[] { 8, 8, 3, 7, 6 }),
	    new Student("Николаев", "НН", 1, new int[] { 9, 10, 9, 9, 9 }),
	    new Student("Попов", "ПП", 2, new int[] { 6, 8, 7, 6, 7 }),
	    new Student("Ложкин", "ЛЕ", 3, new int[] { 5, 7, 9, 9, 6 }),
	    new Student("Вилкин", "ВИ", 1, new int[] { 10, 10, 10, 10, 10 }),
	    new Student("Печкин", "ЛИ", 2, new int[] { 10, 10, 9, 10, 9 }),
	    new Student("Тупой", "ЛА", 3, new int[] { 9, 10, 10, 9, 9 }),
	    new Student("Горидзе", "АИ", 1, new int[] { 10, 9, 9, 10, 9 }), };
    static StudentLogic stLog = new StudentLogic();

    public static void main(String[] args) {

	startMenu();
    }

    private static void startMenu() {
	
	Scanner sc = new Scanner(System.in);
	int i = 0;
	while (i != 3) {
	    i = 0;
	    System.out.println("У нас есть студенты. Что с ними делать?");
	    System.out.println("1-Кто имеет оценки не ниже 9?");
	    System.out.println("2-Вывести всех на экран");
	    System.out.println("3-Завершить программу");
	    if (sc.hasNextInt()) {
		i = sc.nextInt();
	    } else {
		System.out.println("Попробуйте еще раз!");
		System.exit(1);
	    }

	    if (i == 1) {
		for (int j = 0; j < student.length; j++) {
		    if (stLog.isExcelent(student[j])) {
			System.out.println(student[j].toString());
		    }
		}
	    }

	    if (i == 2) {
		for (var s : student) {
		    System.out.println(s.toString()); 
		}
	    }

	    if (i == 3) {
		break;
	    }
	}
	sc.close();

    }

}
