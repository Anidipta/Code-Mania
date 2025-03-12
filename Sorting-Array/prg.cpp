#include <iostream>
#include <vector>
#include <cstdlib>
#include <ctime>

using namespace std;

int comparisons = 0;

void printArray(vector<int>& arr) {
    for (int num : arr) cout << num << " ";
    cout << "\nComparisons: " << comparisons << "\n";
}

void bubbleSort(vector<int>& arr) {
    comparisons = 0;
    int n = arr.size();
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            comparisons++;
            if (arr[j] > arr[j + 1]) swap(arr[j], arr[j + 1]);
        }
    }
    printArray(arr);
}

void insertionSort(vector<int>& arr) {
    comparisons = 0;
    int n = arr.size();
    for (int i = 1; i < n; i++) {
        int key = arr[i], j = i - 1;
        while (j >= 0 && arr[j] > key) {
            comparisons++;
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
    printArray(arr);
}

void selectionSort(vector<int>& arr) {
    comparisons = 0;
    int n = arr.size();
    for (int i = 0; i < n - 1; i++) {
        int minIdx = i;
        for (int j = i + 1; j < n; j++) {
            comparisons++;
            if (arr[j] < arr[minIdx]) minIdx = j;
        }
        swap(arr[i], arr[minIdx]);
    }
    printArray(arr);
}

void quickSort(vector<int>& arr, int low, int high) {
    if (low < high) {
        int pivot = arr[high], i = low - 1;
        for (int j = low; j < high; j++) {
            comparisons++;
            if (arr[j] < pivot) swap(arr[++i], arr[j]);
        }
        swap(arr[i + 1], arr[high]);
        quickSort(arr, low, i);
        quickSort(arr, i + 2, high);
    }
}

void heapify(vector<int>& arr, int n, int i) {
    int largest = i, left = 2 * i + 1, right = 2 * i + 2;
    if (left < n && arr[left] > arr[largest]) largest = left;
    if (right < n && arr[right] > arr[largest]) largest = right;
    if (largest != i) {
        comparisons++;
        swap(arr[i], arr[largest]);
        heapify(arr, n, largest);
    }
}

void heapSort(vector<int>& arr) {
    comparisons = 0;
    int n = arr.size();
    for (int i = n / 2 - 1; i >= 0; i--) heapify(arr, n, i);
    for (int i = n - 1; i > 0; i--) {
        swap(arr[0], arr[i]);
        heapify(arr, i, 0);
    }
    printArray(arr);
}

void merge(vector<int>& arr, int l, int m, int r) {
    int n1 = m - l + 1, n2 = r - m;
    vector<int> L(arr.begin() + l, arr.begin() + m + 1);
    vector<int> R(arr.begin() + m + 1, arr.begin() + r + 1);

    int i = 0, j = 0, k = l;
    while (i < n1 && j < n2) {
        comparisons++;
        arr[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
    }
    while (i < n1) arr[k++] = L[i++];
    while (j < n2) arr[k++] = R[j++];
}

void mergeSort(vector<int>& arr, int l, int r) {
    if (l < r) {
        int m = l + (r - l) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        merge(arr, l, m, r);
    }
}

void cocktailSort(vector<int>& arr) {
    comparisons = 0;
    bool swapped = true;
    int start = 0, end = arr.size() - 1;

    while (swapped) {
        swapped = false;
        for (int i = start; i < end; i++) {
            comparisons++;
            if (arr[i] > arr[i + 1]) {
                swap(arr[i], arr[i + 1]);
                swapped = true;
            }
        }
        if (!swapped) break;
        swapped = false;
        end--;
        for (int i = end - 1; i >= start; i--) {
            comparisons++;
            if (arr[i] > arr[i + 1]) {
                swap(arr[i], arr[i + 1]);
                swapped = true;
            }
        }
        start++;
    }
    printArray(arr);
}

int main() {
    vector<int> arr = {34, 7, 23, 32, 5, 62};
    int choice;
    
    do {
        cout << "\n1. Bubble Sort\n2. Insertion Sort\n3. Selection Sort\n4. Quick Sort\n5. Heap Sort\n6. Merge Sort\n7. Cocktail Sort\n8. Exit\n";
        cout << "Enter choice: ";
        cin >> choice;
        vector<int> copy = arr;

        switch (choice) {
            case 1: bubbleSort(copy); break;
            case 2: insertionSort(copy); break;
            case 3: selectionSort(copy); break;
            case 4: comparisons = 0; quickSort(copy, 0, copy.size() - 1); printArray(copy); break;
            case 5: heapSort(copy); break;
            case 6: comparisons = 0; mergeSort(copy, 0, copy.size() - 1); printArray(copy); break;
            case 7: cocktailSort(copy); break;
            case 8: break;
            default: cout << "Invalid choice!\n";
        }
    } while (choice != 8);

    return 0;
}
