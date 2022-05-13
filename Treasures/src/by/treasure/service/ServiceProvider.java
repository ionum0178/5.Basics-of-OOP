package by.treasure.service;

import by.treasure.service.impl.TreasureServiceImpl;

public class ServiceProvider {
    
    private static final ServiceProvider instance = new ServiceProvider();
    private ServiceProvider() {}
    public static ServiceProvider getInstance() {
	return instance;
    }

    private TreasureService treasureService = new TreasureServiceImpl();

    public TreasureService getTreasureService() {
        return treasureService;
    }
    
}
