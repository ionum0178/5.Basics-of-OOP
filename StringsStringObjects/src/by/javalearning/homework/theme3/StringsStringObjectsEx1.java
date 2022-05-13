package by.javalearning.homework.theme3;

import java.util.Scanner;

/* 
 * 3.Strings and basics of text processing
 * Работа со строкой как с объектом типа String или StringBuilder.
 * Задача 1. Дан текст(строка). Найдите наибольшее количество подряд 
 * идущих пробелов в нем.
 */
 
public class StringsStringObjectsEx1 {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	String s;
	System.out.println("Введите строку: ");
	s = in.nextLine();
	int q = spacesCount(s);
	System.out.println("Наибольшее количество подряд идущих пробелов: " + q);
	in.close();
    }

    static int spacesCount(String s) {
	int spaces=0;
	int maxSpaces=0;
	int i=0;
	while (i<s.length()) {
	    spaces=0;
	    while(s.charAt(i) == ' ') {
                spaces++;
                i++;
		if (i == s.length()) {
		    break;
		}
	    }
	    if (spaces > maxSpaces) {
		maxSpaces = spaces;
	    }
	    i++;
	}
	return maxSpaces;
    }
}
