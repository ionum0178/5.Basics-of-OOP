package by.javalearning.homework.theme4;


/* 
 * 4. Programming with classes
 * Агрегация и композиция.
 * 2. Создать объект класса Автомобиль, используя классы Колесо, Двигатель. 
 * Методы: ехать, заправляться, менять колесо, вывести на консоль марку автомобиля. 
 */

public class CarLogic {

    private double distance;
    
    public void move(Car car) {
	setDistance(0);
	if (car.getFuel_level() > 0) distance = car.getFuel_level() / car.getConsumption();
    }
    
    public void addFuel(Car car, double value) {
	if ((car.getFuel_level() + value) >= car.getFuel_capacity())
	    car.setFuel_level(car.getFuel_capacity());
	else
	    car.setFuel_level(car.getFuel_level() + value);
    }
    
    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
    
}


