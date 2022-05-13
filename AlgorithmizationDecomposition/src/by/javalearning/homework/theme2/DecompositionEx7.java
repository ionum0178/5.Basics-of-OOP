package by.javalearning.homework.theme2;

//2.Algorithmisation
//Декомпозиция с использованием методов (подпрограммы).
//Задача 7. Написать метод (методы) для вычисления суммы факториалов всех нечетных чисел от 1 до 9.

public class DecompositionEx7 {

    public static void main(String[] args) {
	System.out.println("Сумма факториалов нечетных чисел от 1 до 9 равна " + factorialSum(9));
    }

    static int factorialSum(int a) {
	int f = 1;
	int fSum = 1;
	for (int i = 2; i <= a; i++) {
	    f *= i;
	    if (i % 2 == 1)
		fSum += f;
	}
	return fSum;
    }
}
