package by.flowers.dao;

import java.util.List;

import by.flowers.bean.Wrapper;

public interface WrapperDao {

    boolean fillStock() throws DAOException;
    List<Wrapper> wrappers() throws DAOException;
}
