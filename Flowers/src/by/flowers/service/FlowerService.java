package by.flowers.service;

public interface FlowerService {

    boolean fillStock() throws ServiceException;
    String flowers() throws ServiceException;
    String wrappers() throws ServiceException;
    String makeBouquet() throws ServiceException;
    

}
