package by.javalearning.homework.theme4;

import java.util.Objects;

/*
 * 4. Programming with classes
 * Агрегация и композиция.
 * 4. Счета. Клиент может иметь несколько счетов в банке. Учитывать возможность 
 * блокировки/разблокировки счета. Реализовать поиск и сортировку счетов. 
 * Вычисление общей суммы по счетам. Вычисление суммы по всем счетам, имеющим 
 * положительный и отрицательный балансы отдельно. 
 */

public class Account {
    private int accountID;
    private String account_nr;
    private double balance;
    private boolean blocked;
    private Client client;

    public Account(int accountID, String account_nr, double balance, boolean blocked, Client client) {
	this.accountID = accountID;
	this.account_nr = account_nr;
	this.balance = balance;
	this.blocked = blocked;
	this.client = client;
    }

    public int getAccountID() {
	return accountID;
    }

    public void setAccountID(int accountID) {
	this.accountID = accountID;
    }

    public String getAccount_nr() {
	return account_nr;
    }

    public void setAccount_nr(String account_nr) {
	this.account_nr = account_nr;
    }

    public double getBalance() {
	return balance;
    }

    public void setBalance(double balance) {
	this.balance = balance;
    }

    public boolean isBlocked() {
	return blocked;
    }

    public void setBlocked(boolean blocked) {
	this.blocked = blocked;
    }
    
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public int hashCode() {
	return Objects.hash(accountID, account_nr, balance, blocked, client);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Account other = (Account) obj;
	return accountID == other.accountID && Objects.equals(account_nr, other.account_nr)
		&& Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance)
		&& blocked == other.blocked && Objects.equals(client, other.client);
    }

    public String toString() {
	String string = "";
	string = "Номер счета: ID " + getAccountID() + " " + getAccount_nr() + " Баланс: " + getBalance() + "\n"
		+ "Состояние счета: ";
	if (isBlocked())
	    string += "заблокирован\n";
	else
	    string += "разблокирован\n";
	return string;

    }

}
