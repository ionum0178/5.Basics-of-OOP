package by.javalearning.homework.theme5;

import java.io.FileNotFoundException;

/*
 * 5. Basics of OOP.
 * Задача 1. Создать объект класса Текстовый файл, используя классы Файл, Директория. Методы: создать, переименовать, 
 * вывести на консоль содержимое, дополнить, удалить.
 */

public class Main {

    static FileLogic fileLog= new FileLogic();
    static DirectoryLogic dirLog = new DirectoryLogic();
    static FileLogic txt;

    @SuppressWarnings("unused")
    public static void main(String[] args) {
	
	//корневая директория
	Directory root;
	root = dirLog.newDirectory("root");
	
	//создаем другие директории в корневой директории
	Directory dir1, dir2, dir3, dir4;
	dir1 = dirLog.newDirectory("dir1", root);
	dir2 = dirLog.newDirectory("dir2", root);
	dir3 = dirLog.newDirectory("dir3", root);
	dir4 = dirLog.newDirectory("dir4", root);
	
	//выводим содержимое корневого каталога
	System.out.println("Выводим содержимое корневого каталога"); 
	System.out.println(root.toString());
	
	// создаем простые файлы
	AFile file1, file2, file3, file4, txt_file;
	file1 = fileLog.newFile("file1", root);
	file2 = fileLog.newFile("file2", dir1);
	file3 = fileLog.newFile("file3", root);
	file4 = fileLog.newFile("file4", dir3);
	System.out.println("Файлы созданы");
	
	// создаем текстовый файл
	txt_file = fileLog.newFile("txt_file","Новый текст", root);
	System.out.println("Текстовый файл создан");
	
	//выводим содержимое каталогов
	System.out.println("Выводим содержимое всех каталогов");
	System.out.println(root.toString());
	System.out.println(dir1.toString());
	System.out.println(dir2.toString());
	System.out.println(dir3.toString());
	System.out.println(dir4.toString());
	
	//переименование (обычный файл)
	fileLog.renameFile(file2, "file2_renamed");
	System.out.println("Файл file2 переименован. Выводим содержимое калатога");
	System.out.println(dir1.toString());
	
	//переименование (текстовый файл)
	fileLog.renameFile(txt_file, "txt_file_renamed");
	System.out.println("Файл txt_file переименован. Выводим содержимое калатога");
	System.out.println(root.toString());
	
	//вывести текстовый файл на консоль
	System.out.println("Выводим текстовый файл txt_file на консоль");
	System.out.println(((TextFile) txt_file).getText().toString());
	
	//добавить текст в файл
	System.out.println("Добавляем текст в файл txt_file");
	try {
	    ((TextFile) txt_file).setText(((TextFile) txt_file).getText() +"\n" +  fileLog.getText());
	} catch (FileNotFoundException e1) {
	    e1.printStackTrace();
	}
	System.out.println("Текст добавлен. Вывод на экран:");
	System.out.println(((TextFile) txt_file).getText().toString());
	
	//удалить директорию, удалить файл
	System.out.println("Удаляем директорию dir4, удаляем файл file1");
	dirLog.deleteDirectory(dir4);
	fileLog.deleteFile(file1);
	System.out.println("Удалено. Вывод на экран");
	System.out.println(root.toString());
	

	
    }
    
    
}
