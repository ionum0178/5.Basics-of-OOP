package by.javalearning.homework.theme4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

public class CustomerList {

    private static List<Customer> clients = new ArrayList<>();
    private AlphabeticComparator comparatorABC = new AlphabeticComparator();
    private IDComparator comparatorID = new IDComparator();

    public CustomerList() {
    }

    public List<Customer> getClients() {
	return clients;
    }

    public void getList() {
	for (var c : clients)
	    System.out.println(c.toString());
    }

    public void addClient(Customer customer) {
	CustomerList.clients.add(customer);
    }

    public List<Customer> alphabeticSort() {
	clients.sort(comparatorABC);
	return clients;
    }

    public List<Customer> idSort() {
	clients.sort(comparatorID);
	return clients;

    }

    public void deleteCustomer(int del) {
	for (int i = 0; i < clients.size(); i++) {
	    if (clients.get(i).getId() == del)
		clients.remove(i);
	}
    }

    public void printIfCardInterval(String from, String to) {
	for (int i = 0; i < clients.size(); i++) {
	    if (clients.get(i).getCreditCard().compareTo(from) >= 0
		    && clients.get(i).getCreditCard().compareTo(to) <= 0)
		System.out.println(clients.get(i).toString());
	}
    }

    public static class AlphabeticComparator implements Comparator<Customer> {
	@Override
	public int compare(Customer o1, Customer o2) {
	    if (o1.getName() != o2.getName())
		return o1.getName().compareTo(o2.getName());
	    if (o1.getSurname() != o2.getSurname())
		return o1.getSurname().compareTo(o2.getSurname());
	    return o1.getPatronymic().compareTo(o2.getPatronymic());
	}
    }

    public static class IDComparator implements Comparator<Customer> {
	@Override
	public int compare(Customer o1, Customer o2) {
	    return o1.getId() - o2.getId();
	}
    }

}
