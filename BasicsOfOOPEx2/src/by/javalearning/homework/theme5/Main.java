package by.javalearning.homework.theme5;

import java.util.List;

import by.javalearning.homework.theme5.Payment.Good;

/*
 * ������ 2. ������� ����� Payment � ���������� �������, � ������� �������� 
 * �������� ����� ������������ ������� �� ���������� �������.
*/

public class Main {

    public static void main(String[] args) {
	
	Payment payment = new Payment();
	PaymentLogic payLog = new PaymentLogic(payment);
	
	//������� ������ �������, �������� ��� ������ � ����
	payLog.addNewGood(payment.new Good("������", 2));
	payLog.addNewGood(payment.new Good("����", 3));
	payLog.addNewGood(payment.new Good("���", 15));
	payLog.addNewGood(payment.new Good("�������", 3));
	payLog.addNewGood(payment.new Good("�����", 15));
	payLog.addNewGood(payment.new Good("�����", 2));
	payLog.addNewGood(payment.new Good("������", 2));
	payLog.addNewGood(payment.new Good("������", 3));
	payLog.addNewGood(payment.new Good("�������", 3));
	payLog.addNewGood(payment.new Good("������", 6));
	payLog.addNewGood(payment.new Good("��������", 35));
	payLog.addNewGood(payment.new Good("�������", 15));
	payLog.addNewGood(payment.new Good("�������", 20));
	payLog.addNewGood(payment.new Good("�������", 15));
	payLog.addNewGood(payment.new Good("�������", 12));
	
	//������� ������
	printGoods(payment.getAllGoods());
	
	//�������� ������ � �������
	payLog.addToBasket("������");
	payLog.addToBasket("������");
	payLog.addToBasket("�������");
	payLog.addToBasket("���");
	payLog.addToBasket("����");
	
	int basketPrice = payLog.basketPriceCalc();
		
	//������� ���������� �������
	printGoods(payment.getBasket());
	System.out.println("Basket Price = " + basketPrice + "\n");
	
	//�������� �������
	payLog.clearBasket();
	printGoods(payment.getBasket());
	
    }

    private static void printGoods(List<Good> goods) {
	int j=0;
	for (int i=0;i<goods.size();i++) {
	    System.out.print(goods.get(i).toString());
	    j++;
	}
	if(j==0) System.out.println("������� �� �������");
	System.out.print("\n");

    }

}
