package by.treasure.controller;

public interface Controller {

    public String doAction(String request) throws ControllerException; 
//    public List<Treasure> doSortByPrice(int price) throws ControllerException; 
    public boolean fillTreasureList() throws ControllerException; 

}
