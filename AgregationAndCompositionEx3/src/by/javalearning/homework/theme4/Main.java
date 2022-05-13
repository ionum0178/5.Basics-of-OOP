package by.javalearning.homework.theme4;

import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * 4. Programming with classes
 * Агрегация и композиция.
 * 3. Создать объект класса Государство, используя классы Область, Район, Город.
 * Методы: вывести на консоль столицу, количество областей, площадь, областные центры.
 */

public class Main {
    
    public static void main(String[] args) {
	CountryLogic cl = new CountryLogic();
	Country country = null; 
	try {
	    country = cl.newCountry();
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	    System.exit(1);
	}
	
	startMenu(country);

    }

    private static void startMenu(Country country) {
	@SuppressWarnings("resource")
	Scanner scanner = new Scanner(System.in);
	while (true) {
	    System.out.println("Выберите пункт меню:\n" 
		    + "0. выход\n" 
		    + "1. вывести на экран столицу\n"
		    + "2. вывести на экран количество областей\n" 
		    + "3. вывести на экран площадь\n"
		    + "4. вывести на экран областные центры\n" 
		    + "5. вывести на экран всю информацию о государстве\n");
	    int choice = scanner.nextInt();
	    if (choice == 0) {
		System.out.println("Попробуйте еще раз!");
		System.exit(1);
	    }
	    if (choice < 1 || choice > 5) {
		System.out.println("выбран неправильный пункт меню, повторите ввод.");
		continue;
	    }
	    switch (choice) {
	    case 1:
		System.out.println("Столица: город " + country.getCapital());
		break;
	    case 2:
		System.out.println("Количество областей: " + country.getRegions().size());
		break;
	    case 3:
		System.out.println("Площадь страны: " + country.getArea() + " кв.км");
		break;
	    case 4:
		for (int i = 0; i < country.getRegions().size(); i++) {
		    System.out.println(country.getRegions().get(i).toString());
		}
		break;
	    case 5:
		System.out.println(country.toString());
		
		break;
	    }
	}
	}

    }


