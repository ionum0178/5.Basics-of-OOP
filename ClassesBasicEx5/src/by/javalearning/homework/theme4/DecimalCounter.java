package by.javalearning.homework.theme4;

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

public class DecimalCounter {
    private int upLimit;
    private int downLimit;
    private int counterValue;

    public DecimalCounter() {
	this.upLimit = 100;
	this.downLimit = 0;
	this.counterValue = 0;
    }
    
    public DecimalCounter(int upLimit, int downLimit, int counterValue) {
	this.upLimit = upLimit;
	this.downLimit = downLimit;
	this.counterValue = counterValue;
    }

    public  int getUpLimit() {
	return upLimit;
    }

    public  void setUpLimit(int upLimit) {
	this.upLimit = upLimit;
    }

    public  int getDownLimit() {
	return downLimit;
    }

    public  void setDownLimit(int downLimit) {
	this.downLimit = downLimit;
    }

    public  int getCounterValue() {
	return counterValue;
    }

    public  void setCounterValue(int counterValue) {
	this.counterValue = counterValue;
    }
}

