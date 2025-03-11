using System;

class Program {
    static void LinearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.Length; i++)
            if (arr[i] == key) {
                Console.WriteLine("Found at index " + i);
                return;
            }
        Console.WriteLine("Not found");
    }

    static void BubbleSort(int[] arr) {
        int n = arr.Length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
        Console.WriteLine("Sorted Array: " + string.Join(", ", arr));
    }

    static int InterpolationSearch(int[] arr, int key) {
        int low = 0, high = arr.Length - 1;
        while (low <= high && key >= arr[low] && key <= arr[high]) {
            int pos = low + ((key - arr[low]) * (high - low) / (arr[high] - arr[low]));
            if (arr[pos] == key) return pos;
            if (arr[pos] < key) low = pos + 1;
            else high = pos - 1;
        }
        return -1;
    }

    static void Main() {
        int[] arr = { 10, 20, 30, 40, 50 };
        while (true) {
            Console.WriteLine("1. Linear Search\n2. Bubble Sort\n3. Interpolation Search\n4. Exit");
            int choice = int.Parse(Console.ReadLine());
            if (choice == 4) break;

            if (choice == 1 || choice == 3) {
                Console.Write("Enter key to search: ");
                int key = int.Parse(Console.ReadLine());
                if (choice == 1) LinearSearch(arr, key);
                else Console.WriteLine("Found at index: " + InterpolationSearch(arr, key));
            } else if (choice == 2) {
                BubbleSort(arr);
            }
        }
    }
}
