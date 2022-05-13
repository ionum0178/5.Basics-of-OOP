package by.flowers.service.impl;

import java.util.ArrayList;
import java.util.List;

import by.flowers.bean.Bouquet;
import by.flowers.bean.Flower;
import by.flowers.bean.Wrapper;
import by.flowers.controller.Controller;
import by.flowers.controller.ControllerException;
import by.flowers.controller.impl.ControllerImpl;
import by.flowers.dao.DAOException;
import by.flowers.dao.DAOProvider;
import by.flowers.service.FlowerService;
import by.flowers.service.ServiceException;

public class FlowerServiceImpl implements FlowerService {

    private Controller controller = new ControllerImpl();

    @Override
    public boolean fillStock() throws ServiceException {
	DAOProvider provider = DAOProvider.getInstance();
	boolean result = false;
	
	try {
	    result = provider.getFlowersDao().fillStock() && provider.getWrapperDao().fillStock();
	} catch (DAOException e) {
	    throw new ServiceException();
	}

	return result;
    }

    @Override
    public String flowers() throws ServiceException {
	DAOProvider provider = DAOProvider.getInstance();
	String result = "";
	try {
	    result = provider.getFlowersDao().flowers().toString();
	} catch (DAOException e) {
	    throw new ServiceException();
	}
	return result;
    }

    @Override
    public String wrappers() throws ServiceException {
	DAOProvider provider = DAOProvider.getInstance();
	String result = "";
	try {
	    result = provider.getWrapperDao().wrappers().toString();
	} catch (DAOException e) {
	    throw new ServiceException();
	}
	return result;
    }

    @Override
    public String makeBouquet() throws ServiceException {

	DAOProvider provider = DAOProvider.getInstance();

	List<Flower> flowers = null;
	List<Wrapper> wrappers = null;

	String result = "";
	try {
	    flowers = provider.getFlowersDao().flowers();
	    wrappers = provider.getWrapperDao().wrappers();

	} catch (DAOException e) {
	    throw new ServiceException();
	}
	Bouquet bouquet = new Bouquet();

	bouquet = addFlowers(bouquet, flowers);
	bouquet = addWrappers(bouquet, wrappers);
	
	result = bouquet.toString();
	return result;
    }

    private Bouquet addFlowers(Bouquet bouquet, List<Flower> flowers) throws ServiceException {
	List<Flower> someFlowers = new ArrayList<Flower>();

	String responce = "";

	while (responce != "enough") {

	    try {
		responce = controller.doAction("addFlower");
	    } catch (ControllerException e) {
		throw new ServiceException();
	    }
	    
	    
	    switch (responce) {
	    case "rose": {
		someFlowers.add(flowers.get(0));
		bouquet.setFlowers(someFlowers);
		break;
	    }
	    case "carnation": {
		someFlowers.add(flowers.get(1));
		bouquet.setFlowers(someFlowers);
		break;
	    }
	    case "chrysanthema": {
		someFlowers.add(flowers.get(2));
		bouquet.setFlowers(someFlowers);
		break;
	    }
	    case "gerbera": {
		someFlowers.add(flowers.get(3));
		bouquet.setFlowers(someFlowers);
		break;
	    }
	    case "tulip": {
		someFlowers.add(flowers.get(4));
		bouquet.setFlowers(someFlowers);
		break;
	    }


	    }

	}
	return bouquet;
    }

    private Bouquet addWrappers(Bouquet bouquet, List<Wrapper> wrappers) {
	List<Wrapper> someFlowers = new ArrayList<Wrapper>();

	String responce = "";

	while (responce != "enough") {

	    try {
		responce = controller.doAction("addWrapper");
	    } catch (ControllerException e) {
		e.printStackTrace();
	    }
	    switch (responce) {
	    case "plain paper": {
		someFlowers.add(wrappers.get(0));
		bouquet.setWrappers(someFlowers);
		break;
	    }
	    case "colored paper": {
		someFlowers.add(wrappers.get(1));
		bouquet.setWrappers(someFlowers);
		break;
	    }
	    case "transparent film": {
		someFlowers.add(wrappers.get(2));
		bouquet.setWrappers(someFlowers);
		break;
	    }
	    case "colored film": {
		someFlowers.add(wrappers.get(3));
		bouquet.setWrappers(someFlowers);
		break;
	    }
	    case "net": {
		someFlowers.add(wrappers.get(4));
		bouquet.setWrappers(someFlowers);
		break;
	    }
	    }

	}
	return bouquet;
    }

}
