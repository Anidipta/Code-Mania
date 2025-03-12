package main

import (
	"fmt"
)

var comparisons int

func printArray(arr []int) {
	fmt.Println("Sorted Array:", arr)
	fmt.Println("Comparisons:", comparisons)
}

func bubbleSort(arr []int) {
	comparisons = 0
	n := len(arr)
	for i := 0; i < n-1; i++ {
		for j := 0; j < n-i-1; j++ {
			comparisons++
			if arr[j] > arr[j+1] {
				arr[j], arr[j+1] = arr[j+1], arr[j]
			}
		}
	}
	printArray(arr)
}

func insertionSort(arr []int) {
	comparisons = 0
	n := len(arr)
	for i := 1; i < n; i++ {
		key := arr[i]
		j := i - 1
		for j >= 0 && arr[j] > key {
			comparisons++
			arr[j+1] = arr[j]
			j--
		}
		arr[j+1] = key
	}
	printArray(arr)
}

func selectionSort(arr []int) {
	comparisons = 0
	n := len(arr)
	for i := 0; i < n-1; i++ {
		minIdx := i
		for j := i + 1; j < n; j++ {
			comparisons++
			if arr[j] < arr[minIdx] {
				minIdx = j
			}
		}
		arr[i], arr[minIdx] = arr[minIdx], arr[i]
	}
	printArray(arr)
}

func main() {
	arr := []int{34, 7, 23, 32, 5, 62}
	var choice int

	for {
		fmt.Println("\n1. Bubble Sort\n2. Insertion Sort\n3. Selection Sort\n4. Exit")
		fmt.Print("Enter choice: ")
		fmt.Scan(&choice)

		copyArr := make([]int, len(arr))
		copy(copyArr, arr)

		switch choice {
		case 1:
			bubbleSort(copyArr)
		case 2:
			insertionSort(copyArr)
		case 3:
			selectionSort(copyArr)
		case 4:
			return
		default:
			fmt.Println("Invalid choice!")
		}
	}
}
