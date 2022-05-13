package by.javalearning.homework.theme4;

import java.util.Scanner;
import java.util.SplittableRandom;

/* 
 * 4. Programming with classes
 * Простейшие классы и объекты.
 * Задача 5. Опишите класс, реализующий десятичный счетчик, который может 
 * увеличивать или уменьшать свое значение на единицу в заданном диапазоне. 
 * Предусмотрите инициализацию счетчика значениями по умолчанию и произвольными
 * значениями. Счетчик имеет методы увеличения и уменьшения состояния, и 
 * метод позволяющий получить его текущее состояние. Написать код, 
 * демонстрирующий все возможности класса.
 */

public class DecimalCounterLogic {
    
    int upLimit;
    int downLimit;
    int counterValue;
    DecimalCounter counter;

    public DecimalCounter createCounter() {
	return new DecimalCounter();
    }
    
    public DecimalCounter createCounter(int downLimit, int upLimit, int cValue) {
	return new DecimalCounter(downLimit, upLimit, cValue);
    }
    public void initCounter() {
	Scanner sc1 = new Scanner(System.in);
	int i = 0;
	System.out.println("Установите параметры десятичного счетчика:");
	System.out.println("1-По умолчанию");
	System.out.println("2-Случайные значения");
	System.out.println("3-Завершить программу");
	if (sc1.hasNextInt()) {
	    i = sc1.nextInt();
	    sc1.nextLine();
	} else {
	    System.out.println("Попробуйте еще раз!");
	    System.exit(1);
	}
	
	switch (i) {
	case 1: {
	    System.out.println("Значения по умолчанию:");
	    System.out.println("Нижний предел: 0");
	    System.out.println("Верхний предел: 100");
	    System.out.println("Начальное значение счетчика: 0");
	    
	    counter=createCounter();
	    
	    break;
	}
	case 2: {
	    downLimit = new SplittableRandom().nextInt(0, 99);
	    upLimit = new SplittableRandom().nextInt(100, 10000);
	    counterValue = new SplittableRandom().nextInt(downLimit, upLimit);

	    System.out.println("Выбраны следующие случайные значения:");
	    System.out.println("Нижний предел: " + downLimit);
	    System.out.println("Верхний предел: " + upLimit);
	    System.out.println("Начальное значение счетчика: " + counterValue);
	    
	    counter = createCounter(downLimit, upLimit, counterValue);
	    
	    break;
	}
	case 3: {
	    sc1.close();
	    System.exit(1);
	    break;
	}
	default: {
	    getCounter();
	}
	}
    }

    public void counterMenu() {
	Scanner sc = new Scanner(System.in);
	int j = 0;
	while (j != 5) {
	    System.out.println("1-Вывести параметры счетчика на экран");
	    System.out.println("2-Увеличить значение на единицу и вывести на экран");
	    System.out.println("3-Уменьшить значение на единицу и вывести на экран");
	    System.out.println("4-Установить параметры заново");
	    System.out.println("5-Завершить программу");
	    if (sc.hasNextInt()) {
		j = sc.nextInt();
	    } else {
		System.out.println("Попробуйте еще раз!");
		System.exit(1);
	    }
	    switch (j) {    
	    case 1: {
		getCounter();
		break;
	    }
	    case 2: {
		setCounter(counter.getDownLimit(), counter.getUpLimit(), (counter.getCounterValue() + 1));
		getCounter();
		break;
	    }
	    case 3: {
		setCounter(counter.getDownLimit(), counter.getUpLimit(), (counter.getCounterValue() - 1));
		getCounter();
		break;
	    }
	    case 4:{
		initCounter();
		break;
	    }
	    case 5: {
		sc.close();
		System.exit(1);
		break;
	    }
	    }
	}
    }
    
    public void setCounter(int i, int j, int k) {
	counter.setDownLimit(i);
	counter.setUpLimit(j);
	counter.setCounterValue(k);
	if (counter.getCounterValue()<counter.getDownLimit()) {
	    counter.setCounterValue(counter.getUpLimit()-1);
	}
	if (counter.getCounterValue()>(counter.getUpLimit()-1)) {
	    counter.setCounterValue(counter.getDownLimit());
	}
    }
    public void getCounter() {
 	System.out.println("Сейчас счетчик имеет следующие параметры:");
 	System.out.println("Нижний предел: " + counter.getDownLimit());
 	System.out.println("Верхний предел: " + counter.getUpLimit());
 	System.out.println("Значение счетчика: " + counter.getCounterValue());
     }
}
