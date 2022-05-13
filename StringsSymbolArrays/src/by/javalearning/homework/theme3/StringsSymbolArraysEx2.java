package by.javalearning.homework.theme3;

import java.util.Scanner;

/* 
 * 3.Strings and basics of text processing
 * Работа со строкой как с массивом символов.
 * Задача 2. Замените в строке все вхождения 'word' на 'letter'.
 */

public class StringsSymbolArraysEx2 {

	public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    String s;
	    System.out.println("Введите строку для преобразования: ");
	    s = in.nextLine();
	    if (s.length()<4) {System.out.println(s);System.exit(1);}
	    s = wordToLetter(s);
	    System.out.println(s);
	    in.close();
	}
	
	static String wordToLetter(String st) {
	//    char[] word="word".toCharArray();
//	    char[] letter="letter".toCharArray();
	    char[] c=st.toCharArray();
	    int shift=0;
	    for (int i = 0; i < c.length-4; i++){
		    if (c[i] == 'w' && c[i+1] == 'o' && c[i+2] == 'r' && c[i+3] == 'd') {
			shift+=2;
		    }
	    }
	    char[] cc = new char [c.length+shift];
	    shift=0;
	    int i=0;
	    while (i<=c.length-4) {
		if (c[i] == 'w' && c[i+1] == 'o' && c[i+2] == 'r' && c[i+3] == 'd') {
			cc[i+shift]='l';
			cc[i+shift+1]='e';
			cc[i+shift+2]='t';
			cc[i+shift+3]='t';
			cc[i+shift+4]='e';
			cc[i+shift+5]='r';
			i+=4;
			shift+=2;
		} else {
		    cc[i+shift]=c[i]; 
		    i++;		
		    if (i==c.length-4) {
		        cc[i+shift]=c[i];
			cc[i+shift+1]=c[i+1];
			cc[i+shift+2]=c[i+2];
			cc[i+shift+3]=c[i+3];
		    }
	        }
	    }
	    return new String(cc);
	}
}
