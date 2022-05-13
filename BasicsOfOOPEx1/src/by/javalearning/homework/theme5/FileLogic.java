package by.javalearning.homework.theme5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileLogic {
    
    private File file;
    private StringBuilder txt;
    private Scanner sc;
    
    public AFile newFile(String name, String text, Directory parent) {
	AFile file = new TextFile(name, text, parent);
	addFileTo(file, parent);
	return file;
    }
    
    public AFile newFile(String name, Directory parent) {
	AFile file = new AFile(name, parent);
	addFileTo(file, parent);
	return file;
    }
    
    public void addFileTo(AFile file, Directory to) {
	int j=0;
	for(int i=0; i<to.getFiles().size(); i++) {
	    if(file.equals(to.getFiles().get(i))) j+=1;
	}
	if (j==0) to.getFiles().add(file); 
    }
    
    public void renameFile(AFile file, String new_name) {
	file.setName(new_name);
    }
    
    public void deleteFile(AFile file) {
	file.setName(null);
	file.getParent().getFiles().remove(file);
	file.setParent(null);
    }
    
    public String getText() throws FileNotFoundException{
	file = new File("./src/resource/text.txt");
	txt = new StringBuilder();
	try {
	    sc = new Scanner(file);
	    while (sc.hasNextLine()) {
		txt.append(sc.nextLine()).append("\n");
	    }
	} catch (FileNotFoundException e) {
	throw e;
	}
	return txt.toString();
    }
    
    
}
