using System;
using System.Linq;

class SortingProgram {
    static int comparisons = 0;

    static void BubbleSort(int[] arr) {
        comparisons = 0;
        for (int i = 0; i < arr.Length - 1; i++) {
            for (int j = 0; j < arr.Length - i - 1; j++) {
                comparisons++;
                if (arr[j] > arr[j + 1]) (arr[j], arr[j + 1]) = (arr[j + 1], arr[j]);
            }
        }
        PrintArray(arr);
    }

    static void PrintArray(int[] arr) {
        Console.WriteLine($"Sorted Array: {string.Join(" ", arr)}");
        Console.WriteLine($"Comparisons: {comparisons}\n");
    }

    static void Main() {
        int[] arr = { 34, 7, 23, 32, 5, 62 };

        while (true) {
            Console.WriteLine("\n1. Bubble Sort\n2. Exit");
            Console.Write("Enter choice: ");
            int choice = int.Parse(Console.ReadLine());

            int[] copy = (int[])arr.Clone();

            if (choice == 1) BubbleSort(copy);
            else if (choice == 2) break;
            else Console.WriteLine("Invalid choice!");
        }
    }
}
