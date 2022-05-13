package by.javalearning.homework.theme4;

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

public class Customer {

    private int id;
    private static int nextID=1;
    private String name;
    private String surname;
    private String patronymic;
    private String adress;
    private String creditCard;
    private String accountNumber;
    
    public Customer(String name, String surname, String patronymic, String adress, String creditCard,
	    String accountNumber) {
	this.id = nextID++;
	this.name = name;
	this.surname = surname;
	this.patronymic = patronymic;
	this.adress = adress;
	this.creditCard = creditCard;
	this.accountNumber = accountNumber;
    }
   
    public int getId() {
	return id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getSurname() {
	return surname;
    }

    public void setSurname(String surname) {
	this.surname = surname;
    }

    public String getPatronymic() {
	return patronymic;
    }

    public void setPatronymic(String patronymic) {
	this.patronymic = patronymic;
    }

    public String getAdress() {
	return adress;
    }

    public void setAdress(String adress) {
	this.adress = adress;
    }

    public String getCreditCard() {
	return creditCard;
    }

    public void setCreditCard(String creditCard) {
	this.creditCard = creditCard;
    }

    public String getAccountNumber() {
	return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
	this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
	return "id: " + id + ", ФИО: " + surname + " " + name + " " + patronymic + ", адрес: " + adress
		+ ", карта: " + creditCard + ", счёт: " + accountNumber;
    }
   
}
