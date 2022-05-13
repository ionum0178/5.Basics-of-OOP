package by.javalearning.homework.theme3;

import java.util.Scanner;

/* 
 * 3.Strings and basics of text processing
 * Работа со строкой как с объектом типа String или StringBuilder.
 * Задача 6. Из заданной строки получить новую, повторив каждый символ дважды.
 */

public class StringsStringObjectsEx6 {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	String s;
	System.out.println("Введите строку: ");
	s = in.nextLine();
	String s1 = doubleSymbols(s);
	System.out.println("Обновленная строка: \n" + s1);
	in.close();
    }

    static String doubleSymbols(String s) {
	String s1="";
	for (int i=0; i<s.length();i++) {
	    s1=s1 + s.charAt(i) + s.charAt(i);
	}
    	return s1;
    }

}
