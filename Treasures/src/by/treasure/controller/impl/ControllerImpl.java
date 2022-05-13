package by.treasure.controller.impl;

import by.treasure.command.Command;
import by.treasure.command.CommandProvider;
import by.treasure.controller.Controller;
import by.treasure.controller.ControllerException;
import by.treasure.service.ServiceException;
import by.treasure.service.ServiceProvider;
import by.treasure.service.TreasureService;

public class ControllerImpl implements Controller{
    
    private CommandProvider provider = new CommandProvider();

    public String doAction(String request) {

	String commandName = request;

	Command command = provider.getCommand(commandName);
	String responce="";
	try {
	    responce = command.execute(request);
	} catch (ControllerException e) {
	    e.printStackTrace();
	}

	return responce;
    }

    public boolean fillTreasureList() throws ControllerException {
	ServiceProvider serviceProvider = ServiceProvider.getInstance();
	TreasureService treasureService = serviceProvider.getTreasureService();
	try {
	    if (treasureService.fillTreasureList())
		return true;
	    else
		return false;
	} catch (ServiceException e) {
	    throw new ControllerException();
	}
    }
}
