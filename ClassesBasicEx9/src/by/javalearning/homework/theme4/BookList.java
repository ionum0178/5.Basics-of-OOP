package by.javalearning.homework.theme4;

import java.util.ArrayList;
import java.util.Comparator;

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

class BookList {

    private static ArrayList<Book> bookShell = new ArrayList<>();
    private IDComparator comparatorID = new IDComparator();

    public BookList() {
    }

    public void addBook(Book book) {
	bookShell.add(book);
    }

    public ArrayList<Book> getBookShell() {
	return bookShell;
    }

    public void getList() {
	for (var c : bookShell)
	    System.out.println(c.toString());
    }

    public void getAuthorsBooks(String author) {
	int j = 0;
	for (int i = 0; i < bookShell.size(); i++) {
	    if (bookShell.get(i).getAuthors().equalsIgnoreCase(author)) {
		System.out.println(bookShell.get(i).toString());
		j++;
	    }
	}
	if (j == 0)
	    System.out.println("Не найдено книг этого автора.");
    }

    public void getPublisherBooks(String publisher) {
	int j = 0;
	for (int i = 0; i < bookShell.size(); i++) {
	    if (bookShell.get(i).getPublisher().equalsIgnoreCase(publisher)) {
		System.out.println(bookShell.get(i).toString());
		j++;
	    }
	}
	if (j == 0)
	    System.out.println("Не найдено книг этого издательства.");
    }
    
    public void getAfterYearBooks(int year) {
	int j = 0;
	for (int i = 0; i < bookShell.size(); i++) {
	    if (bookShell.get(i).getYear() >= year) {
		System.out.println(bookShell.get(i).toString());
		j++;
	    }
	}
	if (j == 0)
	    System.out.println("Не найдено книг, изданных начиная с этого года.");
    }
    
    public ArrayList<Book> idSort() {
	bookShell.sort(comparatorID);
	return bookShell;
    }

    public void deleteBook(int del) {
	for (int i = 0; i < bookShell.size(); i++) {
	    if (bookShell.get(i).getId() == del)
		bookShell.remove(i);
	}
    }

    public static class IDComparator implements Comparator<Book> {
	@Override
	public int compare(Book o1, Book o2) {
	    return o1.getId() - o2.getId();
	}
    }

}
