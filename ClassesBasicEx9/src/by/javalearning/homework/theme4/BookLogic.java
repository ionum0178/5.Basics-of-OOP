package by.javalearning.homework.theme4;

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

public class BookLogic {

    private String title;
    private String authors;
    private String publisher;
    private int year;
    private int pages;
    private int price;
    private String binding;
    private BookList books = new BookList();

    public void newBook() {
	@SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
	System.out.print("Название: ");
	title = sc.nextLine();
	System.out.print("Автор(ы): ");
	authors = sc.nextLine();
	System.out.print("Издательство: ");
	publisher = sc.nextLine();
	System.out.print("Год издания: ");
	year = sc.nextInt();
	System.out.print("Количество страниц: ");
	pages = sc.nextInt();
	System.out.print("Цена: ");
	price = sc.nextInt();
	System.out.print("Тип переплета: ");
	binding = sc.nextLine();
	books.addBook(new Book(title, authors, publisher, year, pages, price, binding));
    }


    public void newBook(String title, String authors, String publisher, int year, int pages, int price,
	    String binding) {
	Book book = new Book(title, authors, publisher, year, pages, price, binding);
	books.addBook(book);
    }
}
