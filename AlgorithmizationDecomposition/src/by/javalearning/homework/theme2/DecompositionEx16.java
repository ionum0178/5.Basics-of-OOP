package by.javalearning.homework.theme2;

import java.util.Scanner;

// 2.Algorithmisation
// Декомпозиция с использованием методов (подпрограммы).
// Задача 16. Написать программу, определяющую сумму n-значных чисел, содержащих 
// только нечетные цифры. Определить также, сколько четных цифр в найденной сумме.
// Для решения задачи использовать декомпозицию.

public class DecompositionEx16 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите N:"); // число разрядов n
        System.out.print("N=");
        int n = in.nextInt();
        System.out.println("Сумма N-значных чисел с нечетными цифрами равна: " + sumOdd(n));
        System.out.print("Количество четных цифр в найденной сумме равно: " + numEven(sumOdd(n)));
        in.close();
    }

    static int sumOdd(int n) {
        int[] arr = new int[n];
        boolean f = true;
        int sum = 0;
        for (int i = (int) Math.pow(10, (n - 1)); i < (int) Math.pow(10, n); i++) {
            arr = setNumArray(i, n);
            f = true;
            for (int j = 0; j < arr.length; j++) { // проверяем на нечетность каждую цифру в массиве цифр
                f = f && isItOdd(arr[j]);
            }
            if (f)
                sum += i;
        }
        return sum;
    }

    // пробразуем число в массив цифр
    static int[] setNumArray(int x, int n) { // x-число, n-разрядность
        int[] arr = new int[n];
        int i = 1;
        while (x != 0) {
            arr[n - i] = x % 10;
            i++;
            x /= 10;
        }
        return arr;
    }

    static int numEven(int sum) { // сколько четных цифр
        int[] arr = new int[digits(sum)];
        int even = 0;
        boolean f;
        arr = setNumArray(sum, digits(sum));
        for (int j = 0; j < arr.length; j++) { // проверяем на четность каждую цифру в массиве цифр
            f = isItEven(arr[j]);
            if (f)
                even++;
        }
        return even;
    }

    static int digits(int n) { // количество цифр числа
        int rn = 0;
        int nn = n;
        while (nn != 0) {
            rn++;
            nn /= 10;
        }
        return rn;
    }

    static boolean isItOdd(int n) {
        boolean f;
        if (n == 1 || n == 3 || n == 5 || n == 7 || n == 9)
            f = true;
        else
            f = false;
        return f;
    }

    static boolean isItEven(int n) {
        boolean f;
        if (n == 0 || n == 2 || n == 4 || n == 6 || n == 8)
            f = true;
        else
            f = false;
        return f;
    }
}
