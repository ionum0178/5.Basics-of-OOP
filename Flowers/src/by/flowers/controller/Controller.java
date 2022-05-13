package by.flowers.controller;

public interface Controller {

    public String doAction(String request) throws ControllerException;
    boolean fillStock() throws ControllerException;
}
