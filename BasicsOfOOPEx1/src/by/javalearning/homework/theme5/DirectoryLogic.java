package by.javalearning.homework.theme5;

public class DirectoryLogic {

    public Directory newDirectory(String name) {
	return new Directory(name);
    }
    
    public Directory newDirectory(String name, Directory parent) {
	Directory newDir = new Directory(name, parent);
	addDirectoryTo(newDir, parent);
	return newDir;
    }
    
    public void addDirectoryTo(Directory directory, Directory to) {
	int j=0;
	for(int i=0; i<to.getDirectories().size(); i++) {
	    if(directory.equals(to.getDirectories().get(i))) j+=1;
	}
	if (j==0) to.getDirectories().add(directory); 
    }
    

    public void deleteDirectory (Directory dir) {
	dir.setDirectories(null);
	dir.setFiles(null);
	dir.getParent().getDirectories().remove(dir);
	dir.setParent(null);
	dir.setName(null);
	
    }
    
}
