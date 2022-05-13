package by.javalearning.homework.theme4;

import java.util.Objects;

/* 
 * 4. Programming with classes
 * Агрегация и композиция.
 * 2. Создать объект класса Автомобиль, используя классы Колесо, Двигатель. 
 * Методы: ехать, заправляться, менять колесо, вывести на консоль марку автомобиля. 
 */

public class Wheel {

    private String wheel_brand;
    TyreType tyreType;

    public Wheel(String wheel_brand, TyreType tyreType) {
	this.wheel_brand = wheel_brand;
	this.tyreType = tyreType;
    }
    
    public String getWheel_brand() {
        return wheel_brand;
    }

    public void setWheel_brand(String wheel_brand) {
        this.wheel_brand = wheel_brand;
    }

    public TyreType getType() {
        return tyreType;
    }

    public void setType(TyreType tyreType) {
        this.tyreType = tyreType;
    }

    public String toString() {
	String string = "";
	string += wheel_brand + " ";
	if (tyreType == TyreType.WINTER)
	    string += "Winter";
	else
	    string += "Summer";
	return string;
    }

    @Override
    public int hashCode() {
	return Objects.hash(tyreType, wheel_brand);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Wheel other = (Wheel) obj;
	return tyreType == other.tyreType && Objects.equals(wheel_brand, other.wheel_brand);
    }


}
