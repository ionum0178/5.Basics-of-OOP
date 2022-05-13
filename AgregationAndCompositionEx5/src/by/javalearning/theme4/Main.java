package by.javalearning.theme4;

import java.io.FileNotFoundException;

/* 
 * 4. Programming with classes
 * Простейшие классы и объекты.
 * 5. Туристические путевки. Сформировать набор предложений клиенту по выбору 
 * туристической путевки различного типа (отдых, экскурсии, лечение, шопинг, 
 * круиз и т. д.) для оптимального выбора. Учитывать возможность выбора 
 * транспорта, питания и числа дней. Реализовать выбор и сортировку путевок. 
*/

public class Main {
    
    public static MakeChoice makeChoice;
    private static VoucherBase trip;
    
    public static void main(String[] args) {
	
	trip = new VoucherBase();
	makeChoice = new MakeChoice();
	
	try {
	    trip.initVoucherBase();
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	    System.exit(1);
	}
	
	makeChoice.startMenu();
    }

}