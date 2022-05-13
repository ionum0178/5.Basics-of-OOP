package by.javalearning.homework.theme4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* 
 * 4. Programming with classes
 * Простейшие классы и объекты.
 * Задача 8. Создать класс Customer, спецификация которого приведена ниже. 
 * Определить конструкторы, set-и get-методы и метод toString(). Создать второй
 * класс, агрегирующий массив типа Customer, с подходящими конструкторами и 
 * методами. Задать критерии выбора данных и вывести эти данные на консоль. 
 * Класс Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки,
 * номер банковского счета. 
 * Найти и вывести: a) список покупателей в алфавитном порядке; b) список 
 * покупателей, у которых номер кредитной карточки находится в заданном интервале
 */

public class Main {

    static CustomerList customers = new CustomerList();
    static CustomerLogic customer = new CustomerLogic();
    static String surname;
    static String name;
    static String patronymic;
    static String adress;
    static String creditCard;
    static String accountNumber;

    public static void main(String[] args) {
	makeCustomerList();
	startMenu();
    }

    private static void makeCustomerList() {
	File file = new File("./src/resource/base.txt");
	Scanner sc;
	try {
	    sc = new Scanner(file).useDelimiter(";|\\r\\n");
	    while (sc.hasNextLine()) {
		surname = sc.next();
		name = sc.next();
		patronymic = sc.next();
		adress = sc.next();
		creditCard = sc.next();
		accountNumber = sc.next();
		customer.newCustomer(name, surname, patronymic, adress, creditCard, accountNumber);
		continue;
	    }
	} catch (FileNotFoundException e) {
	    System.out.println("File not found");
	    e.printStackTrace();
	    System.exit(1);
	}
    }

    public static void startMenu() {
	Scanner sc = new Scanner(System.in);
	int i = -1;
	while (i != 6) {
	    System.out.println("1-Вывести весь список клиентов (по умолчанию)");
	    System.out.println("2-Вывести весь список клиентов в алфавитном порядке");
	    System.out.println("3-Задать интервал номеров кредитных карточек");
	    System.out.println("  для поиска клиентов и вывести список на экран");
	    System.out.println("4-Добавить клиента");
	    System.out.println("5-Удалить клиента из базы");
	    System.out.println("6-Завершить программу");
	    if (sc.hasNextInt()) {
		i = sc.nextInt();
		sc.nextLine();
	    } else {
		System.out.println("Попробуйте еще раз!");
		break;
	    }
	    switch (i) {
	    case 1: {
		customers.idSort();
		customers.getList();
		break;
	    }
	    case 2: {
		customers.alphabeticSort();
		customers.getList();
		break;
	    }
	    case 3: {
		System.out.println("Введите диапазон номеров кредитных карт:");
		System.out.print("От: ");
		String from = sc.nextLine();
		System.out.print("До: ");
		String to = sc.nextLine();
		customers.printIfCardInterval(from, to);
		break;
	    }
	    case 4: {
		newCustomer();
		break;
	    }
	    case 5: {
		customers.getList();
		System.out.print("Введите ID клиента, которого нужно удалить из базы: ");
		int del = sc.nextInt();
		customers.deleteCustomer(del);
		break;
	    }
	    case 6: {
		sc.close();
		break;
	    }
	    }

	}
    }
    
    public static void newCustomer() {
	@SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
	System.out.print("Фамилия: ");
	surname = sc.nextLine();
	System.out.print("Имя: ");
	name = sc.nextLine();
	System.out.print("Отчество: ");
	patronymic = sc.nextLine();
	System.out.print("Адрес: ");
	adress = sc.nextLine();
	System.out.print("Номер кредитной карты: ");
	creditCard = sc.nextLine();
	System.out.print("Номер банковского счета: ");
	accountNumber = sc.nextLine();
	customer.newCustomer(name, surname, patronymic, adress, creditCard, accountNumber);
    }
    
}
