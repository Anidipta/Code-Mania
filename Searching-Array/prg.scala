import scala.io.StdIn._

object SearchSortMenu {
  def linearSearch(arr: Array[Int], key: Int): Unit = {
    val index = arr.indexOf(key)
    if (index != -1) println(s"Found at index $index")
    else println("Not found")
  }

  def bubbleSort(arr: Array[Int]): Unit = {
    for (i <- arr.indices; j <- 0 until arr.length - i - 1)
      if (arr(j) > arr(j + 1)) {
        val temp = arr(j)
        arr(j) = arr(j + 1)
        arr(j + 1) = temp
      }
    println("Sorted Array: " + arr.mkString(", "))
  }

  def interpolationSearch(arr: Array[Int], key: Int): Int = {
    var low = 0
    var high = arr.length - 1
    while (low <= high && key >= arr(low) && key <= arr(high)) {
      val pos = low + ((key - arr(low)) * (high - low) / (arr(high) - arr(low)))
      if (arr(pos) == key) return pos
      if (arr(pos) < key) low = pos + 1
      else high = pos - 1
    }
    -1
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(10, 20, 30, 40, 50)
    while (true) {
      println("1. Linear Search\n2. Bubble Sort\n3. Interpolation Search\n4. Exit")
      val choice = readInt()
      if (choice == 4) return
      if (choice == 1 || choice == 3) {
        print("Enter key to search: ")
        val key = readInt()
        if (choice == 1) linearSearch(arr, key)
        else println("Found at index: " + interpolationSearch(arr, key))
      } else if (choice == 2) {
        bubbleSort(arr)
      }
    }
  }
}
