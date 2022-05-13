package by.javalearning.homework.theme5;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
 * Задача 2. Создать класс Payment с внутренним классом, с помощью объектов 
 * которого можно сформировать покупку из нескольких товаров.
*/

public class Payment {

    private List<Good> allGoods = new ArrayList<Good>();
    private List<Good> basket = new ArrayList<Good>();

    public List<Good> getAllGoods() {
        return allGoods;
    }

    public List<Good> getBasket() {
        return basket;
    }

    public void setAllGoods(List<Good> allGoods) {
        this.allGoods = allGoods;
    }

    public void setBasket(List<Good> basket) {
        this.basket = basket;
    }

    @Override
    public int hashCode() {
	return Objects.hash(allGoods, basket);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Payment other = (Payment) obj;
	return Objects.equals(allGoods, other.allGoods) && Objects.equals(basket, other.basket);
    }
    
    @Override
    public String toString() {
	return "Payment [allGoods=" + allGoods + ", basket=" + basket + "]";
    }
    
    public class Good{
	
	private String name;
	private int price;
	
	public Good(String name, int price) {
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
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + getEnclosingInstance().hashCode();
	    result = prime * result + Objects.hash(name, price);
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
	    Good other = (Good) obj;
	    if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
		return false;
	    return Objects.equals(name, other.name) && price == other.price;
	}

	private Payment getEnclosingInstance() {
	    return Payment.this;
	}

	@Override
	public String toString() {
	    return String.format(("%-11s цена=%s\n"),name, price);
	}
	
	
    }
}
