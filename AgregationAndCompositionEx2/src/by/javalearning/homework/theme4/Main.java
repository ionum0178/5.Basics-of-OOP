package by.javalearning.homework.theme4;

import java.util.Scanner;

/* 
 * 4. Programming with classes
 * Агрегация и композиция.
 * 2. Создать объект класса Автомобиль, используя классы Колесо, Двигатель. 
 * Методы: ехать, заправляться, менять колесо, вывести на консоль марку автомобиля. 
 */

public class Main {

    public static String brand; // Марка машины
    public static double consumption; // расход топлива
    public static double fuel_level; // уровень топлива
    public static double fuel_capacity; // объем бензобака
    
    public static int number; // номер двигателя
    public static double power; // мощность двигателя

    public static String wheel_brand; // марка колес
    public static TyreType tyreType; // тип резины

    public static Wheel[] wheels;

    public static Car car;
    public static CarLogic cl;
    public static WheelLogic wl;

    public static void main(String[] args) {

	brand = "Ford";
	consumption = 7; 
	fuel_level = 100; 
	fuel_capacity = 100; 
	number = 12345; 
	power = 150; 
	wheel_brand = "Dunlop"; 
	tyreType = TyreType.WINTER; 
	wheels = new Wheel[4];
	for (int i = 0; i < 4; i++) {
	    wheels[i] = new Wheel(wheel_brand, tyreType);
	}
	car = new Car(brand, consumption, new Engine(number, power), wheels, fuel_level, fuel_capacity);
	cl = new CarLogic();
	wl = new WheelLogic(car);

	startMenu(car, cl, wl);
    }

    private static void startMenu(Car car, CarLogic cl, WheelLogic wl) {

	Scanner scanner = new Scanner(System.in);

	while (true) {
	    System.out.println("Выберите пункт меню:\n" + "0. выход\n" + "1. ехать\n" + "2. заправляться\n"
		    + "3. менять колесо\n" + "4. вывести информацию об авто\n");
	    int choice = scanner.nextInt();
	    if (choice == 0)
		break;
	    if (choice < 1 || choice > 4) {
		System.out.println("выбран неправильный пункт меню, повторите ввод.");
		continue;
	    }
	    
	    switch (choice) {
	    
	    case 1:
		cl.move(car);
		if (car.getFuel_level() <= 0) {
		    System.out.println("Нет бензина, машина не может двигаться");
		} else {
		    System.out.println("Машина проехала " + cl.getDistance() * 100 + "км.");
		    car.setFuel_level(0);
		}
		break;
		
	    case 2:
		System.out.println("Введите количество топлива:");
		double fuel = scanner.nextDouble();
		cl.addFuel(car, fuel);
		System.out.println("Теперь в бензобаке " + car.getFuel_level() + " литров топлива");
		break;
		
	    case 3:
		System.out.println("Введите номер колеса [1-4]:");
		int number;
		while (true) {
		    if (scanner.hasNextInt()) {
			number = scanner.nextInt();
			if (number > 0 && number <= 4)
			    break;
		    } else {
			scanner.next();
		    }
		    System.out.println("Неправильный номер, повторите ввод");
		}
		number -= 1;

		int value = 0;
		while (true) {
		    System.out.print("Введите тип резины:\n(1) - зимние, (2) - летние: ");
		    if (scanner.hasNextInt())
			value = scanner.nextInt();
		    if (value == 1 && value == 2) {

			System.out.println("Введено неправильное значение, повторите ввод.");
			scanner.next();
		    } else
			break;
		}
		System.out.print("Введите марку колес: ");
		String wheel_brand = scanner.next();
		wl.changeWheel(number, wheel_brand, value);
		System.out.println(car.toString());
		break;
		
	    case 4:
		System.out.println(car.toString());
		break;
	    }
	}
	scanner.close();
    }

}
