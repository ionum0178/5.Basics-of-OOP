package by.javalearning.homework.theme4;

/* 
 * 4. Programming with classes
 * Простейшие классы и объекты.
 * Задача 6. Составьте описание класса для представления времени. Предусмотрите
 * возможности установки времени и изменения его отдельных полей (час, минута, 
 * секунда) с проверкой допустимости вводимых значений. В случае недопустимых 
 * значений полей поле устанавливается в значение 0. Создать методы изменения  
 * времени на заданное количество часов, минут и секунд.
 */

public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
	this.setHours(hours);
	this.setMinutes(minutes);
	this.setSeconds(seconds);
    }

    public int getHours() {
	return hours;
    }

    public void setHours(int hours) {
	this.hours = hours;
    }

    public int getSeconds() {
	return seconds;
    }

    public void setSeconds(int seconds) {
	this.seconds = seconds;
    }

    public int getMinutes() {
	return minutes;
    }

    public void setMinutes(int minutes) {
	this.minutes = minutes;
    }

    public String toString() {
	return ("Время на часах: " + getHours() + ":" + getMinutes() + ":" + getSeconds());
    }

}
