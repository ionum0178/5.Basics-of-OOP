package by.javalearning.homework.theme5;

/*
 * ������ 3. ������� ����� ��������� � ���������� �������, � ������� �������� 
 * �������� ����� ������� ���������� � �������� � ����������� ����.
 */

public class Main {

    public static void main(String[] args) {

	Calendar calendar = new Calendar();
	CalendarLogic calLog = new CalendarLogic(calendar);

	// ��������� ��������� (�� 2 ������)
	calLog.makeNewCalendar(calendar);

	// ������� ��� ����������
	System.out.println(calendar.toString());

    }

 
}
