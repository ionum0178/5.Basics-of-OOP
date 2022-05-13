package by.javalearning.homework.theme4;

import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

/* 
 * 4. Programming with classes
 * Агрегация и композиция.
 * 1. Создать объект класса Текст, используя классы Предложение, Слово. 
 * Методы: дополнить текст, вывести на консоль текст, заголовок текста. 
 */

public class Sentense {
    
    private List<Word> sentense;

    public Sentense() {
	sentense = new ArrayList<Word>();
    }

    public List<Word> getSentense() {
	return sentense;
    }

    public void setSentense(List<Word> sentense) {
	this.sentense = sentense;
    }
    
    @Override
    public int hashCode() {
	return Objects.hash(sentense);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Sentense other = (Sentense) obj;
	return Objects.equals(sentense, other.sentense);
    }

    public String toString() {
	String string = "";
	for (int i = 0; i < sentense.size(); i++) {
	    if (i == 0) {
		string += sentense.get(i).getWord().substring(0, 1).toUpperCase();
		string += sentense.get(i).getWord().substring(1);
	    } else
		string += sentense.get(i).getWord();
	    if ((i + 1) == sentense.size())
		string += ". ";
	    else
		string += " ";
	}
	return string;
    }

}
