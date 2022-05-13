package by.javalearning.homework.theme3;

import java.util.Scanner;

/* 
 * 3.Strings and basics of text processing
 * –абота со строкой как с массивом символов.
 * «адача 5. ”далить в строке все лишние пробелы, то есть серии подр€д идущих 
 * пробелов заменить на одиночные пробелы.  райние пробелы в строке удалить.
 */

public class StringsSymbolArraysEx5 {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	String s;
	System.out.println("¬ведите строку: ");
	s = in.nextLine();
	String s1 = deleteSpaces(s);
	System.out.println("ќбновленна€ строка: \n(начало строки)" + s1 + "(конец строки)");
	in.close();
    }
    
    static String deleteSpaces(String s) {
	// разбиваем строку
	char[] c = s.toCharArray();
	int i = 0;
	String s1="";
	// собираем строку
	
	// начало строки 
	while (Character.isWhitespace(c[i])) {
		i++;
		if (i == c.length) {
		    break;
		}
	}
	// продолжаем строку
	while (i < c.length) {
	    if (!Character.isWhitespace(c[i])) {
		s1=s1+c[i];
		i++;
		if (i == c.length) {
		    break;
		}
	    }
	    
	    while (Character.isWhitespace(c[i])) {
		    i++;
		    if (i == c.length) {
			break;
		    }
		    if (!Character.isWhitespace(c[i])) {
			s1=s1+c[i-1];
		    }
	    }
	}
    return s1;
    }
}
