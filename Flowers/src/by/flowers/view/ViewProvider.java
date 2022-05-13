package by.flowers.view;

public class ViewProvider {

    public static final ViewProvider instance = new ViewProvider();
    
    private ViewProvider() {}
     
    public static ViewProvider getInstance() {
	 return instance;
     }
    private View view = new View();

    public View getView() {
        return view;
    }
    
}
