package by.treasure.dao.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import by.treasure.bean.Treasure;
import by.treasure.dao.DAOException;
import by.treasure.dao.TreasureDao;
import by.treasure.source.SourceProvider;
import by.treasure.source.TreasureList;

public class FileTreasureDao implements TreasureDao {
    
    private static final String TREASURE_SOURCE = "./src/resource/treasure.txt";
    
    @Override
    public boolean fillTreasureList() throws DAOException {
	
	File file = new File(TREASURE_SOURCE);
	String title;
	int price;

	TreasureList treasureList = new TreasureList();
	
	Scanner sc = null;
	try {
	    sc = new Scanner(file).useDelimiter(";\\s");

	    while (sc.hasNextLine()) {
		title = "\n" + sc.next().trim();
		price = Integer.parseInt(sc.next());
		treasureList.getTreasureList().add(new Treasure(title, price));
		continue;
	    }
	} catch (FileNotFoundException e) {
	    throw new DAOException(e);
	} finally {
	    sc.close();
	}
	
	SourceProvider provider = SourceProvider.getInstance();
	provider.setTreasureList(treasureList);
	
	if (treasureList.getTreasureList() == null)
	    return false;
	else
	    return true;
    }
    
    @Override
    public List<Treasure> treasures() throws DAOException {
	SourceProvider provider = SourceProvider.getInstance();
	return provider.getTreasureList().getTreasureList();
    }

}
