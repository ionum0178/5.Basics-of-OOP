package by.javalearning.homework.theme3;

import java.util.Scanner;

/* 
 * 3.Strings and basics of text processing
 * Работа со строкой как с массивом символов.
 * Задача 1. Дан массив названий переменных в camelCase. Преобразовать названия в snake_case.
 */

public class StringsSymbolArraysEx1 {

	public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    System.out.println("Введите количество преобразуемых переменных: ");
	    System.out.print("n=");
	    int n = in.nextInt();
	    System.out.println("Введите имена названия переменных в формате camelCase: ");
	    String[] s = new String[n];
	    for (int i = 0; i < n; i++) {
	        s[i] = in.next();
	    }
	    System.out.println("Имена переменных в формате snake_сase: ");
	    for (int i = 0; i < n; i++) {
	        s[i] = camelToSnake(s[i]);
	        System.out.println(s[i]);
	    }  
	    in.close();
	}
	
	static String camelToSnake(String s) {
	    // преобразуем строку в символьный массив
	    // при этом необходимо увеличить длину массива, чтобы вставить "_"
	    int shift = 0;
	    for (int i = 1; i < s.length(); i++) { 
	        if (Character.isUpperCase(s.charAt(i))) shift++;
	    }
	    char[] result = new char[s.length() + shift];
	    result[0] = Character.toLowerCase(s.charAt(0));
	    shift = 0;	    
	    for (int i = 1; i < s.length(); i++) {
	        if (Character.isUpperCase(s.charAt(i))) {
	            result[i + shift] = '_';
	            shift++;
	            result[i + shift] = Character.toLowerCase(s.charAt(i));
	        } else {
	            result[i + shift] = s.charAt(i);
	        }
	    }
	    return new String(result);
	}

}
