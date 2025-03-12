import scala.io.StdIn.readInt

object SortingProgram {
  var comparisons: Int = 0

  def printArray(arr: Array[Int]): Unit = {
    println("Sorted Array: " + arr.mkString(" "))
    println(s"Comparisons: $comparisons\n")
  }

  def bubbleSort(arr: Array[Int]): Unit = {
    comparisons = 0
    val n = arr.length
    for (i <- 0 until n - 1; j <- 0 until n - i - 1) {
      comparisons += 1
      if (arr(j) > arr(j + 1)) {
        val temp = arr(j)
        arr(j) = arr(j + 1)
        arr(j + 1) = temp
      }
    }
    printArray(arr)
  }

  def insertionSort(arr: Array[Int]): Unit = {
    comparisons = 0
    for (i <- 1 until arr.length) {
      val key = arr(i)
      var j = i - 1
      while (j >= 0 && arr(j) > key) {
        comparisons += 1
        arr(j + 1) = arr(j)
        j -= 1
      }
      arr(j + 1) = key
    }
    printArray(arr)
  }

  def selectionSort(arr: Array[Int]): Unit = {
    comparisons = 0
    for (i <- 0 until arr.length - 1) {
      var minIdx = i
      for (j <- i + 1 until arr.length) {
        comparisons += 1
        if (arr(j) < arr(minIdx)) minIdx = j
      }
      val temp = arr(i)
      arr(i) = arr(minIdx)
      arr(minIdx) = temp
    }
    printArray(arr)
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(34, 7, 23, 32, 5, 62)
    var choice = 0

    while (choice != 4) {
      println("\n1. Bubble Sort\n2. Insertion Sort\n3. Selection Sort\n4. Exit")
      print("Enter choice: ")
      choice = readInt()

      val copyArr = arr.clone()

      choice match {
        case 1 => bubbleSort(copyArr)
        case 2 => insertionSort(copyArr)
        case 3 => selectionSort(copyArr)
        case 4 => println("Exiting...")
        case _ => println("Invalid choice!")
      }
    }
  }
}
