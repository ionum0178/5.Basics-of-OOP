package by.javalearning.homework.theme5;

import java.util.Objects;

public class Treasure {

    private String title;
    private int price;
    
    public Treasure (String title, int price) {
	this.title = title;
	this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
	return Objects.hash(price, title);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Treasure other = (Treasure) obj;
	return price == other.price && Objects.equals(title, other.title);
    }

    @Override
    public String toString() {
	return String.format("%-40s%s%d", title, "цена=", price);
    }
    
}
