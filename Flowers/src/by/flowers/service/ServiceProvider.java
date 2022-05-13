package by.flowers.service;

import by.flowers.service.impl.FlowerServiceImpl;

public class ServiceProvider {

    public static final ServiceProvider instance = new ServiceProvider();
    private ServiceProvider() {}
    public static ServiceProvider getInstance() {
	return instance;
    }
    
    private FlowerService flowerService = new FlowerServiceImpl();
    
    public FlowerService getFlowerService() {
        return flowerService;
    }
    
}
