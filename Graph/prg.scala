import scala.io.Source
object Main extends App {
  val lines = Source.fromFile("graph.txt").getLines().toList
  val Array(n, _) = lines.head.split(" ").map(_.toInt)
  val INF = 1e9.toInt
  val d = Array.fill(n, n)(INF); val nxt = Array.ofDim[Int](n, n)
  for (i <- 0 until n) d(i)(i) = 0
  for (line <- lines.tail) {
    val Array(u, v, w) = line.split(" ").map(_.toInt)
    d(u)(v) = w; nxt(u)(v) = v
  }
  for (k <- 0 until n; i <- 0 until n; j <- 0 until n)
    if (d(i)(k) + d(k)(j) < d(i)(j)) { d(i)(j) = d(i)(k) + d(k)(j); nxt(i)(j) = nxt(i)(k) }
  for (i <- 0 until n; j <- 0 until n if d(i)(j) < INF) {
    print(s"From $i to $j: Cost=${d(i)(j)} Path=$i")
    var u = i; while (u != j) { u = nxt(u)(j); print(s" -> $u") }
    println()
  }
}