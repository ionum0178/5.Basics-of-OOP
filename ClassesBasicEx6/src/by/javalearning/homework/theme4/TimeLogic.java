package by.javalearning.homework.theme4;

import java.util.Scanner;

public class TimeLogic {
    
    Time clock; 
    
    public void setClock() {
	
	clock = new Time(0, 0, 0);
	
	Scanner sc = new Scanner(System.in);
	int i = -1;
	
	while (i != 0) {
	    System.out.println("Установите время на часах:");
	    System.out.println("1-Установить 00:00:00 (по умолчанию)");
	    System.out.println("2-Прибавить секунды");
	    System.out.println("3-Отнять секунды");
	    System.out.println("4-Прибавить минуты");
	    System.out.println("5-Отнять минуты");
	    System.out.println("6-Прибавить часы");
	    System.out.println("7-Отнять часы");
	    System.out.println("8-Ввести собственные значения");
	    System.out.println("9-Вывести время на экран");
	    System.out.println("0-Завершить программу");
	    if (sc.hasNextInt()) {
		i = sc.nextInt();
		sc.nextLine();
	    } else {
		System.out.println("Попробуйте еще раз!");
		System.exit(1);
	    }
	    
	    switch (i) {
	    
	    case 1: {
		setTime(0, 0, 0);
		System.out.println(clock.toString());
		break;
	    }
	    
	    case 2: {
		System.out.println("Сколько секунд нужно прибавить?");
		setTime(clock.getHours(), clock.getMinutes(), (clock.getSeconds() + input()));
		System.out.println(clock.toString());
		break;
	    }
	    
	    case 3: {
		System.out.println("Сколько секунд нужно отнять?");
		setTime(clock.getHours(), clock.getMinutes(), (clock.getSeconds() - input()));
		System.out.println(clock.toString());
		break;
	    }
	    
	    case 4: {
		System.out.println("Сколько минут нужно прибавить?");
		setTime(clock.getHours(), (clock.getMinutes() + input()), clock.getSeconds());
		System.out.println(clock.toString());
		break;
	    }
	    
	    case 5: {
		System.out.println("Сколько минут нужно отнять?");
		setTime(clock.getHours(), (clock.getMinutes() - input()), clock.getSeconds());
		System.out.println(clock.toString());
		break;
	    }
	    
	    case 6: {
		System.out.println("Сколько часов нужно прибавить?");
		setTime((clock.getHours() + input()), clock.getMinutes(), clock.getSeconds());
		System.out.println(clock.toString());
		break;
	    }
	    
	    case 7: {
		System.out.println("Сколько часов нужно отнять?");
		setTime((clock.getHours() - input()), clock.getMinutes(), clock.getSeconds());
		System.out.println(clock.toString());
		break;
	    }
	    
	    case 8: {
		System.out.print("Введите часы: ");
		int hour = input();
		System.out.print("Введите минуты: ");
		int minut = input();
		System.out.print("Введите секунды: ");
		int second = input();
		if (hour < 0 || minut < 0 || minut > 60 || second < 0 || second > 60) {
		    System.out.println("Вы ввели недопустимые значения!");
		    System.out.println("Время будет установлено по умолчанию - 00:00:00");
		    setTime(0, 0, 0);
		    System.out.println(clock.toString());
		} else {
		    setTime(hour, minut, second);
		    System.out.println(clock.toString());
		}
		break;
	    }
	    
	    case 9: {
		System.out.println(clock.toString());
		break;
	    }
	    
	    case 0: {
		sc.close();
		System.exit(1);
		break;
	    }
	    
	    }
	}
    }
   
    public void setTime(int hours, int minutes, int seconds) {
	if (seconds > 59) {
	    minutes += seconds / 60;
	    seconds = seconds % 60;
	}
	if (seconds < 0) {
	    minutes = minutes - 1 + seconds / 60;
	    seconds = seconds % 60 + 60;
	}
	if (minutes > 59) {
	    hours += minutes / 60;
	    minutes = minutes % 60;
	}
	if (minutes < 0) {
	    hours = hours - 1 + minutes / 60;
	    minutes = minutes % 60 + 60;
	}
	if (hours > 23) {
	    hours = hours % 24;
	}
	if (hours < 0) {
	    System.out.println("Время не может быть отрицательным!\n" 
			+ "Значения будут установлены по умолчанию - 00:00:00");
	    hours = 0;
	    minutes = 0;
	    seconds = 0;
	}
	clock.setHours(hours);
	clock.setMinutes(minutes);
	clock.setSeconds(seconds);
    }

    
    private int input() {
	@SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
	int i;
	while (true) {
	    if (sc.hasNextInt()) {
		i = sc.nextInt();
		break;
	    } else
		sc.nextLine();
	}
	return i;
    }


}
