package by.treasure.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import by.treasure.bean.Treasure;
import by.treasure.dao.DAOException;
import by.treasure.dao.DAOProvider;
import by.treasure.dao.TreasureDao;
import by.treasure.service.ServiceException;
import by.treasure.service.TreasureService;
import by.treasure.service.util.Validator;

public class TreasureServiceImpl implements TreasureService {

    
    private PriceCompare priceCompare = new PriceCompare();
    private TitleCompare titleCompare = new TitleCompare();
    
    @Override
    public String treasures() throws ServiceException {
	DAOProvider provider = DAOProvider.getInstance();
	TreasureDao treasureDao = provider.getTreasureDao();
	
	List<Treasure> result = null;
	try {
	    result = treasureDao.treasures();
	} catch (DAOException e) {
	    throw new ServiceException(e);
	}
	
	return result.toString();
    }

    @Override
    public String sortByPrice() throws ServiceException {
	
	DAOProvider provider = DAOProvider.getInstance();
	TreasureDao treasureDao = provider.getTreasureDao();
	
	List<Treasure> result = null;
	try {
	    result = treasureDao.treasures();
	    result.sort(priceCompare);
	} catch (DAOException e) {
	    throw new ServiceException(e);
	}
	
	return result.toString();
    }

    @Override
    public String sortByTitle() throws ServiceException {
	
	DAOProvider provider = DAOProvider.getInstance();
	TreasureDao treasureDao = provider.getTreasureDao();
	
	List<Treasure> result = null;
	try {
	    result = treasureDao.treasures();
	    result.sort(titleCompare);
	} catch (DAOException e) {
	    throw new ServiceException(e);
	}
	
	return result.toString();
    }

    @Override
    public String getMostPreciousTreasure() throws ServiceException {
	DAOProvider provider = DAOProvider.getInstance();
	TreasureDao treasureDao = provider.getTreasureDao();
	
	List<Treasure> result = null;
	try {
	    result = treasureDao.treasures();
	    result.sort(priceCompare);
	} catch (DAOException e) {
	    throw new ServiceException(e);
	}
	return result.get(result.size()-1).toString();
    }
    
    @Override
    public String getSelectedTreasures(int cash) throws ServiceException {
	if(!Validator.isPriceValid(cash)) {
	    throw new ServiceException("You'd better look for a currency exchange!");
	}
	
	DAOProvider provider = DAOProvider.getInstance();
	TreasureDao treasureDao = provider.getTreasureDao();
	
	List<Treasure> result = null;
	try {
	    result = treasureDao.treasures();
	} catch (DAOException e) {
	    throw new ServiceException(e);
	}
	
	List<Treasure> selected = new ArrayList<Treasure>();
	for(Treasure t: result) {
	    if(t.getPrice() == cash) {
		selected.add(t);
	    }
	}
	return selected.toString();
    }
    
    @Override
    public boolean fillTreasureList() throws ServiceException {
	DAOProvider provider = DAOProvider.getInstance();
	TreasureDao treasureDao = provider.getTreasureDao();
	try {
	    if (treasureDao.fillTreasureList()) return true;
	    else return false;
	} catch (DAOException e) {
	    throw new ServiceException();
	}
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
