package by.javalearning.homework.theme3;

/* 
 * 3.Strings and basics of text processing
 * Работа со строкой как с объектом типа String или StringBuilder.
 * Задача 4. С помощью функции копирования и операции конкатенации составить 
 * из частей слова “информатика” слово “торт”.
 */

public class StringsStringObjectsEx4 {

    public static void main(String[] args) {
	String s1 = "информатика";
        String s2 = s1.substring(7, 8);
        s2 = s2.concat(s1.substring(3, 5)).concat(s2);
        System.out.println(s2);
    }
}
