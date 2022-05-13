package by.javalearning.homework.theme2;

import static java.lang.Math.*;

//2.Algorithmisation
//Массивы массивов
//Задача 11. Матрицу 10x20 заполнить случайными числами от 0 до 15. Вывести на экран 
//саму матрицу и номера строк, в которых число 5 встречается три и более раз.

public class MatricesEx11 {
    public static void main(String[] args) {

	int[][] arr = new int[10][20];
	for (int i = 0; i < 10; i++) {
	    for (int j = 0; j < 20; j++) {
		arr[i][j] = (int) round(15 * random());
	    }
	}
	for (int i = 0; i < 10; i++) {
	    for (int j = 0; j < 20; j++)
		System.out.print(arr[i][j] + " ");
	    System.out.println();
	}
	System.out.println("Число 5 встречается 3 и более раз в строках с номерами: ");
	int q = 0;
	for (int i = 0; i < 10; i++) {
	    for (int j = 0; j < 20; j++) {
		if (arr[i][j] == 5)
		    q++;
	    }
	    if (q >= 3)
		System.out.print((i + 1) + " ");
	    q = 0;
	}
    }
}
