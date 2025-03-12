import 'dart:io';
import 'dart:math';

void bubbleSort(List<int> arr) {
  int n = arr.length, comparisons = 0;
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
  print("Sorted Array: $arr, Comparisons: $comparisons");
}

void insertionSort(List<int> arr) {
  int comparisons = 0;
  for (int i = 1; i < arr.length; i++) {
    int key = arr[i], j = i - 1;
    while (j >= 0 && arr[j] > key) {
      comparisons++;
      arr[j + 1] = arr[j];
      j--;
    }
    arr[j + 1] = key;
  }
  print("Sorted Array: $arr, Comparisons: $comparisons");
}

void selectionSort(List<int> arr) {
  int n = arr.length, comparisons = 0;
  for (int i = 0; i < n - 1; i++) {
    int minIdx = i;
    for (int j = i + 1; j < n; j++) {
      comparisons++;
      if (arr[j] < arr[minIdx]) minIdx = j;
    }
    int temp = arr[minIdx];
    arr[minIdx] = arr[i];
    arr[i] = temp;
  }
  print("Sorted Array: $arr, Comparisons: $comparisons");
}

void quickSort(List<int> arr, int low, int high, int comparisons) {
  if (low < high) {
    int pi = partition(arr, low, high, comparisons);
    quickSort(arr, low, pi - 1, comparisons);
    quickSort(arr, pi + 1, high, comparisons);
  }
}

int partition(List<int> arr, int low, int high, int comparisons) {
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

void heapify(List<int> arr, int n, int i, int comparisons) {
  int largest = i, left = 2 * i + 1, right = 2 * i + 2;
  if (left < n && arr[left] > arr[largest]) {
    comparisons++;
    largest = left;
  }
  if (right < n && arr[right] > arr[largest]) {
    comparisons++;
    largest = right;
  }
  if (largest != i) {
    int temp = arr[i];
    arr[i] = arr[largest];
    arr[largest] = temp;
    heapify(arr, n, largest, comparisons);
  }
}

void heapSort(List<int> arr) {
  int n = arr.length, comparisons = 0;
  for (int i = n ~/ 2 - 1; i >= 0; i--) heapify(arr, n, i, comparisons);
  for (int i = n - 1; i > 0; i--) {
    int temp = arr[0];
    arr[0] = arr[i];
    arr[i] = temp;
    heapify(arr, i, 0, comparisons);
  }
  print("Sorted Array: $arr, Comparisons: $comparisons");
}

void generateArrays() {
  List<int> inorder = List.generate(10, (index) => index + 1);
  List<int> reversed = List.generate(10, (index) => 10 - index);
  List<int> randomArr = List.generate(10, (index) => Random().nextInt(100));
  print("1. Inorder: $inorder\n2. Reversed: $reversed\n3. Random: $randomArr");
}

void main() {
  generateArrays();
  while (true) {
    print("Choose Sorting: 1.Bubble 2.Insertion 3.Selection 4.Quick 5.Heap 6.Exit");
    int? choice = int.tryParse(stdin.readLineSync()!);
    if (choice == null || choice == 6) break;
    List<int> arr = [10, 20, 30, 40, 50, 15, 5, 25];
    if (choice == 1) bubbleSort(arr);
    else if (choice == 2) insertionSort(arr);
    else if (choice == 3) selectionSort(arr);
    else if (choice == 4) quickSort(arr, 0, arr.length - 1, 0);
    else if (choice == 5) heapSort(arr);
  }
}
