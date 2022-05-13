package by.javalearning.homework.theme4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* 
 * 4. Programming with classes
 * Простейшие классы и объекты.
 * Задача 9. Создать класс Book, спецификация которого приведена ниже. 
 * Определить конструкторы, set-и get-методы и метод  toString(). Создать 
 * второй класс, агрегирующий массив типа Book, с подходящими конструкторами 
 * и методами. Задать критерии выбора данных и вывести эти данные на консоль. 
 * Book: id, название, автор(ы), издательство, год издания, количество страниц, 
 * цена, тип переплета. Найти и вывести: a) список книг заданного автора; 
 * b) список книг, выпущенных заданным издательством; c) список книг, 
 * выпущенных после заданного года.
 */


public class Main {

    static BookList books = new BookList();
    static BookLogic book = new BookLogic();
    static String title;
    static String authors;
    static String publisher;
    static int year;
    static int pages;
    static int price;
    static String binding;

    public static void main(String[] args) throws FileNotFoundException {
	fillBookShell();
	startMenu();
    }

    private static void fillBookShell() {
	File file = new File(
		"books.txt");
	Scanner sc = null;
	try {
	    sc = new Scanner(file).useDelimiter("\\s—\\s|;\\s|\\r\\n");
	    while (sc.hasNextLine()) {
		title = sc.next();
		authors = sc.next();
		publisher = sc.next();
		year = Integer.parseInt(sc.next());
		pages = Integer.parseInt(sc.next());
		price = Integer.parseInt(sc.next());
		binding = sc.next();
		book.newBook(title, authors, publisher, year, pages, price, binding);
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
	while (i != 7) {
	    System.out.println("1-Вывести весь список книг (по умолчанию)");
	    System.out.println("2-Вывести список книг заданного автора");
	    System.out.println("3-Вывести список книг, выпущенных издательством");
	    System.out.println("4-Вывести список книг, выпущенных после заданного года");
	    System.out.println("5-Добавить книгу в базу");
	    System.out.println("6-Удалить книгу из базы");
	    System.out.println("7-Завершить программу");
	    if (sc.hasNextInt()) {
		i = sc.nextInt();
		sc.nextLine();
	    } else {
		System.out.println("Попробуйте еще раз!");
		System.exit(1);
	    }
	    switch (i) {
	    case 1: {
		books.idSort();
		books.getList();
		break;
	    }
	    case 2: {
		System.out.print("Введите автора: ");
		String author = sc.nextLine();
		books.getAuthorsBooks(author);
		break;
	    }
	    case 3: {
		System.out.print("Введите издательство: ");
		String publisher = sc.nextLine();
		books.getPublisherBooks(publisher);
		break;
	    }
	    case 4: {
		System.out.print("Введите год издания: ");
		int year = sc.nextInt();
		books.getAfterYearBooks(year);
		break;
	    }
	    case 5: {
		book.newBook();
		break;
	    }
	    case 6: {
		books.getList();
		System.out.print("Введите ID книги, которую нужно удалить из базы: ");
		int del = sc.nextInt();
		books.deleteBook(del);
		break;
	    }
	    case 7: {
		sc.close();
		System.exit(1);
	    }
	    }

	}
    }
}

