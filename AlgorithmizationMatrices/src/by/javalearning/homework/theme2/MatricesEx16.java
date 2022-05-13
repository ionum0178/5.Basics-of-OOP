package by.javalearning.homework.theme2;

import java.util.Scanner;

//2.Algorithmisation
//Массивы массивов
//Задача 16.Магическим квадратом порядка nназывается квадратнаяматрица размера n x n,
//составленная из чисел 1, 2, 3, ...,n^2 так, что суммы по каждому столбцу, каждой строке 
//и каждой из двух больших диагоналей равны между собой. Построить такой квадрат.

public class MatricesEx16 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер матрицы:");
        System.out.print("N=");
        int n = in.nextInt();
        if (n <= 2) {
            System.out.println("Такой квадрат невозможно построить!");
            System.exit(1);
        }
        if ((n % 2) == 0)
            Even(n); // Четное число элементов, метод построения Рауз-Болла
        else
            Odd(n); // Нечетное число элементов, сиамский метод построения
        in.close();
    }

    public static void Odd(int n) { // Сиамский метод (нечетное N)
        int[][] msq = new int[n][n];
        int x = n / 2;
        int y = msq.length - 1;
        int q = 1;

        while (true) {
            msq[(msq.length - 1) - y][x] = q;
            q++;
            if (x == msq.length - 1)
                x = -1;
            if (y >= msq.length - 1)
                y = -1;
            y++;
            x++;
            if (msq[msq.length - 1 - y][x] != 0)
                y--;
            int c = 0;
            for (int[] arr : msq) {
                for (int a : arr) {
                    if (a == 0)
                        c++;
                }
            }
            if (c == 0)
                break;
        }
        PrintMsq(msq);
    }

    public static void Even(int n) { // Метод Рауз-Болла (четное N)
        int[][] msq = MsqFill(n); // Для реализации метода нужна матрица, заполненная по порядку

        // Перестановка элементов главной диагонали
        int q = 0;
        for (int i = 0; i < msq.length / 2; i++) {
            int t;
            if (i < msq.length / 2) {
                t = msq[i][i];
                msq[i][i] = msq[msq.length - 1 - q][msq.length - 1 - q];
                msq[msq.length - 1 - q][msq.length - 1 - q] = t;
                q++;
            }
        }
        // Перестановка элементов побочной диагонали
        q = 0;
        for (int i = 0; i < msq.length / 2; i++) {
            int t;
            if (i < msq.length / 2) {
                t = msq[msq.length - 1 - q][i];
                msq[msq.length - 1 - q][i] = msq[i][msq.length - 1 - q];
                msq[i][msq.length - 1 - q] = t;
                q++;
            }
        }
        PrintMsq(msq);
    }

    public static int[][] MsqFill(int n) { // Заполнение матрицы по порядку
        int[][] msq = new int[n][n];
        int q = 1;
        for (int i = 0; i < msq.length; i++) {
            for (int j = 0; j < msq.length; j++) {
                msq[i][j] = q;
                q++;
            }
        }
        return msq;
    }

    public static void PrintMsq(int msq[][]) { // Вывод матрицы
        for (int[] arr : msq) {
            for (int a : arr) {
                System.out.print(a + "\t");
            }
            System.out.println();
        }
        System.out.println("");
    }
}
