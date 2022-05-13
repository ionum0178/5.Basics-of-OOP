package by.treasure.source;

public class SourceProvider {
    
    private static final SourceProvider instance = new SourceProvider();

    private SourceProvider() {
    }

    public static SourceProvider getInstance() {
	return instance;
    }

    private TreasureList treasureList = new TreasureList();
    
    public TreasureList getTreasureList() {
	return treasureList;
    }

    public void setTreasureList(TreasureList treasureList) {
	this.treasureList = treasureList;
    }
}
