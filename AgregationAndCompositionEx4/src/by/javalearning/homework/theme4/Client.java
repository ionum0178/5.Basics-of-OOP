package by.javalearning.homework.theme4;

import java.util.List;
import java.util.Objects;

/*
 * 4. Programming with classes
 * Агрегация и композиция.
 * 4. Счета. Клиент может иметь несколько счетов в банке. Учитывать возможность 
 * блокировки/разблокировки счета. Реализовать поиск и сортировку счетов. 
 * Вычисление общей суммы по счетам. Вычисление суммы по всем счетам, имеющим 
 * положительный и отрицательный балансы отдельно. 
 */

public class Client {
    private int clientID;
    private String name;
    private String surname;
    private List<Account> accounts;

    public Client(int clientID, String name, String surname) {
	this.clientID = clientID;
	this.name = name;
	this.surname = surname;
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

    public List<Account> getAccounts() {
	return accounts;
    }

    public void setAccounts(List<Account> accounts) {
	this.accounts = accounts;
    }

    public int getClientID() {
	return clientID;
    }

    public void setClientID(int clientID) {
	this.clientID = clientID;
    }

    @Override
    public int hashCode() {
	return Objects.hash(accounts, clientID, name, surname);
    }
    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Client other = (Client) obj;
	return Objects.equals(accounts, other.accounts) && clientID == other.clientID
		&& Objects.equals(name, other.name) && Objects.equals(surname, other.surname);
    }
    
    public String toString() {
	String string = "";
	string = "Клиент: ID " + getClientID() + "; Фамилия: " + getName() + "; Имя: " + getSurname() + "\n";
	return string;
    }


}
