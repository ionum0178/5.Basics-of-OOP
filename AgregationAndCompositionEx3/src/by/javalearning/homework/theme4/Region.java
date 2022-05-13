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

public class Region {
    
    private String name;
    private List<District> districts=new ArrayList<>();
    private Town town;
    
    public Region(String name, Town town, List<District> districts) {
	this.name = name;
	this.town = town;
	this.districts=districts;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<District> getDistricts() {
	return districts;
    }

    public void setDistricts(ArrayList<District> districts) {
	this.districts = districts;
    }
    
    @Override
    public int hashCode() {
	return Objects.hash(districts, name, town);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Region other = (Region) obj;
	return Objects.equals(districts, other.districts) && Objects.equals(name, other.name)
		&& Objects.equals(town, other.town);
    }

    public String toString() {
	String string = "";
	string += name + " область, \tобластной центр - город " + getTown();
	return string;
    }
    
}
