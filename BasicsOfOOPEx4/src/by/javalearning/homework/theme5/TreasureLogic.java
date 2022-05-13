package by.javalearning.homework.theme5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TreasureLogic {

    private PriceCompare priceCompare = new PriceCompare();
    private TitleCompare titleCompare = new TitleCompare();

    @SuppressWarnings("resource")
    public List<Treasure> fillTreasureList() throws FileNotFoundException {

	List<Treasure> treasureList = new ArrayList<Treasure>();
	File file = new File("./src/resource/treasure.txt");
	String title;
	int price;
	Scanner sc = new Scanner(file).useDelimiter(";\\s");
	while (sc.hasNextLine()) {
	    title = "\n" + sc.next().trim();
	    price = Integer.parseInt(sc.next());
	    treasureList.add(new Treasure(title, price));
	    continue;
	}
	return treasureList;
    }
    
    public Treasure getMostPreciousTreasure(List<Treasure> treasureList) {
	treasureList.sort(priceCompare);
	return treasureList.get(treasureList.size()-1);
    }

    public List<Treasure> getSelectedTreasures(List<Treasure> treasureList, int cash){
	List<Treasure> selected = new ArrayList<Treasure>();
	for(Treasure t: treasureList) {
	    if(t.getPrice() == cash) {
		selected.add(t);
	    }
	}
	return selected;
    }
    
    public List<Treasure> sortByTitle(List<Treasure> treasureList) {
	treasureList.sort(titleCompare);
	return treasureList;
    }

    public List<Treasure> sortByPrice(List<Treasure> treasureList) {
	treasureList.sort(priceCompare);
	return treasureList;
    }

    public class PriceCompare implements Comparator<Treasure> {
	@Override
	public int compare(Treasure o1, Treasure o2) {
	    return o1.getPrice() - o2.getPrice();
	}
    }

    public class TitleCompare implements Comparator<Treasure> {
	@Override
	public int compare(Treasure o1, Treasure o2) {
	    return o1.getTitle().compareTo(o2.getTitle());
	}
    }
}
