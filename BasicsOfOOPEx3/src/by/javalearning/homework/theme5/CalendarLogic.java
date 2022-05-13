package by.javalearning.homework.theme5;

import java.util.ArrayList;
import java.util.List;

import by.javalearning.homework.theme5.Calendar.Day;
import by.javalearning.homework.theme5.Calendar.Month;

public class CalendarLogic {

    @SuppressWarnings("unused")
    private Calendar calendar;
    private Month january, february;

    private List<Month> months = new ArrayList<Month>();
    private List<Day> days = new ArrayList<Day>();
    
    public CalendarLogic() {
    }

    public CalendarLogic(Calendar calendar) {
	this.calendar = calendar;
    }

    public void makeNewCalendar(Calendar calendar) {

	// ������ (31 ����)
	for (int i = 0; i < 30; i++) {
	    days.add(calendar.new Day());
	    days.get(i).setDayOfMonth(i + 1);
	    days.get(i).setHoliday(false);
	}

	// ��������� ��� ������ � ��������
	int i = 1; //���� ������
	for (int j = 0; j < days.size(); j++) {
	    days.get(j).setWeekDay(i);
	    if (i < 6)
		days.get(j).setDayOff(false);
	    else
		days.get(j).setDayOff(true);
	    i++;
	    if (i == 8)
		i = 1;
	}

	// ���������� ���������
	days.get(0).setHoliday(true); // 1 ������
	days.get(6).setHoliday(true); // 7 ������

	// ������
	List<Day> daysCopy1 = new ArrayList<Day>(days);
	january = calendar.new Month("������", daysCopy1);

	months.add(january);

	// �������� ����� ���� ������ 31 ������
	i = days.get(days.size()-1).getWeekDay();

	days.clear();

	// ������� (28 ����)
	for (int j = 0; j < 27; j++) {
	    days.add(calendar.new Day());
	    days.get(j).setDayOfMonth(j + 1);
	    days.get(j).setHoliday(false);
	}

	// ��������� ��� ������ � ��������
	for (int j = 0; j < days.size(); j++) {
	    days.get(j).setWeekDay(i);
	    if (i < 6)
		days.get(j).setDayOff(false);
	    else
		days.get(j).setDayOff(true);
	    i++;
	    if (i == 8)
		i = 1;
	}

	// ���������� ���������
	days.get(13).setHoliday(true); // 14 �������
	days.get(22).setHoliday(true); // 23 �������

	// �������
	List<Day> daysCopy2 = new ArrayList<Day>(days);
	february = calendar.new Month("�������", daysCopy2);

	months.add(february);
	
	//��������� � ���������
	calendar.setMonths(months);

    }

    public String getWeekDay(int dayOfWeek) {
	switch (dayOfWeek) {
	case 1:
	    return "�����������";
	case 2:
	    return "�������";
	case 3:
	    return "�����";
	case 4:
	    return "�������";
	case 5:
	    return "�������";
	case 6:
	    return "�������";
	case 7:
	    return "�����������";
	default:
	    return "Not Available";
	}

    }

}
