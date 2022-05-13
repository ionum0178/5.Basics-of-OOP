package by.javalearning.homework.theme4;

import java.util.Arrays;
import java.util.Objects;

/* 
 * 4. Programming with classes
 * Агрегация и композиция.
 * 2. Создать объект класса Автомобиль, используя классы Колесо, Двигатель. 
 * Методы: ехать, заправляться, менять колесо, вывести на консоль марку автомобиля. 
 */

public class Car {
    
    private Wheel wheels[];
    private Engine engine;
    private String brand;
    private double consumption;
    private double fuel_level;
    private double fuel_capacity;

    public Car(String brand, double consumption, Engine engine, Wheel wheels[], double fuel_level, double fuel_capacity) {
	this.brand = brand;
	this.consumption = consumption;
	this.engine = engine;
	this.wheels = wheels;
	this.fuel_level = fuel_level;
	this.fuel_capacity = fuel_capacity;
    }
    
    public Wheel[] getWheels() {
        return wheels;
    }

    public Engine getEngine() {
        return engine;
    }

    public String getBrand() {
        return brand;
    }

    public double getConsumption() {
        return consumption;
    }

    public double getFuel_level() {
        return fuel_level;
    }

    public void setWheels(Wheel[] wheels) {
        this.wheels = wheels;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public void setFuel_level(double fuel_level) {
        this.fuel_level = fuel_level;
    }

    public double getFuel_capacity() {
        return fuel_capacity;
    }

    public void setFuel_capacity(double fuel_capacity) {
        this.fuel_capacity = fuel_capacity;
    }

    public String toString() {
	String string = "";
	string += brand + " " + engine.toString() + "; " + consumption + "L/100km {" + fuel_level + "L}; [";
	for (int i = 0; i < 4; ++i) {
	    string += wheels[i].toString() + " ";
	}
	return string + "]";
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + Arrays.hashCode(wheels);
	result = prime * result + Objects.hash(brand, consumption, engine, fuel_capacity, fuel_level);
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Car other = (Car) obj;
	return Objects.equals(brand, other.brand)
		&& Double.doubleToLongBits(consumption) == Double.doubleToLongBits(other.consumption)
		&& Objects.equals(engine, other.engine)
		&& Double.doubleToLongBits(fuel_capacity) == Double.doubleToLongBits(other.fuel_capacity)
		&& Double.doubleToLongBits(fuel_level) == Double.doubleToLongBits(other.fuel_level)
		&& Arrays.equals(wheels, other.wheels);
    }

    
}
