package by.javalearning.homework.theme4;

import java.io.File;
import java.io.FileNotFoundException;

/*
 * 4. Programming with classes
 * Агрегация и композиция.
 * 4. Счета. Клиент может иметь несколько счетов в банке. Учитывать возможность 
 * блокировки/разблокировки счета. Реализовать поиск и сортировку счетов. 
 * Вычисление общей суммы по счетам. Вычисление суммы по всем счетам, имеющим 
 * положительный и отрицательный балансы отдельно. 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AccountLogic {

    private File file;
    private int clientID;
    private int accountID;
    private String name;
    private String surname;
    private String account_nr;
    private double balance;
    private boolean blocked;
    private Client client;

    private Account account;

    private List<Client> clients;

    private List<Account> accounts;
    private List<Account> client_accounts;

    @SuppressWarnings("resource")
    public void fillAccountBase() throws FileNotFoundException {

	clients = new ArrayList<Client>();
	accounts = new ArrayList<Account>();
	client_accounts = new ArrayList<Account>();

	file = new File("./src/resource/accounts.txt");

	Scanner sc;
	clientID = 0;
	accountID = 0;
	blocked = false;

	try {
	    sc = new Scanner(file).useDelimiter("\\s");

	    while (sc.hasNextLine()) {
		name = sc.next();
		surname = sc.next();
		account_nr = sc.next();
		balance = Double.parseDouble(sc.nextLine());
		accountID++;

		if (client == null) {
		    clientID++;
		    client = new Client(clientID, name, surname);
		    clients.add(client);
		    account = new Account(accountID, account_nr, balance, blocked,
			    (new Client(clientID, name, surname)));
		    accounts.add(account);
		    client_accounts.clear();
		    client_accounts.add(account);
		    client.setAccounts(new ArrayList<Account>(client_accounts));
		}

		else if (!client.getName().equals(name)) {
		    clientID++;
		    client = new Client(clientID, name, surname);
		    clients.add(client);
		    account = new Account(accountID, account_nr, balance, blocked,
			    (new Client(clientID, name, surname)));
		    accounts.add(account);
		    client_accounts.clear();
		    client_accounts.add(account);
		    client.setAccounts(new ArrayList<Account>(client_accounts));

		} else {
		    account = new Account(accountID, account_nr, balance, blocked,
			    (new Client(clientID, name, surname)));
		    accounts.add(account);
		    client_accounts.add(account);
		    client.setAccounts(new ArrayList<Account>(client_accounts));
		}
		continue;
	    }

	} catch (FileNotFoundException e) {
	throw e;
	}

    }

    public void sortClientsByID() {
	Collections.sort(clients, new Comparator<Client>() {
	    public int compare(Client o1, Client o2) {
		return o1.getClientID() - o2.getClientID();
	    }
	});
    }

    public void sortClientsByName() {
	Collections.sort(clients, new Comparator<Client>() {
	    public int compare(Client o1, Client o2) {
		return o1.getName().compareTo(o2.getName());
	    }
	});
    }

    public void sortAccountsByNr() {
	Collections.sort(accounts, new Comparator<Account>() {
	    public int compare(Account o1, Account o2) {
		return o1.getAccount_nr().compareTo(o2.getAccount_nr());
	    }
	});
    }

    public void sortAccountsByBalanceIncrease() {
	Collections.sort(accounts, new Comparator<Account>() {
	    public int compare(Account o1, Account o2) {
		return (int) (o1.getBalance() - o2.getBalance());
	    }
	});
    }

    public void sortAccountsByBalanceDecrease() {
	Collections.sort(accounts, new Comparator<Account>() {
	    public int compare(Account o1, Account o2) {
		return (int) (o1.getBalance() - o2.getBalance());
	    }
	});
	Collections.reverse(accounts);
    }

    public List<Client> getClients() {
	return clients;
    }

    public void setClients(ArrayList<Client> clients) {
	this.clients = clients;
    }

    public List<Account> getAccounts() {
	return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
	this.accounts = accounts;
    }

    public List<Account> getClient_accounts() {
	return client_accounts;
    }

    public void setClient_accounts(List<Account> client_accounts) {
	this.client_accounts = client_accounts;
    }

    public int getClientID(Scanner scanner) {
	System.out.println("Введите ID клиента:");
	while (true) {
	    int id = scanner.nextInt();
	    if (id < 0 || id > (clients.size() + 1)) {
		System.out.println("Клиента нет в базе, попробуйте еще раз!");
		continue;
	    } else
		return id;
	}
    }

    public int getAccID(Scanner scanner) {
	System.out.println("Введите ID счета клиента:");
	int idd;
	idd = scanner.nextInt();
	
	accounts.get(idd-1).getAccountID();
	accounts.get(idd-1).getClient();
	
	while (true) {
	    idd = scanner.nextInt();
	    int j = 0;
	    for (int i = 0; i < clients.get(idd - 1).getAccounts().size(); i++) {
		if (clients.get(idd - 1).getAccounts().get(i).getAccountID() == idd)
		    j++;
	    }
	    if (j == 0) {
		System.out.println("Такой счет у клиента не найден, попробуйте еще раз!");
		continue;
	    }
	    break;
	}
	return idd;
    }

    public double getDebet(int id) {
	double debet = 0;
	for (int i = 0; i < clients.get(id - 1).getAccounts().size(); i++) {
	    if (clients.get(id - 1).getAccounts().get(i).getBalance() >= 0)
		debet += clients.get(id - 1).getAccounts().get(i).getBalance();
	}
	return debet;
    }

    public double getCredit(int id) {
	double credit = 0;
	for (int i = 0; i < clients.get(id - 1).getAccounts().size(); i++) {
	    if (clients.get(id - 1).getAccounts().get(i).getBalance() < 0)
		credit += clients.get(id - 1).getAccounts().get(i).getBalance();
	}
	return credit;
    }

    public double getBalanceSum(int id) {
	double balance_sum = 0;
	for (int i = 0; i < clients.get(id - 1).getAccounts().size(); i++) {
	    balance_sum += clients.get(id - 1).getAccounts().get(i).getBalance();
	}
	return balance_sum;
    }

    public void accBlock(int idd) {
	for (int i = 0; i < clients.get(idd - 1).getAccounts().size(); i++) {
	    if (clients.get(idd - 1).getAccounts().get(i).getAccountID() == idd) {
		if (!clients.get(idd - 1).getAccounts().get(i).isBlocked()) {
		    clients.get(idd - 1).getAccounts().get(i).setBlocked(true);
		    System.out.println("Cчет заблокирован!\n");
		    System.out.println(
			    clients.get(idd - 1).toString() + clients.get(idd - 1).getAccounts().get(i).toString());
	    }
		else {
		    System.out.println("Этот счет уже заблокирован!");
		    System.out.println(
			    clients.get(idd - 1).toString() + clients.get(idd - 1).getAccounts().get(i).toString());
		}
	    }
	}
    }

    public void accUnblock(int idd) {
	for (int i = 0; i < clients.get(idd - 1).getAccounts().size(); i++) {
	    if (clients.get(idd - 1).getAccounts().get(i).getAccountID() == idd) {
		if (clients.get(idd - 1).getAccounts().get(i).isBlocked()) {
		    clients.get(idd - 1).getAccounts().get(i).setBlocked(false);
		    System.out.println("Cчет разблокирован!\n");
		    System.out.println(
			    clients.get(idd - 1).toString() + clients.get(idd - 1).getAccounts().get(i).toString());
	    }
		else {
		    System.out.println("Этот счет уже разблокирован!");
		    System.out.println(
			    clients.get(idd - 1).toString() + clients.get(idd - 1).getAccounts().get(i).toString());
		}
	    }
	}
    }

    public void cliAccsToString() {
	for (int i = 0; i < clients.size(); i++) {
	    System.out.println(clients.get(i).toString());
	    for (int j = 0; j < clients.get(i).getAccounts().size(); j++) {
		System.out.println(clients.get(i).getAccounts().get(j).toString());
	    }
	}
    }

    public void cliAccsToString(int id) {
	System.out.println(clients.get(id).toString());
	for (int j = 0; j < clients.get(id).getAccounts().size(); j++) {
	    System.out.println(clients.get(id).getAccounts().get(j).toString());
	}

    }

    public void allAccsToString() {
	for (int j = 0; j < accounts.size(); j++) {
	    System.out.println(accounts.get(j).toString());
	}
    }

    public void cliToString() {
	for (int i = 0; i < clients.size(); i++) {
	    System.out.println(clients.get(i).toString());
	}
    }

    public void accCliToString() {
	for (int j = 0; j < accounts.size(); j++) {
	    System.out.println(accounts.get(j).getClient().toString() + accounts.get(j).toString());
	}
    }
}
