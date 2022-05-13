package by.javalearning.homework.theme3;

import java.util.Scanner;

/* 
 * 3.Strings and basics of text processing
 * Работа со строкой как с объектом типа String или StringBuilder.
 * Задача 7. Вводится строка. Требуется удалить из нее повторяющиеся символы 
 * и все пробелы. Например, если было введено "abc cde def", то должно быть 
 * выведено "abcdef".
 */

public class StringsStringObjectsEx7 {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	String s;
	System.out.println("Введите строку: ");
	s = in.nextLine();
	String s1 = cleanUpString(s);
	System.out.println("Обновленная строка: \n" + s1);
	in.close();
    }

    static String cleanUpString(String s) {
	s=s.replace(" ", "");
	int i = 0;
        while (i < s.length()) {
            String si = s.substring(i, i + 1);
            String tail = s.substring(i + 1).replace(si, "");
            s = s.substring(0, i + 1).concat(tail);
            i++;
        }
	return s;
    }

}
