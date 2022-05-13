package by.javalearning.homework.theme3;

import java.util.Scanner;

/* 
 * 3.Strings and basics of text processing
 * Работа со строкой как с объектом типа String или StringBuilder.
 * Задача 5. Подсчитать, сколько раз среди символов заданной строки 
 * встречается буква “а”.
 */

public class StringsStringObjectsEx5 {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	String s;
	System.out.println("Введите строку: ");
	s = in.nextLine();
	int q = aLetterCounter(s);
	System.out.println("Количество букв а: " + q);
	in.close();
    }
    
    static int aLetterCounter(String s) {
	int q=0;
	for (int i=0; i<s.length();i++) {
	    if(s.charAt(i)=='a' || s.charAt(i)=='A'|| s.charAt(i)=='а'|| 
		    s.charAt(i)=='А') {
		q++;
	    }
	}
	return q;
    }
}
