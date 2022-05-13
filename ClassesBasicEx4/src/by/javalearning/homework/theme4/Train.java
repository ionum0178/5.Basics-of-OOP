package by.javalearning.homework.theme4;
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

import java.time.LocalTime;

public class Train {
    
    private String destination;
    private int trainNr;
    private LocalTime depart;

    public Train(String destination, int trainNr, LocalTime depart) {
	this.destination = destination;
	this.trainNr = trainNr;
	this.depart = depart;
    }

    public String getDestination() {
        return destination;
    }

    public int getTrainNr() {
        return trainNr;
    }

    public LocalTime getDepart() {
        return depart;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setTrainNr(int trainNr) {
        this.trainNr = trainNr;
    }

    public void setDepart(LocalTime depart) {
        this.depart = depart;
    }

    public String toString() {
	String string = "";
	string += "Nr " + getTrainNr() + ", пункт назначения " + getDestination() + ", отправление в " + getDepart()
		+ "\n";
	return string;
    }
}