package by.flowers.dao;

import by.flowers.dao.impl.FileFlowerDao;
import by.flowers.dao.impl.FileWrapperDao;

public class DAOProvider {
    
    private static final DAOProvider instance = new DAOProvider();

    private DAOProvider() {
    }

    public static DAOProvider getInstance() {
	return instance;
    }
    
    private FlowersDao flowersDao = new FileFlowerDao();
    private WrapperDao wrapperDao = new FileWrapperDao();

    public FlowersDao getFlowersDao() {
        return flowersDao;
    }

    public WrapperDao getWrapperDao() {
        return wrapperDao;
    }

}
