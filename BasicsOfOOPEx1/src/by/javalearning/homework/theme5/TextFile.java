package by.javalearning.homework.theme5;

import java.util.Objects;

/*
 * 5. Basics of OOP.
 * Задача 1. Создать объект класса Текстовый файл, используя классы Файл, Директория. Методы: создать, переименовать, 
 * вывести на консоль содержимое, дополнить, удалить.
 */

public class TextFile extends AFile {

    private String name;
    private String text;
    private Directory parent;
    
    public TextFile(String name, String text, Directory parent) {
	super(name, parent);
	this.name = name;
	this.text = text;
	this.parent = parent;
    }

    public Directory getParent() {
        return parent;
    }

    public void setParent(Directory parent) {
        this.parent = parent;
    }

    public String getName() {
	return name;
    }

    public String getText() {
	return text;
    }

    public void setName(String name) {
	this.name = name;
    }

    public void setText(String text) {
	this.text = text;
    }
    
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + Objects.hash(name, parent, text);
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (!super.equals(obj))
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	TextFile other = (TextFile) obj;
	return Objects.equals(name, other.name) && Objects.equals(parent, other.parent)
		&& Objects.equals(text, other.text);
    }

    @Override
    public String toString() {
	return "Filename " + name + "\nсодержимое:\n" + text;
    }

}
