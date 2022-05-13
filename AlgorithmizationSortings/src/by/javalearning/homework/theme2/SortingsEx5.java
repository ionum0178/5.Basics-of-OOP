package by.javalearning.homework.theme2;

import java.util.Scanner;

//2.Algorithmisation
//Одномерные массивы. Сортировки
//Задача 5. Сортировка вставками. Дана последовательность чисел a1, a2,..., an.   
//Требуется переставить числа в порядке возрастания. Делается это следующим образом. 
//Пусть a1, a2,..., ai - упорядоченная последовательность, т. е. a1<=a2<=...<=ai. 
//Берется следующее число ai+1 и вставляется в последовательность так, чтобы новая 
//последовательность была тоже возрастающей. Процесс производится до тех пор, пока все элементы 
//от i+1 до n не будут перебраны. 
//Примечание. Место помещения очередного элемента в отсортированную часть производить
//с помощью двоичного поиска. Двоичный поиск оформить в виде отдельной функции.

public class SortingsEx5 {

    public static int[] arrFill(int n) {
        @SuppressWarnings("resource")
	Scanner in = new Scanner(System.in);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Введите элемент [" + (i + 1) + "]: ");
            arr[i] = in.nextInt();
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите длину последовательности:");
        System.out.print("N=");
        int n = in.nextInt();
        if (n <= 0) {
            System.out.println("Размер последовательности не может быть нулевым или отрицательным!");
            System.exit(1);
        }
        System.out.println("Введите последовательность:");
        int ar[] = new int[n];
        ar = arrFill(n);

        // до сортировки
        for (int a : ar)
            System.out.print(a + "\t");
        System.out.println();

        // сортировка вставками
        int val;
        for (int i = 1; i < ar.length; i++) {
            int position = binFindPlace(ar, i); // двоичный поиск
            val = ar[i];
            for (int j = i; j > position; j--) {
                ar[j] = ar[j - 1];
            }
            ar[position] = val;
        }
        // после сортировки
        for (int a : ar)
            System.out.print(a + "\t");
        System.out.println();
        
        in.close();
    }

    // двоичный поиск
    public static int binFindPlace(int arr[], int rng) { // от 0 до rng - отсортированная часть массива
        int hfr = rng / 2;
        int pos = hfr;
        while (hfr > 1) {
            hfr = hfr / 2;
            if (arr[rng] < arr[pos])
                pos -= hfr;
            else
                pos += hfr;
        }
        // при целочисленном делении пополам могут попадать два элемента на одну и ту же
        // позицию
        // проверяем и смещаем в нужную сторону
        while ((arr[rng] < arr[pos]) && (pos > 0))
            pos--;
        while ((arr[rng] >= arr[pos]) && (pos < rng))
            pos++;
        return pos;
    }
}
