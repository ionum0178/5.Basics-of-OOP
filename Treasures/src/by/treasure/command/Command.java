package by.treasure.command;

import by.treasure.controller.ControllerException;

public interface Command {

    String execute(String request) throws ControllerException;
}
