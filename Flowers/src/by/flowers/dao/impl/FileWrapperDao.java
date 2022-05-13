package by.flowers.dao.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import by.flowers.bean.Wrapper;
import by.flowers.dao.DAOException;
import by.flowers.dao.WrapperDao;
import by.flowers.source.WrapperList;
import by.flowers.source.SourceProvider;

public class FileWrapperDao implements WrapperDao{

    private static final String WRAPPER_SOURCE = "./src/resource/wrapper.txt";
    
    @SuppressWarnings("resource")
    @Override
    public boolean fillStock() throws DAOException {
	File file = new File(WRAPPER_SOURCE);
	String name;
	int price;

	WrapperList wrapperList = new WrapperList();
	
	Scanner sc = null;
	try {
	    sc = new Scanner(file).useDelimiter(";|\\n");

	    while (sc.hasNextLine()) {
		name = "\n" + sc.next();
		price = Integer.parseInt(sc.next().trim());
		wrapperList.getWrapperList().add(new Wrapper(name, price));
		continue;
	    }
	} catch (FileNotFoundException e) {
	    throw new DAOException(e);
	} 
	
	SourceProvider provider = SourceProvider.getInstance();
	provider.setWrapperList(wrapperList);
	
	if (provider.getWrapperList().getWrapperList() == null)
	    return false;
	else
	    return true;
    }

    @Override
    public List<Wrapper> wrappers() throws DAOException {
	SourceProvider provider = SourceProvider.getInstance();
	return provider.getWrapperList().getWrapperList();
    }

}
