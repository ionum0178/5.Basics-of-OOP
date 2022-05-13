package by.javalearning.homework.theme4;

public class StudentLogic {

    public boolean isExcelent(Student student) {
	boolean excelence;
	    excelence = true;
	    for (var mark : student.getPerformance()) {
		if (mark < 9)
		    excelence = false;
	    }
	return excelence;
    }
}
