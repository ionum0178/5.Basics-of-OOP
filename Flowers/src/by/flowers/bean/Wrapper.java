package by.flowers.bean;

import java.util.Objects;

public class Wrapper {

    private String name;
    private int price;
    
    public Wrapper(String name, int price) {
	this.name = name;
	this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
	return Objects.hash(name, price);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Wrapper other = (Wrapper) obj;
	return Objects.equals(name, other.name) && price == other.price;
    }

    @Override
    public String toString() {
	return name + ", цена=" + price + ";";
    }
    
    
}
