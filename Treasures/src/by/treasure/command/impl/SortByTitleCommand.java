package by.treasure.command.impl;

import by.treasure.command.Command;
import by.treasure.controller.ControllerException;
import by.treasure.service.ServiceException;
import by.treasure.service.ServiceProvider;
import by.treasure.service.TreasureService;

public class SortByTitleCommand implements Command {

    @Override
    public String execute(String request) throws ControllerException {
	ServiceProvider serviceProvider = ServiceProvider.getInstance();
	TreasureService treasureService = serviceProvider.getTreasureService();
	String response="";
	try {
	    response += treasureService.sortByTitle();
	} catch (ServiceException e) {
	   throw new ControllerException();
	}
	return response;
    }

}
