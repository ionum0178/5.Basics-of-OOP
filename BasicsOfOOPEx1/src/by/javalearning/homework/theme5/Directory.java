package by.javalearning.homework.theme5;

import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
 * 5. Basics of OOP.
 * Задача 1. Создать объект класса Текстовый файл, используя классы Файл, Директория. Методы: создать, переименовать, 
 * вывести на консоль содержимое, дополнить, удалить.
 */

public class Directory {

    private String name;
    private Directory parent;
    private List<AFile> files;
    private List<Directory> directories;

    public Directory(String name) {
	this.name = name;
	this.parent = null;
	this.files = new ArrayList<AFile>();
	this.directories = new ArrayList<Directory>();
    }
    
    public Directory(String name, Directory parent) {
	this.name = name;
	this.parent = parent;
	this.files = new ArrayList<AFile>();
	this.directories = new ArrayList<Directory>();
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

    public List<AFile> getFiles() {
	return files;
    }

    public List<Directory> getDirectories() {
	return directories;
    }

    public void setName(String name) {
	this.name = name;
    }

    public void setFiles(List<AFile> files) {
	this.files = files;
    }

    public void setDirectories(List<Directory> directories) {
	this.directories = directories;
    }

    @Override
    public int hashCode() {
	return Objects.hash(directories, files, name, parent);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Directory other = (Directory) obj;
	return Objects.equals(directories, other.directories) && Objects.equals(files, other.files)
		&& Objects.equals(name, other.name) && Objects.equals(parent, other.parent);
    }

    @Override
    public String toString() {
	String str;
	str = "Directory " + name;
	if (files != null) {
	    str += "\nfiles: \n";
	for (AFile f : files) {
		if(f!=null) str += "\t" + f.getName() + "\n";
	    }
	}
	if (directories != null) {
	    str += "\ndirectories: \n";
	    for (Directory d : directories) {
		if(d!=null) str += "\t" +d.getName() + "\n";
	    }
	}
	return str;
    }

}
