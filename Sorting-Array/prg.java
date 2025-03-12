import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortingMenu {
    static int comparisons = 0;

    public static void bubbleSort(int[] arr) {
        comparisons = 0;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                comparisons++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        printResult(arr);
    }

    public static void insertionSort(int[] arr) {
        comparisons = 0;
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i], j = i - 1;
            while (j >= 0 && arr[j] > key) {
                comparisons++;
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        printResult(arr);
    }

    public static void selectionSort(int[] arr) {
        comparisons = 0;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                comparisons++;
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
        printResult(arr);
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high], i = low - 1;
        for (int j = low; j < high; j++) {
            comparisons++;
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void heapSort(int[] arr) {
        comparisons = 0;
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
        printResult(arr);
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i, left = 2 * i + 1, right = 2 * i + 2;
        if (left < n && arr[left] > arr[largest]) largest = left;
        if (right < n && arr[right] > arr[largest]) largest = right;

        if (largest != i) {
            comparisons++;
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1, n2 = r - m;
        int[] L = Arrays.copyOfRange(arr, l, m + 1);
        int[] R = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            comparisons++;
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    public static void cocktailSort(int[] arr) {
        comparisons = 0;
        boolean swapped = true;
        int start = 0, end = arr.length - 1;

        while (swapped) {
            swapped = false;
            for (int i = start; i < end; i++) {
                comparisons++;
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
            swapped = false;
            end--;
            for (int i = end - 1; i >= start; i--) {
                comparisons++;
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
            start++;
        }
        printResult(arr);
    }

    public static void printResult(int[] arr) {
        System.out.println("Sorted Array: " + Arrays.toString(arr));
        System.out.println("Comparisons: " + comparisons);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int[] inorder = new int[10], reversed = new int[10], randomArr = new int[10];
        for (int i = 0; i < 10; i++) {
            inorder[i] = i + 1;
            reversed[i] = 10 - i;
            randomArr[i] = random.nextInt(100);
        }

        System.out.println("1. Inorder: " + Arrays.toString(inorder));
        System.out.println("2. Reversed: " + Arrays.toString(reversed));
        System.out.println("3. Random: " + Arrays.toString(randomArr));

        while (true) {
            System.out.println("\nChoose Sorting Algorithm:");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Insertion Sort");
            System.out.println("3. Selection Sort");
            System.out.println("4. Quick Sort");
            System.out.println("5. Heap Sort");
            System.out.println("6. Merge Sort");
            System.out.println("7. Cocktail Sort");
            System.out.println("8. Exit");
            int choice = scanner.nextInt();
            if (choice == 8) break;

            System.out.println("Choose Array Type:");
            System.out.println("1. Inorder");
            System.out.println("2. Reversed");
            System.out.println("3. Random");
            int type = scanner.nextInt();

            int[] arr = type == 1 ? inorder.clone() : type == 2 ? reversed.clone() : randomArr.clone();

            switch (choice) {
                case 1 -> bubbleSort(arr);
                case 2 -> insertionSort(arr);
                case 3 -> selectionSort(arr);
                case 4 -> {
                    comparisons = 0;
                    quickSort(arr, 0, arr.length - 1);
                    printResult(arr);
                }
                case 5 -> heapSort(arr);
                case 6 -> {
                    comparisons = 0;
                    mergeSort(arr, 0, arr.length - 1);
                    printResult(arr);
                }
                case 7 -> cocktailSort(arr);
                default -> System.out.println("Invalid Choice!");
            }
        }
        scanner.close();
    }
}
