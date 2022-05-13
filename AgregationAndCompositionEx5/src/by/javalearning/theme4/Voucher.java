package by.javalearning.theme4;

import java.util.Objects;

/* 
 * 4. Programming with classes
 * Простейшие классы и объекты.
 * 5. Туристические путевки. Сформировать набор предложений клиенту по выбору 
 * туристической путевки различного типа (отдых, экскурсии, лечение, шопинг, 
 * круиз и т. д.) для оптимального выбора. Учитывать возможность выбора 
 * транспорта, питания и числа дней. Реализовать выбор и сортировку путевок. 
*/

public class Voucher {
    private final String country;
    private final String town;
    private final String rest_type;
    private final String transfer;
    private final String accomodation;
    private final String food;
    private final int days;
    private final int price;
    
    public Voucher(VoucherBuilder voucherBuilder) {
	this.country = voucherBuilder.getCountry();
	this.town = voucherBuilder.getTown();
	this.rest_type = voucherBuilder.getRest_type();
	this.transfer = voucherBuilder.getTransfer();
	this.accomodation = voucherBuilder.getAccomodation();
	this.food = voucherBuilder.getFood();
	this.days = voucherBuilder.getDays();
	this.price = voucherBuilder.getPrice();
    }
    public String getCountry() {
        return country;
    }
    public String getTown() {
        return town;
    }
    public String getRest_type() {
        return rest_type;
    }
    public String getTransfer() {
        return transfer;
    }
    public String getAccomodation() {
        return accomodation;
    }
    public String getFood() {
        return food;
    }
    public int getDays() {
        return days;
    }
    public int getPrice() {
        return price;
    }
    
    @Override
    public int hashCode() {
	return Objects.hash(accomodation, country, days, food, price, rest_type, town, transfer);
    }
    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Voucher other = (Voucher) obj;
	return Objects.equals(accomodation, other.accomodation) && Objects.equals(country, other.country)
		&& days == other.days && Objects.equals(food, other.food) && price == other.price
		&& Objects.equals(rest_type, other.rest_type) && Objects.equals(town, other.town)
		&& Objects.equals(transfer, other.transfer);
    }
    public String toString() {
	return String.format("%-12s %-18s %-26s %-16s %-24s %-21s %4d %s %6d%s", country, town, rest_type, transfer, accomodation, food, days, "дней", price, "$");
    }
}
