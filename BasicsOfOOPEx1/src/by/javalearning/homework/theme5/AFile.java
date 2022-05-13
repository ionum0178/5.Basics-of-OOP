package by.javalearning.homework.theme5;

import java.util.Objects;

/*
 * 5. Basics of OOP.
 * Задача 1. Создать объект класса Текстовый файл, используя классы Файл, Директория. Методы: создать, переименовать, 
 * вывести на консоль содержимое, дополнить, удалить.
 */

public class AFile {
    
    private String name;
    private Directory parent;
    
    public AFile(String name, Directory parent) {
	this.name = name;
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

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
	return Objects.hash(name, parent);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	AFile other = (AFile) obj;
	return Objects.equals(name, other.name) && Objects.equals(parent, other.parent);
    }

    @Override
    public String toString() {
	return "Filename: " + name + "\n";
    }
    
}
