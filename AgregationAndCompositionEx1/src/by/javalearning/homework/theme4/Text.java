package by.javalearning.homework.theme4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* 
 * 4. Programming with classes
 * Агрегация и композиция.
 * 1. Создать объект класса Текст, используя классы Предложение, Слово. 
 * Методы: дополнить текст, вывести на консоль текст, заголовок текста. 
 */

public class Text {
    
    private String header;
    private List<Sentense> text;

    public Text(String header) {
	this.header = header;
	text = new ArrayList<Sentense>();
    }

    public String getHeader() {
	return header;
    }

    public List<Sentense> getText() {
	return text;
    }

    public void setHeader(String header) {
	this.header = header;
    }

    public void setText(List<Sentense> text) {
	this.text = text;
    }

    public String toString() {
	String string = "";
	for (int i = 0; i < text.size(); i++) {
	  	string += text.get(i).toString();
	}
	return string;
    }

    @Override
    public int hashCode() {
	return Objects.hash(header, text);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Text other = (Text) obj;
	return Objects.equals(header, other.header) && Objects.equals(text, other.text);
    }

    
}
