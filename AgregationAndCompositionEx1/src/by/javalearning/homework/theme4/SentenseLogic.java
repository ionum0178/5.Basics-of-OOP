package by.javalearning.homework.theme4;

import java.util.ArrayList;
import java.util.List;

public class SentenseLogic {

    private List<Word> sentense;
    private Sentense s;
    
    public SentenseLogic() {
	sentense = new ArrayList<Word>();
	s = new Sentense();
    }
    
    public void addWord(Word word) {
	sentense.add(word);
	s.setSentense(sentense);
    }
    
    public List<Word> getSentense() {
        return s.getSentense();
    }

    public void setSentense(List<Word> sentense) {
        s.setSentense(sentense);
    }

    public Sentense getS() {
        return s;
    }

    public void setS(Sentense s) {
        this.s = s;
    }


    
}
