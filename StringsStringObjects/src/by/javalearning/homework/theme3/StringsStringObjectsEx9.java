package by.javalearning.homework.theme3;

import java.util.Scanner;

/* 
 * 3.Strings and basics of text processing
 * Работа со строкой как с объектом типа String или StringBuilder.
 * Задача 9. Посчитать количество строчных (маленьких) и прописных (больших) 
 * букв в введенной строке. Учитывать только английские буквы.
 */

public class StringsStringObjectsEx9 {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	String s;
	System.out.println("Введите строку: ");
	s = in.nextLine();
	countSymbols(s);
	in.close();
    }

    static void countSymbols(String s) {
	int lowercase=0;
	int uppercase=0;
	for (int i=0; i<s.length(); i++) {
	    if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
		lowercase++;
	    }
	    if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
		uppercase++;
            }
	}
	System.out.println("Количество строчных букв: " + lowercase);
	System.out.println("Количество прописных букв: " + uppercase);
    }
}
