package by.javalearning.homework.theme4;

public class WheelLogic {
    
    Car car;

    public WheelLogic (Car car) {
	this.car = car;
    }

    public void changeWheel(int number, String wheel_brand, int value) {
	
	Wheel [] wheels = car.getWheels();
	
	    if (value == 1) {
		wheels[number].setType(TyreType.WINTER);
	    }
	    if (value == 2) {
		wheels[number].setType(TyreType.SUMMER);
	    }
	  
	wheels[number].setWheel_brand(wheel_brand);
	car.setWheels(wheels);
	
    }

    
}
