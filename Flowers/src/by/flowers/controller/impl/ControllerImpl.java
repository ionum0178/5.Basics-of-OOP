package by.flowers.controller.impl;

import by.flowers.command.Command;
import by.flowers.command.CommandProvider;
import by.flowers.controller.Controller;
import by.flowers.controller.ControllerException;
import by.flowers.service.FlowerService;
import by.flowers.service.ServiceException;
import by.flowers.service.ServiceProvider;

public class ControllerImpl implements Controller {
    
    private CommandProvider provider = new CommandProvider();
    
    @Override
    public String doAction(String request) throws ControllerException {
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

    @Override
    public boolean fillStock() throws ControllerException {
	ServiceProvider serviceProvider = ServiceProvider.getInstance();
	FlowerService flowerService = serviceProvider.getFlowerService();
	try {
	    if (flowerService.fillStock())
		return true;
	    else
		return false;
	} catch (ServiceException e) {
	    throw new ControllerException();
	}
    }

}
