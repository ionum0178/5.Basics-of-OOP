package by.javalearning.homework.theme3;

import java.util.Scanner;

/* 
 * 3.Strings and basics of text processing
 * Работа со строкой как с объектом типа String или StringBuilder.
 * Задача 2. В строке вставить после каждого символа 'a' символ 'b'.
 */
 
public class StringsStringObjectsEx2 {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	String s;
	System.out.println("Введите строку: ");
	s = in.nextLine();
	String s1 = insertB(s);
	System.out.println("Обновленная строка: \n" + s1);
	in.close();
    }

    static String insertB(String s) {
	String s1="";
	int i=0;
	while (i<s.length()) {
	    if (s.charAt(i) == 'a') {
                s1+=s.charAt(i)+"b";
	    } else {
		s1+=s.charAt(i);
	    }
	    i++;
	}
    return s1;
    }
}
