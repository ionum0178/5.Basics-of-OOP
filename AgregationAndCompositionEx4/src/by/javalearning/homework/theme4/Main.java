package by.javalearning.homework.theme4;

import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * 4. Programming with classes
 * Агрегация и композиция.
 * 4. Счета. Клиент может иметь несколько счетов в банке. Учитывать возможность 
 * блокировки/разблокировки счета. Реализовать поиск и сортировку счетов. 
 * Вычисление общей суммы по счетам. Вычисление суммы по всем счетам, имеющим 
 * положительный и отрицательный балансы отдельно. 
 */

public class Main {

    public static void main(String[] args) {

	AccountLogic accLogic = new AccountLogic();

	try {
	    accLogic.fillAccountBase();
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	    System.exit(1);
	}
	startMenu(accLogic);
    }

    private static void startMenu(AccountLogic accLogic) {
	Scanner scanner = new Scanner(System.in);
	int id;
	int idd;
	while (true) {
	    System.out.println("Выберите пункт меню:\n" + "0. выход\n"
		    + "1. вывести список всех счетов банка (сортировка по умолчанию)\n"
		    + "2. вывести список всех счетов банка (сортировка по номеру счета)\n"
		    + "3. вывести список клиентов банка (сортировка по алфавиту)\n"
		    + "4. вывести список всех счетов банка (сортировка по возрастанию суммы на счету)\n"
		    + "5. вывести список всех счетов банка (сортировка по убыванию суммы на счету)\n"
		    + "6. вывести список счетов заданного клиента, подсчет положительного, отрицательного и общего баланса\n"
		    + "7. блокировка счета заданного клиента\n" + "8. разблокировка счета заданного клиента\n");
	    int choice = scanner.nextInt();
	    if (choice == 0) {
		System.out.println("Попробуйте еще раз!");
		break;
	    }
	    if (choice < 1 || choice > 10) {
		System.out.println("Выбран неправильный пункт меню, попробуйте еще раз!");
		continue;
	    }
	    switch (choice) {
	    case 1: // по умолчанию сортируем клиентов по ID
		accLogic.sortClientsByID();
		accLogic.cliAccsToString(); // вывод базы счетов клиентов по схеме клиент -> его счет
		break;

	    case 2: // сортировка по номеру счета
		accLogic.sortAccountsByNr();
		accLogic.allAccsToString();
		break;

	    case 3: // список клиентов банка (сортировка по алфавиту)
		accLogic.sortClientsByName();
		accLogic.cliToString();
		break;

	    case 4: // сортировка по возрастанию суммы на счету
		accLogic.sortAccountsByBalanceIncrease();
		accLogic.accCliToString(); // вывод базы счетов клиентов по схеме счет -> его владелец
		break;

	    case 5: // сортировка по убыванию суммы на счету
		accLogic.sortAccountsByBalanceDecrease();
		accLogic.accCliToString();
		break;

	    case 6: // список счетов заданного клиента, подсчет балансов
		accLogic.sortClientsByID();
		accLogic.cliToString();

		id = accLogic.getClientID(scanner);
		accLogic.cliAccsToString(id - 1);

		System.out.println("Сумма по счетам с положительным балансом: " + accLogic.getDebet(id));
		System.out.println("Сумма по счетам с отрицательным балансом: " + accLogic.getCredit(id));
		System.out.println("Общая сумма по всем счетам клиента: " + accLogic.getBalanceSum(id));
		break;

	    case 7: // блокировка счета заданного клиента
		accLogic.sortClientsByID();
		accLogic.cliToString();
		
		id = accLogic.getClientID(scanner);
		accLogic.cliAccsToString(id - 1);
		
		idd = accLogic.getAccID(scanner);
		accLogic.accBlock(idd);
		
		break;

	    case 8: // разблокировка счета заданного клиента
		accLogic.sortClientsByID();
		accLogic.cliToString();

		id = accLogic.getClientID(scanner);
		accLogic.cliAccsToString(id - 1);
		
		idd = accLogic.getAccID(scanner);
		accLogic.accUnblock(idd);
		
		break;
	    }

	    
	}
    }
}
