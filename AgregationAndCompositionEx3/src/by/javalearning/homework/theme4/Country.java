package by.javalearning.homework.theme4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
 * 4. Programming with classes
 * Агрегация и композиция.
 * 3. Создать объект класса Государство, используя классы Область, Район, Город.
 * Методы: вывести на консоль столицу, количество областей, площадь, областные центры.
 */

public class Country {
    
    private String country_name;
    private List<Region> regions=new ArrayList<>();
    private double area;
    private Town capital;
    
    public Country(String country_name, double area, Town capital, List<Region> regions) {
	this.area = area;
	this.capital = capital;
	this.country_name = country_name;
	this.regions = regions;
    }
    
    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Town getCapital() {
        return capital;
    }

    public void setCapital(Town capital) {
        this.capital = capital;
    }

    public String getCountry_name() {
	return country_name;
    }

    public void setCountry_name(String country_name) {
	this.country_name = country_name;
    }

    public List<Region> getRegions() {
	return regions;
    }

    public void setRegions(ArrayList<Region> regions) {
	this.regions = regions;
    }

    @Override
    public int hashCode() {
	return Objects.hash(area, capital, country_name, regions);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Country other = (Country) obj;
	return Double.doubleToLongBits(area) == Double.doubleToLongBits(other.area)
		&& Objects.equals(capital, other.capital) && Objects.equals(country_name, other.country_name)
		&& Objects.equals(regions, other.regions);
    }

    public String toString() {
	String string = "";
	string += "Страна: " + getCountry_name() + "\n"
	+ "Столица: город " + getCapital() + "\n"
	+ "Площадь страны: " + getArea() + " кв.км\n"
	+ "Количество областей: " + getRegions().size() + "\n";
	for (int i = 0; i < getRegions().size(); i++) {
	    string += getRegions().get(i).toString() + "\n";
	    string += "Районы: \n";
	    for (int j = 0; j < getRegions().get(i).getDistricts().size(); j++) {
		string += getRegions().get(i).getDistricts().get(j) + "\n";
	    }
	}
	return string;
    }
}
