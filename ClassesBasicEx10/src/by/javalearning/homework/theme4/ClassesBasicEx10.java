package by.javalearning.homework.theme4;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.Scanner;

/* 
 * 4. Programming with classes
 * Простейшие классы и объекты.
 * Задача 10. Создать класс Airline, спецификация которого приведена ниже. 
 * Определить конструкторы, set-и get-методы и метод  toString(). Создать 
 * второй класс, агрегирующий массив типа Airline, с подходящими конструкторами 
 * и методами. Задать критерии выбора данных и вывести эти данные на консоль. 
 * Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели. 
 * Найти и вывести: a) список рейсов для заданного пункта назначения; 
 * b) список рейсов для заданного дня недели; c) список рейсов для заданного 
 * дня недели, время вылета для которых больше заданного.
 */

public class ClassesBasicEx10 {

    static AirlineBase flights = new AirlineBase();
    static Airline flight;
    static String destination;
    static String flightNr;
    static String aircraftType;
    static LocalTime depart;
    static int[] weekDay = new int[7];

    public static void main(String[] args) throws FileNotFoundException {
	setDefaultFlightsTimeTable();
	startMenu();
    }
    
    private static void setDefaultFlightsTimeTable() {
	File file = new File(
		"D:\\Documents\\Корсеко\\Разное\\Мое\\Новая папка\\Eclipse\\ClassesBasicEx10\\src\\by\\javalearning\\theme4\\TimeTable.txt");
	Scanner sc = null;
	try {
	    sc = new Scanner(file).useDelimiter("\\t|:|\\r\\n");
	    while (sc.hasNextLine()) {
		destination = sc.next();
		String weekseq = sc.next();
		for(int i=0; i<weekDay.length; i++) {
		    weekDay[i]=0;
		    if(Character.isDigit(weekseq.charAt(i))) {
			weekDay[i]=Character.digit(weekseq.charAt(i), 10);
		    }
		}
		int hours = Integer.parseInt(sc.next());
		int minutes = Integer.parseInt(sc.next());
		depart = LocalTime.of(hours, minutes);
		flightNr = sc.next();
		aircraftType = sc.next();
		flight = new Airline(destination, flightNr, aircraftType, depart, weekDay);
		flight.newFlight(destination, flightNr, aircraftType, depart, weekDay);
		continue;
	    }
	} catch (FileNotFoundException e) {
	    System.out.println("File not found");
	    e.printStackTrace();
	    System.exit(1);
	}
    }

    public static void startMenu() {
	Scanner sc = new Scanner(System.in);
	int i = -1;
	while (i != 7) {
	    System.out.println("1-Вывести весь список рейсов (по умолчанию)");
	    System.out.println("2-Вывести список рейсов для заданного пункта назначения");
	    System.out.println("3-Вывести список рейсов для заданного дня недели");
	    System.out.println("4-Вывести список список рейсов для заданного \r\n"
	    	+ " дня недели, время вылета которых больше заданного");
	    System.out.println("5-Завершить программу");
	    if (sc.hasNextInt()) {
		i = sc.nextInt();
		sc.nextLine();
	    } else {
		System.out.println("Попробуйте еще раз!");
		System.exit(1);
	    }
	    switch (i) {
	    case 1: {
		flights.getList();
		break;
	    }
	    case 2: {
		System.out.print("Введите пункт назначения: ");
		String destination = sc.nextLine();
		flights.getFlightsByDestination(destination);
		break;
	    }
	    case 3: {
		System.out.println("Выберите день недели: ");
		System.out.println("1-Понедельник");
		System.out.println("2-Вторник");
		System.out.println("3-Среда");
		System.out.println("4-Четверг");
		System.out.println("5-Пятница");
		System.out.println("6-Суббота");
		System.out.println("7-Воскресенье");
		int day = sc.nextInt();
		if (day<1 || day>7) {
		    System.out.println("Вы ввели неверный пункт!");
		    System.out.println("Попробуйте еще раз!");
		    break;
		}
		flights.getWeekDayFlights(day);
		break;
	    }
	    case 4: {
		System.out.println("Выберите день недели: ");
		System.out.println("1-Понедельник");
		System.out.println("2-Вторник");
		System.out.println("3-Среда");
		System.out.println("4-Четверг");
		System.out.println("5-Пятница");
		System.out.println("6-Суббота");
		System.out.println("7-Воскресенье");
		int day = sc.nextInt();
		if (day<1 || day>7) {
		    System.out.println("Вы ввели неверный пункт!");
		    System.out.println("Попробуйте еще раз!");
		    break;
		}
		System.out.print("Введите время вылета (часы): ");
		int hours = Integer.parseInt(sc.next());
		System.out.print("Введите время вылета (минуты): ");
		int minutes = Integer.parseInt(sc.next());
		depart = LocalTime.of(hours, minutes);
		flights.getWeekDayTimeFlights(day, depart);
		break;
	    }
	    case 5: {
		sc.close();
		System.exit(1);
	    }
	    }

	}
    }
}
