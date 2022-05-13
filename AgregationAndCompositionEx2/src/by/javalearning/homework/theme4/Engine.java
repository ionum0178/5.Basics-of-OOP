package by.javalearning.homework.theme4;

import java.util.Objects;

/* 
 * 4. Programming with classes
 * Агрегация и композиция.
 * 2. Создать объект класса Автомобиль, используя классы Колесо, Двигатель. 
 * Методы: ехать, заправляться, менять колесо, вывести на консоль марку автомобиля. 
 */

public class Engine {
    
    private int number;
    private double power;

    public Engine(int number, double power) {
	this.number = number;
	this.power = power;
    }

    public int getNumber() {
	return number;
    }

    public double getPower() {
	return power;
    }

    public void setNumber(int number) {
	this.number = number;
    }

    public void setPower(double power) {
	this.power = power;
    }
    
    public String toString() {
	String string = "engine: " + number + ", power: " + power;
	return string;
    }

    @Override
    public int hashCode() {
	return Objects.hash(number, power);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Engine other = (Engine) obj;
	return number == other.number && Double.doubleToLongBits(power) == Double.doubleToLongBits(other.power);
    }
    
    
 
}
