package by.javalearning.theme4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/* 
 * 4. Programming with classes
 * Простейшие классы и объекты.
 * 5. Туристические путевки. Сформировать набор предложений клиенту по выбору 
 * туристической путевки различного типа (отдых, экскурсии, лечение, шопинг, 
 * круиз и т. д.) для оптимального выбора. Учитывать возможность выбора 
 * транспорта, питания и числа дней. Реализовать выбор и сортировку путевок. 
*/

public class VoucherBase {
    private String country;
    private String town;
    private String rest_type;
    private String transfer;
    private String accomodation;
    private String food;
    private int days;
    private int price;
    private File file;
    private Voucher voucher;
    private static List<Voucher> vouchers = new ArrayList<>();

    public List<Voucher> getVouchers() {
	return vouchers;
    }

    public void setVouchers(ArrayList<Voucher> vouchers) {
	VoucherBase.vouchers = vouchers;
    }

    @SuppressWarnings("resource")
    public void initVoucherBase() throws FileNotFoundException {
	file = new File("./src/resource/tourism.txt");
	Scanner sc = null;
	try {
	    sc = new Scanner(file).useDelimiter(";\\s+");
	    while (sc.hasNextLine()) {
		country = sc.next();
		town = sc.next();
		rest_type = sc.next();
		transfer = sc.next();
		accomodation = sc.next();
		food = sc.next();
		days = Integer.parseInt(sc.next());
		price = Integer.parseInt(sc.next());
		voucher = new VoucherBuilder().country(country).town(town).rest_type(rest_type).transfer(transfer)
			.accomodation(accomodation).food(food).days(days).price(price).build();
		vouchers.add(voucher);
	    }
	} catch (FileNotFoundException e) {
	    throw e;
	}
    }
    
    public void sortByPrice() {
	Collections.sort(vouchers, new Comparator<Voucher>() {
	    public int compare(Voucher o1, Voucher o2) {
		return o1.getPrice() - o2.getPrice();
	    }
	});
    }

    public void sortByDays() {
	Collections.sort(vouchers, new Comparator<Voucher>() {
	    public int compare(Voucher o1, Voucher o2) {
		return o1.getDays() - o2.getDays();
	    }
	});
    }

    public void sortByFood() {
	Collections.sort(vouchers, new Comparator<Voucher>() {
	    public int compare(Voucher o1, Voucher o2) {
		return o1.getFood().compareTo(o2.getFood());
	    }
	});
    }

    public void sortByAccomodation() {
	Collections.sort(vouchers, new Comparator<Voucher>() {
	    public int compare(Voucher o1, Voucher o2) {
		return o1.getAccomodation().compareTo(o2.getAccomodation());
	    }
	});
    }

    public void sortByRestType() {
	Collections.sort(vouchers, new Comparator<Voucher>() {
	    public int compare(Voucher o1, Voucher o2) {
		return o1.getRest_type().compareTo(o2.getRest_type());
	    }
	});
    }

    public void sortByCountry() {
	Collections.sort(vouchers, new Comparator<Voucher>() {
	    public int compare(Voucher o1, Voucher o2) {
		return o1.getCountry().compareTo(o2.getCountry());
	    }
	});
    }
}
