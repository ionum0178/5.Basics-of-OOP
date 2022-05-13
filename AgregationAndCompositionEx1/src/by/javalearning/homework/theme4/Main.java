package by.javalearning.homework.theme4;

/* 
 * 4. Programming with classes
 * Агрегация и композиция.
 * 1. Создать объект класса Текст, используя классы Предложение, Слово. 
 * Методы: дополнить текст, вывести на консоль текст, заголовок текста. 
 */

public class Main {

    public static void main(String[] args) {
	
	String header = "Iron Maiden";
        TextLogic text = new TextLogic(header);

        Word word1 = new Word("fear");
        Word word2 = new Word("of");
        Word word3 = new Word("the");
        Word word4 = new Word("dark");

        Word word5 = new Word("famous");
        Word word6 = new Word("iron");
        Word word7 = new Word("maiden's");
        Word word8 = new Word("song");
        
        SentenseLogic sentense1 = new SentenseLogic();
        sentense1.addWord(word1);
        sentense1.addWord(word2);
        sentense1.addWord(word3);
        sentense1.addWord(word4);

        text.addSentense(sentense1);
        
        SentenseLogic sentense2 = new SentenseLogic();
        sentense2.addWord(word5);
        sentense2.addWord(word6);
        sentense2.addWord(word7);
        sentense2.addWord(word8);

        text.addSentense(sentense2);
        
        System.out.println("Header: "+ text.getHeader());
        System.out.println("Body: "+ text.toString());

    }

}
