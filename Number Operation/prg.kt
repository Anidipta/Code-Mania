fun main() {
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()

    println("AND: ${a and b}")
    println("OR: ${a or b}")
    println("XOR: ${a xor b}")
    println("NOT A: ${a.inv()}")
    println("Left Shift: ${a shl 1}")
    println("Right Shift: ${a shr 1}")

    val x = readLine()!!.toBoolean()
    val y = readLine()!!.toBoolean()
    println("Logical AND: ${x && y}")
    println("Logical OR: ${x || y}")
    println("Logical NOT X: ${!x}")
}
