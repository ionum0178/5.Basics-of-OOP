package by.flowers.command.impl;

import by.flowers.command.Command;
import by.flowers.controller.ControllerException;
import by.flowers.service.FlowerService;
import by.flowers.service.ServiceException;
import by.flowers.service.ServiceProvider;

public class MakeNewBouquet implements Command {

    @Override
    public String execute(String request) throws ControllerException {
	
	ServiceProvider serviceProvider = ServiceProvider.getInstance();
	FlowerService flowerService = serviceProvider.getFlowerService();
	
	String response="";
	try {
	    response += flowerService.makeBouquet() + "\n";
	} catch (ServiceException e) {
	   throw new ControllerException();
	}
	return response;
	
    }

}
