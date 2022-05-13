package by.treasure.dao;

import by.treasure.dao.impl.FileTreasureDao;

public class DAOProvider {

    private static final DAOProvider instance = new DAOProvider();

    private DAOProvider() {
    }

    public static DAOProvider getInstance() {
	return instance;
    }

    private TreasureDao treasureDao = new FileTreasureDao();

    public TreasureDao getTreasureDao() {
	return treasureDao;
    }



}
