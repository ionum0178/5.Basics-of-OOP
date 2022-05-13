package by.javalearning.homework.theme5;

import by.javalearning.homework.theme5.Payment.Good;

public class PaymentLogic {
    
    private Payment payment; 
    
    public PaymentLogic(Payment payment) {
	this.payment = payment;
    }
    
    public void addNewGood(Good good) {
	payment.getAllGoods().add(good);
    }
    
    public void addToBasket(Good good) {
	payment.getBasket().add(good);
    }
    
    public void addToBasket(String name) {
	for(int i=0; i<payment.getAllGoods().size();i++) {
	    if (payment.getAllGoods().get(i).getName().equalsIgnoreCase(name))
	    payment.getBasket().add(payment.getAllGoods().get(i));
	}
    }
    
    public int basketPriceCalc() {
	int basketPrice = 0;
	for(int i=0; i<payment.getBasket().size();i++) {
	    basketPrice += payment.getBasket().get(i).getPrice();
	}
	return basketPrice;
    }
    
    public void clearBasket() {
	payment.getBasket().clear();
    }
}
