package by.javalearning.homework.theme5;

/*
 * Задача 3. Создать класс Календарь с внутренним классом, с помощью объектов 
 * которого можно хранить информацию о выходных и праздничных днях.
 */

public class Main {

    public static void main(String[] args) {

	Calendar calendar = new Calendar();
	CalendarLogic calLog = new CalendarLogic(calendar);

	// заполняем календарь (на 2 месяца)
	calLog.makeNewCalendar(calendar);

	// выводим всю информацию
	System.out.println(calendar.toString());

    }

 
}
