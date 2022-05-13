package by.flowers.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Bouquet {

    List<Flower> flowers = new ArrayList<>();
    List<Wrapper> wrappers = new ArrayList<>();

    public Bouquet() {
    };

    public Bouquet(List<Flower> flowers, List<Wrapper> wrappers) {
	this.flowers = flowers;
	this.wrappers = wrappers;
    }

    public List<Flower> getFlowers() {
	return flowers;
    }

    public List<Wrapper> getWrappers() {
	return wrappers;
    }

    public void setFlowers(List<Flower> flowers) {
	this.flowers = flowers;
    }

    public void setWrappers(List<Wrapper> wrappers) {
	this.wrappers = wrappers;
    }

    @Override
    public int hashCode() {
	return Objects.hash(flowers, wrappers);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Bouquet other = (Bouquet) obj;
	return Objects.equals(flowers, other.flowers) && Objects.equals(wrappers, other.wrappers);
    }

    @Override
    public String toString() {
	String str = "Букет:\n";
	int price = 0;
	Set<Flower> flowersSet = Set.copyOf(flowers);
	Set<Wrapper> wrapperSet = Set.copyOf(wrappers);

	for (Flower f : flowersSet) {
	    str += f.getName() + " - " + Collections.frequency(flowers, f) + " шт.";
	    price += Collections.frequency(flowers, f) * f.getPrice();
	}
	str += "\nУпаковка:\n";

	for (Wrapper w : wrapperSet) {
	    str += w.getName() + " - " + Collections.frequency(wrappers, w) + " шт.";
	    price += Collections.frequency(wrappers, w) * w.getPrice();
	}
	str += "\nСтоимость букета " + price + " руб.\n";

	return str;
    }

}
