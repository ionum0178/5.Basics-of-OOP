package by.javalearning.homework.theme4;

import java.util.Arrays;
import java.util.Objects;

public class Student {

    private String surname;
    private String initials;
    private int group;
    private int[] performance = new int[5];

    public Student(String surname, String initials, int group, int[] performance) {
	this.surname = surname;
	this.initials = initials;
	this.group = group;
	this.performance = performance;
    }

    public String getSurname() {
	return surname;
    }

    public String getInitials() {
	return initials;
    }

    public int getGroup() {
	return group;
    }

    public int[] getPerformance() {
	return performance;
    }

    public void setSurname(String surname) {
	this.surname = surname;
    }

    public void setInitials(String initials) {
	this.initials = initials;
    }

    public void setGroup(int group) {
	this.group = group;
    }

    public void setPerformance(int[] performance) {
	this.performance = performance;
    }

    public String toString() {
	String string = "";
	string += getSurname() + " " + getInitials() + ", группа " + getGroup() + "\n" + "Оценки: ";
	for (int i : getPerformance()) {
	    string += i + " ";
	}
	string += "\n";
	return string;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + Arrays.hashCode(performance);
	result = prime * result + Objects.hash(group, initials, surname);
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Student other = (Student) obj;
	return group == other.group && Objects.equals(initials, other.initials)
		&& Arrays.equals(performance, other.performance) && Objects.equals(surname, other.surname);
    }
    
    
}
