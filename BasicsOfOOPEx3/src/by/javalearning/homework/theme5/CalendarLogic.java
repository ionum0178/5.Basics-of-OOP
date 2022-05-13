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

	// €нварь (31 день)
	for (int i = 0; i < 30; i++) {
	    days.add(calendar.new Day());
	    days.get(i).setDayOfMonth(i + 1);
	    days.get(i).setHoliday(false);
	}

	// добавл€ем дни недели и выходные
	int i = 1; //день недели
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

	// записываем праздники
	days.get(0).setHoliday(true); // 1 €нвар€
	days.get(6).setHoliday(true); // 7 €нвар€

	// €нварь
	List<Day> daysCopy1 = new ArrayList<Day>(days);
	january = calendar.new Month("январь", daysCopy1);

	months.add(january);

	// вы€сн€ем какой день недели 31 €нвар€
	i = days.get(days.size()-1).getWeekDay();

	days.clear();

	// февраль (28 дней)
	for (int j = 0; j < 27; j++) {
	    days.add(calendar.new Day());
	    days.get(j).setDayOfMonth(j + 1);
	    days.get(j).setHoliday(false);
	}

	// добавл€ем дни недели и выходные
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

	// записываем праздники
	days.get(13).setHoliday(true); // 14 феврал€
	days.get(22).setHoliday(true); // 23 феврал€

	// февраль
	List<Day> daysCopy2 = new ArrayList<Day>(days);
	february = calendar.new Month("‘евраль", daysCopy2);

	months.add(february);
	
	//добавл€ем в календарь
	calendar.setMonths(months);

    }

    public String getWeekDay(int dayOfWeek) {
	switch (dayOfWeek) {
	case 1:
	    return "понедельник";
	case 2:
	    return "вторник";
	case 3:
	    return "среда";
	case 4:
	    return "четверг";
	case 5:
	    return "п€тница";
	case 6:
	    return "суббота";
	case 7:
	    return "воскресенье";
	default:
	    return "Not Available";
	}

    }

}
