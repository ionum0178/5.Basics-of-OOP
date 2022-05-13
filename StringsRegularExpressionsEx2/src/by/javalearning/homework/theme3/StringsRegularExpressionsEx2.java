package by.javalearning.homework.theme3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 3.Strings and basics of text processing
 * Работа со строкой как с объектом типа String или StringBuilder.
 * Задача 2. Напишите анализатор, позволяющий последовательно возвращать 
 * содержимое узлов xml-документа и его тип  (открывающий тег, 
 * закрывающий  тег, содержимое тега, тег без тела). Пользоваться готовыми 
 * парсерами XML для решения данной задачи нельзя. 
 */

public class StringsRegularExpressionsEx2 {
    static String fileName = "./src/resource/xml.xml";
    static final String XML_TAG_PATTERN = "<(\\s*[^/]+?)>|</(.+?)>|<([^/]+?)/>";

    public static void main(String[] args) throws IOException {
	Pattern tag_search = Pattern.compile(XML_TAG_PATTERN);
	String xml_doc = readFile(fileName).strip(); // читаем из файла, удаляем ненужные пробелы
	Matcher matcher = tag_search.matcher(xml_doc);
	int pos = 0; // Позиция поиска в строке
	while (matcher.find()) { // Пока есть теги
	    if (pos > 0) { // Содержимое строки до первого тега отбрасывается
		// Содержимое тега
		String tag = xml_doc.substring(pos, matcher.start());
		if (!tag.isBlank()) {
		    tag = tag.replaceAll("\\s+", " ");
		    System.out.println("Содержимое тега: " + tag);
		}
	    }
	    pos = matcher.end();
	    if (matcher.group(1) != null) {
		System.out.print("Открывающий тег: ");
	    } else if (matcher.group(2) != null) {
		System.out.print("Закрывающий тег: ");
	    } else {
		System.out.print("Тег без тела: ");
	    }
	    System.out.println(matcher.group(0).replaceAll("\\s+", " "));
	}
    }

    // Чтение файла
    @SuppressWarnings("resource")
    static String readFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = reader.readLine();
        String xml_text = "";
        while (line != null) {
            xml_text += line + "\n";
            line = reader.readLine();
        }
        return xml_text;
    }

}
