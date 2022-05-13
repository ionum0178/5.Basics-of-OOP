package by.javalearning.homework.theme4;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/* 
 * 4. Programming with classes
 * Простейшие классы и объекты.
 * Задача 4. Создайте класс Train, содержащий поля: название пункта назначения,
 * номер поезда, время отправления. Создайте данные в массив из пяти элементов 
 * типа Train, добавьте возможность сортировки элементов массива по номерам 
 * поездов. Добавьте возможность вывода информации о поезде, номер которого 
 * введен пользователем. Добавьте возможность сортировки массива по пункту 
 * назначения, причем поезда с одинаковыми пунктами назначения должны быть 
 * упорядочены по времени отправления.
 */

public class Main {
    
    static Train[] t={
        new Train("Варшава", 131, LocalTime.of(11, 55)),
        new Train("Варшава", 241, LocalTime.of(10, 20)),
        new Train("Вильнюс", 333, LocalTime.of(13, 45)),
        new Train("Москва", 171, LocalTime.of(22, 55)),
        new Train("Владивосток", 221, LocalTime.of(9, 30)),
	};
    
   public static void main(String[] args) {
       startMenu();
   }
   
   public static void startMenu() {
	Scanner sc = new Scanner(System.in);
    	int i=0;
    	while (i!=5) {
    	    i=0;
    	    System.out.println("Вы на вокзале.");    	    
            System.out.println("1-Вывести все поезда на экран");
            System.out.println("2-Отсортировать поезда по пункту назначения и вывести на экран");
            System.out.println("3-Отсортировать поезда по номерам и вывести на экран");
            System.out.println("4-Вывести данные по номеру поезда на экран");            
            System.out.println("5-Завершить программу");
            if (sc.hasNextInt()) {
        	i = sc.nextInt();
            } else {
        	System.out.println("Попробуйте еще раз!");
        	break;
            }
            if(i==1) {
        	printTrains();
        	}            
            if(i==2) {
        	sortByDestinationAndTime();
            }
            if(i==3) {
        	sortByNumber();
            }            
            if(i==4) {
        	printCurrentTrain();
            }
            if (i==5) {
        	break;
            } 
       	}
    	sc.close();
   }
    
    public static void printTrains() {
	for(var x: t) {
	    System.out.println(x.toString());  
	}
    }
    public static void printCurrentTrain() {
	Scanner sc = new Scanner(System.in);
	System.out.println("Введите номер поезда:");
	int j = sc.nextInt();
	for(var x: t) {
	    if (x.getTrainNr() == j) {
		System.out.println(x.toString());
	    } 
	}
	sc.close();
    }
    public static void sortByNumber() {
	Arrays.sort(t, Comparator.comparing(Train::getTrainNr));
	for(var x: t) {
	    System.out.println(x.toString());
	} 
    }
    public static void sortByDestinationAndTime() {
       	Arrays.sort(t, Comparator.comparing(Train::getDestination)
       		.thenComparing(Train::getDepart));
	for(var x: t) {
	    System.out.println(x.toString());
	} 
    }
	
}
    
    
    



