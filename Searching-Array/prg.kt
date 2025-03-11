import java.util.Scanner

fun linearSearch(arr: IntArray, key: Int) {
    val index = arr.indexOf(key)
    if (index != -1) println("Found at index $index") else println("Not found")
}

fun bubbleSort(arr: IntArray) {
    for (i in arr.indices) {
        for (j in 0 until arr.size - i - 1) {
            if (arr[j] > arr[j + 1]) {
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
            }
        }
    }
    println("Sorted Array: ${arr.joinToString()}")
}

fun interpolationSearch(arr: IntArray, key: Int): Int {
    var low = 0
    var high = arr.size - 1
    while (low <= high && key >= arr[low] && key <= arr[high]) {
        val pos = low + ((key - arr[low]) * (high - low) / (arr[high] - arr[low]))
        if (arr[pos] == key) return pos
        if (arr[pos] < key) low = pos + 1 else high = pos - 1
    }
    return -1
}

fun main() {
    val arr = intArrayOf(10, 20, 30, 40, 50)
    val scanner = Scanner(System.`in`)

    while (true) {
        println("1. Linear Search\n2. Bubble Sort\n3. Interpolation Search\n4. Exit")
        when (scanner.nextInt()) {
            1 -> {
                println("Enter key to search: ")
                linearSearch(arr, scanner.nextInt())
            }
            2 -> bubbleSort(arr)
            3 -> {
                println("Enter key to search: ")
                println("Found at index: ${interpolationSearch(arr, scanner.nextInt())}")
            }
            4 -> return
        }
    }
}
