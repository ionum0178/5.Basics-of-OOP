package by.flowers.view;

import java.util.Scanner;

import by.flowers.controller.Controller;
import by.flowers.controller.ControllerException;
import by.flowers.controller.impl.ControllerImpl;

public class View {

    private Controller controller = new ControllerImpl();

    public void startMenu() {

	fillStock(controller);

	String request = "";
	String response = "";

	int i = -1;
	while (i != 0) {
	    System.out.println("\n��������� �� �������� ������:");
	    System.out.println("0-�� �����!!!");
	    System.out.println("1-�������� ������������");
	    System.out.println("2-�������� ������ ������");

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


    
    
    public String addFlower() {
	int i = -1;
	String responce = "";
	
	System.out.println("\n����� ����� �� ������ �� ��������?");
	System.out.println("0-���������� ������");
	System.out.println("1-����, ���� 5 ���.");
	System.out.println("2-��������, ���� 3 ���.");
	System.out.println("3-����������, ���� 4 ���.");
	System.out.println("4-�������, ���� 4 ���.");
	System.out.println("5-�������, ���� 3 ���.");
	
	i = inputInt();

	if (i == 0)
	    responce = "enough";
	if (i == 1)
	    responce = "rose";
	if (i == 2)
	    responce = "carnation";
	if (i == 3)
	    responce = "chrysanthema";
	if (i == 4)
	    responce = "gerbera";
	if (i == 5)
	    responce = "tulip";
	
	return responce;
    }

    public String addWrapper() {
	int i = -1;
	String response = "";

	System.out.println("\n����� �������� �� ������ ��?");
	System.out.println("0-����������");
	System.out.println("1-������� ������, ���� 0 ���.");
	System.out.println("2-������� ������, ���� 2 ���.");
	System.out.println("3-���������� ������, ���� 1 ���.");
	System.out.println("4-������� ������, ���� 2 ���.");
	System.out.println("5-�����, ���� 3 ���.");
	
	i = inputInt();

	if (i == 0)
	    response = "enough";
	if (i == 1)
	    response = "plain paper";
	if (i == 2)
	    response = "colored paper";
	if (i == 3)
	    response = "transparent film";
	if (i == 4)
	    response = "colored film";
	if (i == 5)
	    response = "net";
	
	return response;
    }

    private void fillStock(Controller controller) {
	boolean indicator = false;
	try {
	    indicator = controller.fillStock();
	} catch (ControllerException e) {
	    e.printStackTrace();
	}
	if (!indicator) {
	    System.out.println("����� �� �������, �������!");
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
	String str;
	while (true) {
	    if (sc.hasNext()) {
		str = sc.nextLine();
		break;
	    } else
		sc.nextLine();
	}
	return str;
    }

}
