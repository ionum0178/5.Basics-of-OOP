package by.javalearning.homework.theme5;

import java.util.List;

import by.javalearning.homework.theme5.Payment.Good;

/*
 * Задача 2. Создать класс Payment с внутренним классом, с помощью объектов 
 * которого можно сформировать покупку из нескольких товаров.
*/

public class Main {

    public static void main(String[] args) {
	
	Payment payment = new Payment();
	PaymentLogic payLog = new PaymentLogic(payment);
	
	//создать список товаров, добавить все товары в базу
	payLog.addNewGood(payment.new Good("Молоко", 2));
	payLog.addNewGood(payment.new Good("Яйца", 3));
	payLog.addNewGood(payment.new Good("Сыр", 15));
	payLog.addNewGood(payment.new Good("Сметана", 3));
	payLog.addNewGood(payment.new Good("Масло", 15));
	payLog.addNewGood(payment.new Good("Кефир", 2));
	payLog.addNewGood(payment.new Good("Творог", 2));
	payLog.addNewGood(payment.new Good("Йогурт", 3));
	payLog.addNewGood(payment.new Good("Ряженка", 3));
	payLog.addNewGood(payment.new Good("Курица", 6));
	payLog.addNewGood(payment.new Good("Говядина", 35));
	payLog.addNewGood(payment.new Good("Свинина", 15));
	payLog.addNewGood(payment.new Good("Индейка", 20));
	payLog.addNewGood(payment.new Good("Колбаса", 15));
	payLog.addNewGood(payment.new Good("Сосиски", 12));
	
	//вывести список
	printGoods(payment.getAllGoods());
	
	//добавить товары в корзину
	payLog.addToBasket("молоко");
	payLog.addToBasket("творог");
	payLog.addToBasket("сметана");
	payLog.addToBasket("сыр");
	payLog.addToBasket("ЯЙЦА");
	
	int basketPrice = payLog.basketPriceCalc();
		
	//вывести содержимое корзины
	printGoods(payment.getBasket());
	System.out.println("Basket Price = " + basketPrice + "\n");
	
	//очистить корзину
	payLog.clearBasket();
	printGoods(payment.getBasket());
	
    }

    private static void printGoods(List<Good> goods) {
	int j=0;
	for (int i=0;i<goods.size();i++) {
	    System.out.print(goods.get(i).toString());
	    j++;
	}
	if(j==0) System.out.println("Товаров не найдено");
	System.out.print("\n");

    }

}
