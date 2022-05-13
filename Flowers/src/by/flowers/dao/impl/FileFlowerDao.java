package by.flowers.dao.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import by.flowers.bean.Flower;
import by.flowers.dao.DAOException;
import by.flowers.dao.FlowersDao;
import by.flowers.source.FlowerList;
import by.flowers.source.SourceProvider;

public class FileFlowerDao implements FlowersDao{

    private static final String FLOWERS_SOURCE = "./src/resource/flowers.txt";
    
    @SuppressWarnings("resource")
    @Override
    public boolean fillStock() throws DAOException {
	
	File file = new File(FLOWERS_SOURCE);
	String name;
	int price;

	FlowerList flowerList = new FlowerList();
	
	Scanner sc = null;
	try {
	    sc = new Scanner(file).useDelimiter(";|\\n");

	    while (sc.hasNextLine()) {
		name = "\n" + sc.next();
		price = Integer.parseInt(sc.next().trim());
		flowerList.getFlowerList().add(new Flower(name, price));
		continue;
	    }
	} catch (FileNotFoundException e) {
	    throw new DAOException(e);
	} 

	SourceProvider provider = SourceProvider.getInstance();
	provider.setFlowerList(flowerList);
	
	if (provider.getFlowerList().getFlowerList() == null)
	    return false;
	else
	    return true;
    }

    @Override
    public List<Flower> flowers() throws DAOException {
	SourceProvider provider = SourceProvider.getInstance();
	return provider.getFlowerList().getFlowerList();
    }

}
