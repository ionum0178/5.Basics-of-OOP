package by.flowers.source;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import by.flowers.bean.Flower;

public class FlowerList {

    private List<Flower> flowerList = new ArrayList<Flower>();
    
    public FlowerList() {}

    public FlowerList(List<Flower> flowerList) {
	this.flowerList = flowerList;
    }

    public List<Flower> getFlowerList() {
        return flowerList;
    }

    public void setFlowerList(List<Flower> flowerList) {
        this.flowerList = flowerList;
    }

    @Override
    public int hashCode() {
	return Objects.hash(flowerList);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	FlowerList other = (FlowerList) obj;
	return Objects.equals(flowerList, other.flowerList);
    }

    @Override
    public String toString() {
	String str = "";
	for(Flower f: flowerList) {
	    str += f.toString() + "\n";
	}
	return str;
    }
    
    
}
