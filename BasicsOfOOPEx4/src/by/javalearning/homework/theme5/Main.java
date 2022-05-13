package by.javalearning.homework.theme5;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/*
 * ������ 4.
������� ���������� ����������, ��������������� ��������� �����������:
� ���������� ������ ���� ��������-, � �� ����������-���������������.
� ������ ����� ������ ����� ���������� ����� �������� � ������������� ������.
� ������������ ������ ����������� ������ �����, ����� ��� ����� �����.
� ��� ����������� ������ ���� ������������ ���������� �� ���������� ���� java code convention.
� ������ ������ ���� �������� ��������� �� �������.
� ���������� ���� ������ ���� �����������.
� ��� �������� ������ ����� ������������ �����.
������ � ��� ���������. ������� ���������, ����������� ������������ �������� � 100 ���������� � ������
�������. ����������� ����������� ��������� ��������, ������ ������ �������� �� ��������� ��������� �
������ �������� �� �������� �����.

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
	    System.out.println("\n� ������ ������ �������� ���������");
	    System.out.println("0-�� �����!!!");
	    System.out.println("1-�������� ��������");
	    System.out.println("2-�������� �������� (���������� �� ����)");
	    System.out.println("3-�������� �������� (���������� �� ��������)");
	    System.out.println("4-����� ������� ���������");
	    System.out.println("5-��������� �� �������� �����");

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
		System.out.println("����� ������� ���������: " + treasure.toString());
		break;
	    }

	    case 5: {
		System.out.println("������� �����:");
		int cash = input();
		sorted = treasureLog.getSelectedTreasures(treasureList.getTreasureList(), cash);
		if(sorted.isEmpty()) {
		    System.out.println("�� ��� ����� ������ �� �������, �������� � ������ ������");
		} else {
		System.out.println("�������� ��������� ���������:");
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
