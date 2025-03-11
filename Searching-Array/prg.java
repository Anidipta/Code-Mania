import java.util.*;

public class SearchSortMenu {
    static void linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) 
            if (arr[i] == key) {
                System.out.println("Found at index " + i);
                return;
            }
        System.out.println("Not found");
    }

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) 
            for (int j = 0; j < n - i - 1; j++) 
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    static int interpolationSearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        while (low <= high && key >= arr[low] && key <= arr[high]) {
            int pos = low + ((key - arr[low]) * (high - low) / (arr[high] - arr[low]));
            if (arr[pos] == key) return pos;
            if (arr[pos] < key) low = pos + 1;
            else high = pos - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {10, 20, 30, 40, 50};

        while (true) {
            System.out.println("1. Linear Search\n2. Bubble Sort\n3. Interpolation Search\n4. Exit");
            int choice = sc.nextInt();
            if (choice == 4) break;

            if (choice == 1 || choice == 3) {
                System.out.print("Enter key to search: ");
                int key = sc.nextInt();
                if (choice == 1) linearSearch(arr, key);
                else System.out.println("Found at index: " + interpolationSearch(arr, key));
            } else if (choice == 2) {
                bubbleSort(arr);
            }
        }
        sc.close();
    }
}
