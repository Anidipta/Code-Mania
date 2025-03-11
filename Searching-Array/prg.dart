import 'dart:io';

void linearSearch(List<int> arr, int key) {
  int index = arr.indexOf(key);
  if (index != -1) {
    print("Found at index $index");
  } else {
    print("Not found");
  }
}

void bubbleSort(List<int> arr) {
  for (int i = 0; i < arr.length - 1; i++) {
    for (int j = 0; j < arr.length - i - 1; j++) {
      if (arr[j] > arr[j + 1]) {
        int temp = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = temp;
      }
    }
  }
  print("Sorted Array: $arr");
}

int interpolationSearch(List<int> arr, int key) {
  int low = 0, high = arr.length - 1;
  while (low <= high && key >= arr[low] && key <= arr[high]) {
    int pos = low + ((key - arr[low]) * (high - low) ~/ (arr[high] - arr[low]));
    if (arr[pos] == key) return pos;
    if (arr[pos] < key) {
      low = pos + 1;
    } else {
      high = pos - 1;
    }
  }
  return -1;
}

void main() {
  List<int> arr = [10, 20, 30, 40, 50];
  while (true) {
    print("1. Linear Search\n2. Bubble Sort\n3. Interpolation Search\n4. Exit");
    int? choice = int.tryParse(stdin.readLineSync()!);
    if (choice == null || choice == 4) break;
    if (choice == 1 || choice == 3) {
      print("Enter key to search: ");
      int? key = int.tryParse(stdin.readLineSync()!);
      if (key == null) continue;
      if (choice == 1) {
        linearSearch(arr, key);
      } else {
        print("Found at index: ${interpolationSearch(arr, key)}");
      }
    } else if (choice == 2) {
      bubbleSort(arr);
    }
  }
}
