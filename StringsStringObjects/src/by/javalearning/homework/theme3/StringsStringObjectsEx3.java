package by.javalearning.homework.theme3;

import java.util.Scanner;

/* 
 * 3.Strings and basics of text processing
 * Работа со строкой как с объектом типа Stringили StringBuilder.
 * Задача 3. Проверить, является ли заданное слово палиндромом.
 */
 
public class StringsStringObjectsEx3 {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	String s;
	System.out.println("Введите строку: ");
	s = in.nextLine();
	palindromCheck(s);
	in.close();
    }

    static void palindromCheck(String s) {
	String s1="";
	for (int i=(s.length()-1);i>=0;i--) {
	    s1+=s.charAt(i);
	}
	if (s1.equals(s)) {
	    System.out.println("Строка является палиндромом");
	} else {
	    System.out.println("Строка не является палиндромом");
	}
    }

}
