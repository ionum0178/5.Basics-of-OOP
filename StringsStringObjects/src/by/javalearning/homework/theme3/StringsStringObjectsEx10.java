package by.javalearning.homework.theme3;

import java.util.Scanner;

/* 
 * 3.Strings and basics of text processing
 * Работа со строкой как с объектом типа String или StringBuilder.
 * Задача 10. Строка X состоит из нескольких предложений, каждое из которых 
 * кончается точкой, восклицательным или вопросительным знаком. Определить
 * количество предложений в строке X.
 */

public class StringsStringObjectsEx10 {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in).useDelimiter("\n");
	String s;
	System.out.println("Введите строку: ");
	s = in.nextLine();
	int x = sentenceCount(s);
	System.out.println("Количество предложений в строке: " + x);
	in.close();

    }
    static int sentenceCount(String s) {
	int x=0;
	for (int i=0; i<s.length(); i++) {
	    if (s.charAt(i) == '.' || s.charAt(i) == '!' || s.charAt(i) == '?') {
		x++;
	    }
	}
	return x;
    }

}
