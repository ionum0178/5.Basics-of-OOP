package by.javalearning.homework.theme3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
 * 3.Strings and basics of text processing
 * Работа со строкой как с объектом типа String или StringBuilder.
 * Задача 1.Cоздать приложение, разбирающее текст(текст хранится в строке) и
 * позволяющее выполнять с текстом три различных операции: отсортировать 
 * абзацы по количеству предложений; в каждом предложении отсортировать слова 
 * по длине; отсортировать лексемы в предложении по убыванию количества вхождений
 * заданного символа, а в случае равенства – по алфавиту.
 */

public class StringsRegularExpressionsEx1 {
    private static File file;
    private static Scanner sc;
    private static StringBuilder text;
    private static String txt; 
    private static Pattern linesPattern = Pattern.compile("\\s*[\n\r]+"); // Разделение на абзацы
    private static Pattern sntncPattern = Pattern.compile("[\\.\\!\\?]+"); // Разделение на предложения
    private static Pattern wordsPattern = Pattern.compile("[\\s\\p{Punct}–-]+"); // Разделение на слова

    public static void main(String[] args) {
	readTextFile(); //считываем файл с текстом
	txt = text.toString(); // преобразуем в строку
	startMenu(); 
    }
    
    // считываем файл с текстом
    private static void readTextFile() {
	file = new File("./src/resource/text.txt");
	text = new StringBuilder();
	sc = null;
	try {
	    sc = new Scanner(file);
	    while (sc.hasNextLine()) {
		text.append(sc.nextLine()).append("\n");
	    }
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	    System.exit(1);
	}
    }

    private static void startMenu() {
	@SuppressWarnings("resource")
	Scanner scanner = new Scanner(System.in);
	while (true) {
	    System.out.println("Выберите пункт меню:\n" 
		    + "0. выход\n" 
		    + "1. вывести на экран исходный текст\n"
		    + "2. отсортировать абзацы по количеству предложений\n" 
		    + "3. отсортировать слова в предложениях по длине\n"
		    + "4. отсортировать слова в предложениях по убыванию количества вхождений заданного\r\n"
		    + "символа, а в случае равенства - по алфавиту\n");
	    int choice = scanner.nextInt();
	    if (choice == 0) {
		System.out.println("Попробуйте еще раз!");
		System.exit(1);
	    }
	    if (choice < 1 || choice > 4) {
		System.out.println("выбран неправильный пункт меню, повторите ввод.");
		continue;
	    }
	    switch (choice) {
	    case 1:
		System.out.println(text.toString());
		break;
	    case 2:
		System.out.println(sortLines(txt));
		break;
	    case 3:
		System.out.println(sortByLength(txt));
		break;
	    case 4:
		System.out.print("Введите символ: (из нескольких символов выберется первый)");
		String symb = scanner.next();
		char symbol = symb.charAt(0);
		System.out.println(sortBySymbol(txt, symbol));
		break;
	    }
	}
	}
    
    // сортировка абзацев по количеству предложений
    private static String sortLines(String txt) {
	String[] lines = linesPattern.split(txt); 
	// для сортировки создаем объект с двумя полями: 
	// номер абзаца (index) и количество предложений в нем (value)
	IndexedValue[] sntncQuantity = new IndexedValue[lines.length];
	for (int i = 0; i < lines.length; i++) {
	    sntncQuantity[i] = new IndexedValue();
	    sntncQuantity[i].index = i;
	    sntncQuantity[i].value = sntncPattern.split(lines[i]).length;
	}
	Arrays.sort(sntncQuantity);
	String result = ""; // собираем отсортированный текст
	for (var c : sntncQuantity) {
	    result += lines[c.index] + "\n";
	}
	return result;
    }
    
	// сортировка слов в предложениях по длине
    private static String sortByLength(String txt) {
	String[] lines = linesPattern.split(txt); 
	String result = "";
	for (var ln : lines) {
	    String[] sentences = sntncPattern.split(ln);
	    // Чтобы не потерять знак препинания в конце предложения
	    Matcher pMatcher = sntncPattern.matcher(ln);
	    boolean firstSentence = true; // Пробел перед вторым и последующим предложениями
	    for (var sentence : sentences) {
		String[] words = wordsPattern.split(sentence);
		if (words.length == 0)
		    continue;
		if (firstSentence) {
		    firstSentence = false;
		} else {
		    result += " "; // Пробел перед вторым и последующим предложениями
		}
		// Подсчёт символов в словах так же, как подсчет предложений в абзацах
		IndexedValue[] sc = new IndexedValue[words.length]; 
		for (int i = 0; i < words.length; i++) {
		    sc[i] = new IndexedValue();
		    sc[i].index = i;
		    sc[i].value = words[i].length();
		}
		Arrays.sort(sc);
		boolean firstWord = true;
		for (var c : sc) {
		    // предложение должно начинаться с заглавной буквы
		    if (firstWord) {
			if (c.value == 0)
			    continue; // Пропуск слов с нулевой длиной
			result += Character.toUpperCase(words[c.index].charAt(0));
			result += words[c.index].substring(1);
			firstWord = false;
		    } else { // Пробел между словами
			result += " " + words[c.index];
		    }
		}
		if (pMatcher.find()) { // Знак препинания в конце предложения
		    result += ln.substring(pMatcher.start(), pMatcher.end());
		} else {
		    result += "."; // Если ничего не было - ставим точку
		}
	    }
	    result += "\n";
	}
	return result;
    }

// Сортировка слов в предложениях по убыванию количества вхождений заданного
// символа, а в случае равенства - по алфавиту
    private static String sortBySymbol(String txt, char symbol) {
	String[] lines = linesPattern.split(txt); // Разделение на абзацы
	String result = "";
	for (var ln : lines) {
	    String[] sentences = sntncPattern.split(ln);
	    // Чтобы не потерять знак препинания в конце предложения
	    Matcher pMatcher = sntncPattern.matcher(ln);
	    boolean firstSentence = true; // Пробел перед вторым и последующим предложениями
	    for (var sentence : sentences) {
		String[] words = wordsPattern.split(sentence);
		if (words.length == 0)
		    continue;
		if (firstSentence) {
		    firstSentence = false;
		} else {
		    result += " "; // Пробел перед вторым и последующим предложениями
		}
		// Подсчёт символов в словах 
		// для сортировки создаем объект с двумя полями: 
		// слово (word) и количество символов в нем (value)
		WordSort[] ds = new WordSort[words.length]; 
		for (int i = 0; i < words.length; i++) {
		    ds[i] = new WordSort();
		    ds[i].word = words[i];
		    for (var ch : words[i].toCharArray()) { // Подсчёт вхождений заданного символа
			if (ch == symbol)
			    ds[i].value--; //уменьшаем, чтобы потом отсортировать по возрастанию
		    }
		}
		Arrays.sort(ds);
		boolean firstWord = true;
		for (var c : ds) {
		    if (c.word.isBlank())
			continue; // Пропуск пустых слов
		 // предложение должно начинаться с заглавной буквы
		    if (firstWord) {
			result += Character.toUpperCase(c.word.charAt(0));
			result += c.word.substring(1);
			firstWord = false;
		    } else { // Пробел между словами
			result += " " + c.word;
		    }
		}
		if (pMatcher.find()) { // Знак препинания в конце предложения
		    result += ln.substring(pMatcher.start(), pMatcher.end());
		} else {
		    result += "."; // Если ничего не было - ставим точку
		}
	    }
	    result += "\n";
	}
	return result;
    }
}


 // Класс для сортировки предложений и по заданным параметрам 
class IndexedValue implements Comparable<IndexedValue> {
    public int index;
    public int value;

    @Override
    public int compareTo(IndexedValue that) {
	return this.value - that.value;
    }
}

//Класс для сортировки слов по количеству символов
class WordSort implements Comparable<WordSort> {
    public int value;
    public String word;
    
//сравниваем по количеству символов, если одинаковое, сравниваем слова по алфавиту
    
    @Override
    public int compareTo(WordSort that) {
	if (this.value == that.value) {
	    return this.word.compareToIgnoreCase(that.word);
	} else {
	    return this.value - that.value;
	}
    }
}

