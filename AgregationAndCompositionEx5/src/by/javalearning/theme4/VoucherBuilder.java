package by.javalearning.theme4;

/* 
 * 4. Programming with classes
 * Простейшие классы и объекты.
 * 5. Туристические путевки. Сформировать набор предложений клиенту по выбору 
 * туристической путевки различного типа (отдых, экскурсии, лечение, шопинг, 
 * круиз и т. д.) для оптимального выбора. Учитывать возможность выбора 
 * транспорта, питания и числа дней. Реализовать выбор и сортировку путевок. 
*/

public class VoucherBuilder {
    private String country;
    private String town;
    private String rest_type;
    private String transfer;
    private String accomodation;
    private String food;
    private int days;
    private int price;
    
    public VoucherBuilder country(String country) {
	this.country = country;
	return this;
    }
    public VoucherBuilder town(String town) {
	this.town = town;
	return this;
    }
    public VoucherBuilder rest_type(String rest_type) {
	this.rest_type = rest_type;
	return this;
    }
    public VoucherBuilder transfer(String transfer) {
	this.transfer = transfer;
	return this;
    }
    public VoucherBuilder accomodation(String accomodation) {
	this.accomodation = accomodation;
	return this;
    }
    public VoucherBuilder food(String food) {
	this.food = food;
	return this;
    }
    public VoucherBuilder days(int days) {
	this.days = days;
	return this;
    }
    public VoucherBuilder price(int price) {
	this.price = price;
	return this;
    }
    public Voucher build() {
	return new Voucher(this);
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
    
}
