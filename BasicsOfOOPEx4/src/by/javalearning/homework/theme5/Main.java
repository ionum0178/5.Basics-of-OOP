package by.javalearning.homework.theme5;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/*
 * Задача 4.
Создать консольное приложение, удовлетворяющее следующим требованиям:
• Приложение должно быть объектно-, а не процедурно-ориентированным.
• Каждый класс должен иметь отражающее смысл название и информативный состав.
• Наследование должно применяться только тогда, когда это имеет смысл.
• При кодировании должны быть использованы соглашения об оформлении кода java code convention.
• Классы должны быть грамотно разложены по пакетам.
• Консольное меню должно быть минимальным.
• Для хранения данных можно использовать файлы.
Дракон и его сокровища. Создать программу, позволяющую обрабатывать сведения о 100 сокровищах в пещере
дракона. Реализовать возможность просмотра сокровищ, выбора самого дорогого по стоимости сокровища и
выбора сокровищ на заданную сумму.

 */
public class Main {

    private TreasureList treasureList;
    private List<Treasure> sorted;
    private Treasure treasure;

    public static void main(String[] args) {

	Main main = new Main();
	TreasureLogic treasureLog = new TreasureLogic();

	try {
	    main.treasureList = new TreasureList(treasureLog.fillTreasureList());
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	}

	main.startMenu(treasureLog);

    }

    public void startMenu(TreasureLogic treasureLog) {

	Scanner sc = new Scanner(System.in);

	int i = -1;
	while (i != 0) {
	    System.out.println("\nВ пещере дракон охраняет сокровища");
	    System.out.println("0-На выход!!!");
	    System.out.println("1-Просмотр сокровищ");
	    System.out.println("2-Просмотр сокровищ (сортировка по цене)");
	    System.out.println("3-Просмотр сокровищ (сортировка по алфавиту)");
	    System.out.println("4-Самое дорогое сокровище");
	    System.out.println("5-Сокровища на заданную сумму");

	    i = input();

	    switch (i) {

	    case 1: {
		System.out.println(treasureList.toString());
		break;
	    }

	    case 2: {
		sorted = treasureLog.sortByPrice(treasureList.getTreasureList());
		for (Treasure t: sorted) {
		    System.out.print(t.toString());
		}
		System.out.println("");
		break;
	    }

	    case 3: {
		sorted = treasureLog.sortByTitle(treasureList.getTreasureList());
		for (Treasure t: sorted) {
		    System.out.print(t.toString());
		}
		System.out.println("");
		break;
	    }

	    case 4: {
		treasure = treasureLog.getMostPreciousTreasure(treasureList.getTreasureList());
		System.out.println("Самое дорогое сокровище: " + treasure.toString());
		break;
	    }

	    case 5: {
		System.out.println("Введите сумму:");
		int cash = input();
		sorted = treasureLog.getSelectedTreasures(treasureList.getTreasureList(), cash);
		if(sorted.isEmpty()) {
		    System.out.println("На эту сумму ничего не найдено, наверное в другой пещере");
		} else {
		System.out.println("Подходят следующие сокровища:");
		for (Treasure t: sorted) {
		    System.out.print(t.toString());
		}
		System.out.println("");
		}
		break;
	    }

	    case 0: {
		sc.close();
		System.exit(1);
		break;
	    }

	    }
	}
    }

    private int input() {
	@SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
	int i;
	while (true) {
	    if (sc.hasNextInt()) {
		i = sc.nextInt();
		break;
	    } else
		sc.nextLine();
	}
	return i;
    }
}
