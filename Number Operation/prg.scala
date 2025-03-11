object LogicalBinaryOps extends App {
    val a = scala.io.StdIn.readInt()
    val b = scala.io.StdIn.readInt()

    println(s"AND: ${a & b}")
    println(s"OR: ${a | b}")
    println(s"XOR: ${a ^ b}")
    println(s"NOT A: ${~a}")
    println(s"Left Shift: ${a << 1}")
    println(s"Right Shift: ${a >> 1}")

    val x = scala.io.StdIn.readBoolean()
    val y = scala.io.StdIn.readBoolean()
    println(s"Logical AND: ${x && y}")
    println(s"Logical OR: ${x || y}")
    println(s"Logical NOT X: ${!x}")
}
