package by.javalearning.homework.theme5;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Calendar {

    private List<Month> months = new ArrayList<Month>();
    
    public Calendar() {
    }
    
    public Calendar(List<Month> months) {
	this.months = months;
    }

    public List<Month> getMonths() {
	return months;
    }

    public void setMonths(List<Month> months) {
	this.months = months;
    }

    @Override
    public int hashCode() {
	return Objects.hash(months);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Calendar other = (Calendar) obj;
	return Objects.equals(months, other.months);
    }

    @Override
    public String toString() {
	String str="";
	str += "Календарь.\n";
	for(Month m : months) {
	    str += m.toString();
	}
	return str + "\n";
    }

    public class Month {

	private String name;
	private List<Day> days = new ArrayList<Day>();

	public Month(String name, List<Day> days) {
	    this.name = name;
	    this.days = days;
	}

	public List<Day> getDays() {
	    return days;
	}

	public void setDays(List<Day> days) {
	    this.days = days;
	}

	public String getName() {
	    return name;
	}

	public void setName(String name) {
	    this.name = name;
	}

	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + getEnclosingInstance().hashCode();
	    result = prime * result + Objects.hash(days, name);
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
	    Month other = (Month) obj;
	    if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
		return false;
	    return Objects.equals(days, other.days) && Objects.equals(name, other.name);
	}

	private Calendar getEnclosingInstance() {
	    return Calendar.this;
	}

	@Override
	public String toString() {
	    String str="";
	    str += "Месяц " + name + ":\n";
	    for(Day d : days) {
		    str += d.toString();
		}
	    return str + "\n";
	}
    }

    public class Day {

	private int dayOfMonth;
	private int weekDay;
	private boolean dayOff;
	private boolean holiday;
	
	private CalendarLogic calLog = new CalendarLogic();
	
	public Day(){
	}

	public Day(int dayOfMonth, int weekDay, boolean dayOff, boolean holiday) {
	    this.dayOfMonth = dayOfMonth;
	    this.weekDay = weekDay;
	    this.dayOff = dayOff;
	    this.holiday = holiday;
	}

	public int getDayOfMonth() {
	    return dayOfMonth;
	}

	public int getWeekDay() {
	    return weekDay;
	}

	public boolean isDayOff() {
	    return dayOff;
	}

	public boolean isHoliday() {
	    return holiday;
	}

	public void setDayOfMonth(int dayOfMonth) {
	    this.dayOfMonth = dayOfMonth;
	}

	public void setWeekDay(int weekDay) {
	    this.weekDay = weekDay;
	}

	public void setDayOff(boolean dayOff) {
	    this.dayOff = dayOff;
	}

	public void setHoliday(boolean holiday) {
	    this.holiday = holiday;
	}

	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + getEnclosingInstance().hashCode();
	    result = prime * result + Objects.hash(dayOfMonth, dayOff, holiday, weekDay);
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
	    Day other = (Day) obj;
	    if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
		return false;
	    return dayOfMonth == other.dayOfMonth && dayOff == other.dayOff && holiday == other.holiday
		    && weekDay == other.weekDay;
	}

	private Calendar getEnclosingInstance() {
	    return Calendar.this;
	}

	@Override
	public String toString() {
	    String str="";
	    str+= dayOfMonth + " число: " + calLog.getWeekDay(weekDay) + ", ";
	    if (dayOff&&!holiday) str += "выходной день\n";
	    if (holiday) str += "праздничный день\n";
	    if (!dayOff&&!holiday) str += "будний день\n";
	    return str;
	}

    }
}
