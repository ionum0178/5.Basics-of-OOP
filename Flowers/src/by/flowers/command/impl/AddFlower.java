package by.flowers.command.impl;

import by.flowers.command.Command;
import by.flowers.controller.ControllerException;
import by.flowers.view.View;
import by.flowers.view.ViewProvider;

public class AddFlower implements Command {

    @Override
    public String execute(String request) throws ControllerException {
	ViewProvider provider = ViewProvider.getInstance();
	View view = provider.getView();
	String responce = view.addFlower();
	return responce;
    }

}
