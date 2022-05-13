package by.javalearning.homework.theme2;

import java.util.Scanner;

//2.Algorithmisation
//Одномерные массивы. Сортировки
//Задача 6. Сортировка Шелла. Дан массив n действительных чисел. Требуется упорядочить его по возрастанию. 
//Делается это следующим образом: сравниваются два соседних элемента ai и ai+1. Если ai<=ai+1, то 
//продвигаются на один элемент вперед. Если ai>ai+1, то производится перестановка и сдвигаются 
//на один элемент назад. Составить алгоритм этой сортировки

public class SortingsEx6 {
    
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

        // сортировка
        int i = 0;
        int val;
        while (i < (ar.length - 1)) {
            if (ar[i] <= ar[i + 1])
                i++;
            else {
                val = ar[i];
                ar[i] = ar[i + 1];
                ar[i + 1] = val;
                i--;
                if (i < 0)
                    i = 0;
            }
        }
        // после сортировки
        for (int a : ar)
            System.out.print(a + "\t");
        System.out.println();
        
        in.close();
    }
}
