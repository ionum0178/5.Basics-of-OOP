package by.flowers.source;

public class SourceProvider {
    
    private static final SourceProvider instance = new SourceProvider();

    private SourceProvider() {
    }

    public static SourceProvider getInstance() {
	return instance;
    }

    private FlowerList flowerList = new FlowerList();
    private WrapperList wrapperList = new WrapperList();
    
    public WrapperList getWrapperList() {
        return wrapperList;
    }

    public void setWrapperList(WrapperList wrapperList) {
        this.wrapperList = wrapperList;
    }

    public FlowerList getFlowerList() {
	return flowerList;
    }

    public void setFlowerList(FlowerList flowerList) {
	this.flowerList = flowerList;
    }
    
    
}
