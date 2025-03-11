#include <iostream>
using namespace std;

void linearSearch(int arr[], int size, int key) {
    for (int i = 0; i < size; i++)
        if (arr[i] == key) {
            cout << "Found at index " << i << endl;
            return;
        }
    cout << "Not found" << endl;
}

void bubbleSort(int arr[], int size) {
    for (int i = 0; i < size - 1; i++)
        for (int j = 0; j < size - i - 1; j++)
            if (arr[j] > arr[j + 1])
                swap(arr[j], arr[j + 1]);
    cout << "Sorted Array: ";
    for (int i = 0; i < size; i++) cout << arr[i] << " ";
    cout << endl;
}

int interpolationSearch(int arr[], int size, int key) {
    int low = 0, high = size - 1;
    while (low <= high && key >= arr[low] && key <= arr[high]) {
        int pos = low + ((key - arr[low]) * (high - low) / (arr[high] - arr[low]));
        if (arr[pos] == key) return pos;
        if (arr[pos] < key) low = pos + 1;
        else high = pos - 1;
    }
    return -1;
}

int main() {
    int arr[] = {10, 20, 30, 40, 50};
    int size = sizeof(arr) / sizeof(arr[0]);
    int choice, key;

    while (true) {
        cout << "1. Linear Search\n2. Bubble Sort\n3. Interpolation Search\n4. Exit\n";
        cin >> choice;
        if (choice == 4) break;

        if (choice == 1 || choice == 3) {
            cout << "Enter key to search: ";
            cin >> key;
            if (choice == 1) linearSearch(arr, size, key);
            else cout << "Found at index: " << interpolationSearch(arr, size, key) << endl;
        } else if (choice == 2) {
            bubbleSort(arr, size);
        }
    }
    return 0;
}
