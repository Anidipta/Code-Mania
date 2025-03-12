import java.util.Random
import java.util.Scanner

fun bubbleSort(arr: IntArray): Int {
    var comparisons = 0
    for (i in arr.indices) {
        for (j in 0 until arr.size - i - 1) {
            comparisons++
            if (arr[j] > arr[j + 1]) {
                arr[j] = arr[j + 1].also { arr[j + 1] = arr[j] }
            }
        }
    }
    return comparisons
}

fun insertionSort(arr: IntArray): Int {
    var comparisons = 0
    for (i in 1 until arr.size) {
        val key = arr[i]
        var j = i - 1
        while (j >= 0 && arr[j] > key) {
            comparisons++
            arr[j + 1] = arr[j]
            j--
        }
        arr[j + 1] = key
    }
    return comparisons
}

fun selectionSort(arr: IntArray): Int {
    var comparisons = 0
    for (i in arr.indices) {
        var minIdx = i
        for (j in i + 1 until arr.size) {
            comparisons++
            if (arr[j] < arr[minIdx]) minIdx = j
        }
        arr[i] = arr[minIdx].also { arr[minIdx] = arr[i] }
    }
    return comparisons
}

fun quickSort(arr: IntArray, low: Int, high: Int, comparisons: Int): Int {
    if (low < high) {
        val pi = partition(arr, low, high, comparisons)
        quickSort(arr, low, pi - 1, comparisons)
        quickSort(arr, pi + 1, high, comparisons)
    }
    return comparisons
}

fun partition(arr: IntArray, low: Int, high: Int, comparisons: Int): Int {
    val pivot = arr[high]
    var i = low - 1
    for (j in low until high) {
        comparisons++
        if (arr[j] < pivot) {
            i++
            arr[i] = arr[j].also { arr[j] = arr[i] }
        }
    }
    arr[i + 1] = arr[high].also { arr[high] = arr[i + 1] }
    return i + 1
}

fun main() {
    val scanner = Scanner(System.`in`)
    val random = Random()
    val inorder = IntArray(10) { it + 1 }
    val reversed = IntArray(10) { 10 - it }
    val randomArr = IntArray(10) { random.nextInt(100) }

    println("1. Inorder: ${inorder.joinToString()}\n2. Reversed: ${reversed.joinToString()}\n3. Random: ${randomArr.joinToString()}")

    while (true) {
        println("Choose Sorting: 1.Bubble 2.Insertion 3.Selection 4.Quick 5.Exit")
        when (scanner.nextInt()) {
            1 -> println("Comparisons: ${bubbleSort(inorder.copyOf())}")
            2 -> println("Comparisons: ${insertionSort(reversed.copyOf())}")
            3 -> println("Comparisons: ${selectionSort(randomArr.copyOf())}")
            4 -> println("Comparisons: ${quickSort(randomArr.copyOf(), 0, 9, 0)}")
            5 -> return
        }
    }
}
