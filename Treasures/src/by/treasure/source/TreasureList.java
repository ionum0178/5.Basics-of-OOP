package by.treasure.source;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import by.treasure.bean.Treasure;

public class TreasureList {
    
    private List<Treasure> treasureList = new ArrayList<Treasure>();
    
    public TreasureList() {}

    public TreasureList(List<Treasure> treasureList) {
	this.treasureList = treasureList;
    }

    public List<Treasure> getTreasureList() {
	return treasureList;
    }

    public void setTreasureList(List<Treasure> treasureList) {
	this.treasureList = treasureList;
    }

    @Override
    public int hashCode() {
	return Objects.hash(treasureList);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	TreasureList other = (TreasureList) obj;
	return Objects.equals(treasureList, other.treasureList);
    }

    @Override
    public String toString() {
	String str = "Список сокровищ:\n";
	for (int i = 0; i < treasureList.size(); i++) {
	    str += treasureList.get(i).toString();
	}
	return str;
    }

}
