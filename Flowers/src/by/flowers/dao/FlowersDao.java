package by.flowers.dao;

import java.util.List;

import by.flowers.bean.Flower;

public interface FlowersDao {
    
    boolean fillStock() throws DAOException;
    List<Flower> flowers() throws DAOException;
}
