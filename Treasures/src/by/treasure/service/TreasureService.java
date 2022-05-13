package by.treasure.service;

public interface TreasureService {
    
    boolean fillTreasureList() throws ServiceException;
    String treasures() throws ServiceException;
    String sortByPrice() throws ServiceException;
    String sortByTitle() throws ServiceException;
    String getMostPreciousTreasure() throws ServiceException;
    String getSelectedTreasures(int cash) throws ServiceException;
    
}
