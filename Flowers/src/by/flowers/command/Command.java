package by.flowers.command;

import by.flowers.controller.ControllerException;

public interface Command {

    public String execute(String request) throws ControllerException;
}
