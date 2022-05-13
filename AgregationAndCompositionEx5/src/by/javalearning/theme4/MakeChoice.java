package by.javalearning.theme4;

/* 
 * 4. Programming with classes
 * Простейшие классы и объекты.
 * 5. Туристические путевки. Сформировать набор предложений клиенту по выбору 
 * туристической путевки различного типа (отдых, экскурсии, лечение, шопинг, 
 * круиз и т. д.) для оптимального выбора. Учитывать возможность выбора 
 * транспорта, питания и числа дней. Реализовать выбор и сортировку путевок. 
*/

import java.util.Scanner;

public class MakeChoice {

    private static VoucherBase trip = new VoucherBase();
    private static Offers tripOffers = new Offers();
    private static OffersLogic tripOfferLogic = new OffersLogic();

    public void startMenu() {
	
	@SuppressWarnings("resource")
	Scanner scanner = new Scanner(System.in);
	while (true) {
	    System.out.println("Выберите пункт меню:\n" + "0. выход\n"
		    + "1. вывести список всех предложений (сортировка по алфавиту)\n"
		    + "2. вывести список всех предложений (сортировка по виду отдыха)\n"
		    + "3. вывести список всех предложений (сортировка по цене)\n" + "4. выбрать путевку\n");
	    int choice = scanner.nextInt();
	    if (choice == 0) {
		System.out.println("Попробуйте еще раз!");
		break;
	    }
	    if (choice < 1 || choice > 4) {
		System.out.println("Выбран неправильный пункт меню, попробуйте еще раз!");
		continue;
	    }
	    switch (choice) {
	    case 1:
		trip.sortByCountry();
		printVouchers();
		break;
	    case 2:
		trip.sortByRestType();
		printVouchers();
		break;
	    case 3:
		trip.sortByPrice();
		printVouchers();
		break;
	    case 4:
		compileOffers();
		break;
	    }
	}
    }

    public void compileOffers() { // подбор путевки
	@SuppressWarnings("resource")
	Scanner scanner = new Scanner(System.in);
	int count = 0;
	while (count == 0) {
	    // страна
	    System.out.print("Подберите путевку:\nВведите страну: (0, если не важно)\n");
	    String country_select = scanner.nextLine();
	    trip.sortByCountry();

	    // формируем после отбора новый массив предложений
	    count = 0;
	    for (int i = 0; i < trip.getVouchers().size(); i++) {
		if (trip.getVouchers().get(i).getCountry().toLowerCase().contains(country_select.toLowerCase()) || country_select.equals("0")) {
		    tripOfferLogic.newWorkOffer(trip.getVouchers().get(i));
		    count++;
		}
	    }
	    printWorkOffers();
	    if (count == 0) {
		System.out.println("Предложений не найдено");
		break;
	    }
	    
	    // вид отдыха
	    System.out.print("Введите вид отдыха: (0, если не важно)\n");
	    String rest_type_select = scanner.nextLine();
	    count = 0;
	    for (int i = 0; i < tripOffers.getWorkoffers().size(); i++) {
		if (tripOffers.getWorkoffers().get(i).getRest_type().toLowerCase().contains(rest_type_select.toLowerCase()) || rest_type_select.equals("0")) {
		    tripOfferLogic.newOffer(tripOffers.getWorkoffers().get(i));
		    count++;
		}
	    }
	    printOffers();
	    if (count == 0) {
		System.out.println("Предложений не найдено");
		break;
	    }
	    // очищаем массив для дальнейшего отбора
	    tripOfferLogic.clearWorkOffers();
	

	    // транспорт
	    System.out.print("Введите транспорт: (0, если не важно)\n");
	    String transfer_select = scanner.nextLine();
	    count = 0;
	    for (int i = 0; i < tripOffers.getOffers().size(); i++) {
		if (tripOffers.getOffers().get(i).getTransfer().toLowerCase().contains(transfer_select.toLowerCase()) || transfer_select.equals("0")) {
		    tripOfferLogic.newWorkOffer(tripOffers.getOffers().get(i));
		    count++;
		}
	    }
	    printWorkOffers();
	    if (count == 0) {
		System.out.println("Предложений не найдено");
		break;
	    }
	    // очищаем массив для дальнейшего отбора
	    tripOfferLogic.clearOffers();

	    // питание
	    System.out.print("Введите питание: (0, если не важно)\n");
	    String food_select = scanner.nextLine();
	    count = 0;
	    for (int i = 0; i < tripOffers.getWorkoffers().size(); i++) {
		if (tripOffers.getWorkoffers().get(i).getFood().toLowerCase().contains(food_select.toLowerCase()) || food_select.equals("0")) {
		    tripOfferLogic.newOffer(tripOffers.getWorkoffers().get(i));
		    count++;
		}
	    }
	    printOffers();
	    if (count == 0) {
		System.out.println("Предложений не найдено");
		break;
	    }
	    // очищаем массив для дальнейшего отбора
	    tripOfferLogic.clearWorkOffers();
	

	    // количество дней
	    System.out.print("Введите количество дней: (0, если не важно)\n");
	    int days_select = Integer.parseInt(scanner.nextLine());
	    count = 0;
	    for (int i = 0; i < tripOffers.getOffers().size(); i++) {
		if (tripOffers.getOffers().get(i).getDays() == days_select || days_select == 0) {
		    tripOfferLogic.newWorkOffer(tripOffers.getOffers().get(i));
		    count++;
		}
	    }
	    printWorkOffers();
	    if (count == 0) {
		System.out.println("Предложений не найдено");
		break;
	    }
	    // очищаем массив для дальнейшего отбора
	    tripOfferLogic.clearOffers();

	    // цена
	    System.out.println("Выберите диапазон цены. (0, если не важно)\nВведите нижний предел:");
	    int low_price_select = Integer.parseInt(scanner.nextLine());
	    System.out.println("Введите верхний предел:");
	    int high_price_select = Integer.parseInt(scanner.nextLine());

	    count = 0;
	    for (int i = 0; i < tripOffers.getWorkoffers().size(); i++) {
		if (tripOffers.getWorkoffers().get(i).getPrice() >= low_price_select
			&& tripOffers.getWorkoffers().get(i).getPrice() <= high_price_select || low_price_select == 0 || high_price_select ==0) {
		    tripOfferLogic.newOffer(tripOffers.getWorkoffers().get(i));
		    count++;
		}
	    }
	    if (count == 0) {
		System.out.println("Предложений не найдено");
		break;
	    }
	    pickUp();
	    break;
	}
    }

    public void pickUp() {
	System.out.println("Подобраны следующие путевки:");
	for (Voucher a : tripOffers.getOffers()) {
	    System.out.println((tripOffers.getOffers().indexOf(a) + 1) +". " + a.toString());
	}
	System.out.print("Какую желаете выбрать?\nВведите номер:");
	Scanner scanner = new Scanner(System.in);
	int pick_up = Integer.parseInt(scanner.nextLine());
	System.out.println("Поздравляю! Вы выбрали следующий вариант:");
	System.out.println(tripOffers.getOffers().get((pick_up - 1)).toString());
	System.out.println("Спасибо, что выбрали нас! До свидания!");
	scanner.close();
	System.exit(1);
    }

    public void printVouchers() {
	for (Voucher a : trip.getVouchers()) {
	    System.out.println(a.toString());
	}
    }
    public void printOffers() {
	for (Voucher a : tripOffers.getOffers()) {
	    System.out.println(a.toString());
	}
    }
    
    public void printWorkOffers() {
   	for (Voucher a : tripOffers.getWorkoffers()) {
   	    System.out.println(a.toString());
   	}
    }
}

