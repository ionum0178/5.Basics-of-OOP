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

public class CustomerLogic {

    private CustomerList clients = new CustomerList();
    
    public void newCustomer(String name, String surname, String patronymic, String adress, String creditCard,
	    String accountNumber) {
	Customer customer = new Customer(name, surname, patronymic, adress, creditCard, accountNumber);
	clients.addClient(customer);
    }
    
}
