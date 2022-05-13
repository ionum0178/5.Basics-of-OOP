package by.treasure.view;

import java.util.Scanner;

import by.treasure.controller.Controller;
import by.treasure.controller.ControllerException;
import by.treasure.controller.impl.ControllerImpl;

public class View {
    
    public void startMenu() {

	Controller controller = new ControllerImpl();
	
	fillTreasureList(controller);
	
	String request="";
	String response="";

	int i = -1;
	while (i != 0) {
	    System.out.println("\n� ������ ������ �������� ���������");
	    System.out.println("0-�� �����!!!");
	    System.out.println("1-�������� ��������");
	    System.out.println("2-�������� �������� (���������� �� ����)");
	    System.out.println("3-�������� �������� (���������� �� ��������)");
	    System.out.println("4-����� ������� ���������");
	    System.out.println("5-��������� �� �������� �����");

	    request = Integer.toString(inputInt());
	    try {
		response = controller.doAction(request);
	    } catch (ControllerException e) {
		e.printStackTrace();
	    }
	    if (response == null)
		break;
	    System.out.println(response);
	}
    }

    private void fillTreasureList(Controller controller) {
	boolean indicator = false;
	try {
	    indicator = controller.fillTreasureList();
	} catch (ControllerException e) {
	    e.printStackTrace();
	}
	if (!indicator) {
	    System.out.println("��������� �� �������!");
	    System.exit(1);
	}
    }
    
    public static int inputInt() {
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

    public static String inputStr() {
 	@SuppressWarnings("resource")
 	Scanner sc = new Scanner(System.in);
 	String i;
 	while (true) {
 	    if (sc.hasNext()) {
 		i = sc.nextLine();
 		break;
 	    } else
 		sc.nextLine();
 	}
 	return i;
     }
}
