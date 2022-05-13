package by.javalearning.homework.theme4;

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

class Book {

    private int id;
    private static int nextID=1;
    private String title;
    private String authors;
    private String publisher;
    private int year;
    private int pages;
    private int price;
    private String binding;
    private static BookList volume = new BookList();

    public Book(String title, String authors, String publisher, int year, int pages, int price, String binding) {
	this.id = nextID++;
	this.title = title;
	this.authors = authors;
	this.publisher = publisher;
	this.year = year;
	this.pages = pages;
	this.price = price;
	this.binding = binding;
    }


    public void getList() {
	for (var c : volume.getBookShell())
	    System.out.println(c.toString());
    }

    @Override
    public String toString() {
	return "id: " + id + ", Название: " + title + ", автор(ы) " + authors + ", издательство " + publisher
		+ ", год издания: " + year + ", количество страниц: " + pages + ", цена: " + price + ", тип переплета: "
		+ binding;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public String getAuthors() {
	return authors;
    }

    public void setAuthors(String authors) {
	this.authors = authors;
    }

    public String getPublisher() {
	return publisher;
    }

    public void setPublisher(String publisher) {
	this.publisher = publisher;
    }

    public int getYear() {
	return year;
    }

    public void setYear(int year) {
	this.year = year;
    }

    public int getPages() {
	return pages;
    }

    public void setPages(int pages) {
	this.pages = pages;
    }

    public int getPrice() {
	return price;
    }

    public void setPrice(int price) {
	this.price = price;
    }

    public String getBinding() {
	return binding;
    }

    public void setBinding(String binding) {
	this.binding = binding;
    }
}
