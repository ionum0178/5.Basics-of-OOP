package by.javalearning.homework.theme4;

import java.util.ArrayList;
import java.util.List;

public class TextLogic {

    private List<Sentense> text;
    private Text t;
    
    public TextLogic(String header) {
   	text = new ArrayList<Sentense>();
   	t = new Text(header);
       }
    
    public void addSentense(SentenseLogic sentense) {
	text.add(sentense.getS());
	t.setText(text);
    }

    public String getHeader() {
        return t.getHeader();
    }

    public List<Sentense> getText() {
        return t.getText();
    }

    public void setHeader(String header) {
        t.setHeader(header);
    }

    public void setText(List<Sentense> text) {
        t.setText(text);
    }
    
    public String toString() {
	return t.toString();
    }
    
    
}
