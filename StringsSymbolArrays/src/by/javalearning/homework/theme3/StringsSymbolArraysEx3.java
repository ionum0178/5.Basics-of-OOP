package by.javalearning.homework.theme3;

import java.util.Scanner;

/* 
 * 3.Strings and basics of text processing
 * Работа со строкой как с массивом символов.
 * Задача 3. В строке найти количество цифр.
 */

public class StringsSymbolArraysEx3 {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	String s;
	System.out.println("Введите строку: ");
	s = in.nextLine();
	int count = findDigits(s);
	System.out.println("Количество цифр в строке: " + count);
	in.close();
    }
    
    static int findDigits(String s) {
	char[] c=s.toCharArray();
	int count=0;
	int i=0;
	while (i<c.length) {
	    if (Character.isDigit(c[i])) {
	    count++;
	    } 
	i++;
	}
	return count;
	}
}
