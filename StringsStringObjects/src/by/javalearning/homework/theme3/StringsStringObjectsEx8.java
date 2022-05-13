package by.javalearning.homework.theme3;

import java.util.Scanner;

/* 
 * 3.Strings and basics of text processing
 * Работа со строкой как с объектом типа String или StringBuilder.
 * Задача 8. Вводится строка слов, разделенных пробелами. Найти самое 
 * длинное слово и вывести его на экран. Случай, когда самых длинных слов 
 * может быть несколько, не обрабатывать.
 */

public class StringsStringObjectsEx8 {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	String s;
	System.out.println("Введите строку: ");
	s = in.nextLine();
	String s1 = longestWord(s);
	System.out.print("Самое длинное слово: " + s1);
	in.close();
    }

    static String longestWord(String s) {
	String w="";
	String[] words = s.split(" ");
	int countletters=0;
	int countwords=0;
	for (int i=0; i<words.length; i++) {
	    if (words[i].length()>countletters) {
		countletters=words[i].length();
		w=words[i];
	    }
	}
	for (int i=0; i<words.length; i++) {
	    if (words[i].length()==countletters) {
		countwords++;
	    }
	}
	if (countwords>1) {
	    return "не найдено";
	} else {
	    return w;
	}
    }
}
