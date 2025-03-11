package main

import (
	"fmt"
)

func linearSearch(arr []int, key int) {
	for i, v := range arr {
		if v == key {
			fmt.Println("Found at index", i)
			return
		}
	}
	fmt.Println("Not found")
}

func bubbleSort(arr []int) {
	n := len(arr)
	for i := 0; i < n-1; i++ {
		for j := 0; j < n-i-1; j++ {
			if arr[j] > arr[j+1] {
				arr[j], arr[j+1] = arr[j+1], arr[j]
			}
		}
	}
	fmt.Println("Sorted Array:", arr)
}

func interpolationSearch(arr []int, key int) int {
	low, high := 0, len(arr)-1
	for low <= high && key >= arr[low] && key <= arr[high] {
		pos := low + (key-arr[low])*(high-low)/(arr[high]-arr[low])
		if arr[pos] == key {
			return pos
		}
		if arr[pos] < key {
			low = pos + 1
		} else {
			high = pos - 1
		}
	}
	return -1
}

func main() {
	arr := []int{10, 20, 30, 40, 50}
	for {
		fmt.Println("1. Linear Search\n2. Bubble Sort\n3. Interpolation Search\n4. Exit")
		var choice, key int
		fmt.Scan(&choice)
		if choice == 4 {
			break
		}
		if choice == 1 || choice == 3 {
			fmt.Print("Enter key to search: ")
			fmt.Scan(&key)
			if choice == 1 {
				linearSearch(arr, key)
			} else {
				fmt.Println("Found at index:", interpolationSearch(arr, key))
			}
		} else if choice == 2 {
			bubbleSort(arr)
		}
	}
}
