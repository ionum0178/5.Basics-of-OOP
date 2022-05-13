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
	    System.out.println("\nПрограмма по созданию букета:");
	    System.out.println("0-На выход!!!");
	    System.out.println("1-Просмотр ассортимента");
	    System.out.println("2-Создание своего букета");

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
	
	System.out.println("\nКакие цветы вы хотели бы добавить?");
	System.out.println("0-Достаточно цветов");
	System.out.println("1-Роза, цена 5 руб.");
	System.out.println("2-Гвоздика, цена 3 руб.");
	System.out.println("3-Хризантема, цена 4 руб.");
	System.out.println("4-Гербера, цена 4 руб.");
	System.out.println("5-Тюльпан, цена 3 руб.");
	
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

	System.out.println("\nКакую упаковку вы хотели бы?");
	System.out.println("0-Достаточно");
	System.out.println("1-Простая бумага, цена 0 руб.");
	System.out.println("2-Цветная бумага, цена 2 руб.");
	System.out.println("3-Прозрачная пленка, цена 1 руб.");
	System.out.println("4-Цветная пленка, цена 2 руб.");
	System.out.println("5-Сетка, цена 3 руб.");
	
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
	    System.out.println("Цветы не завезли, санкции!");
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
