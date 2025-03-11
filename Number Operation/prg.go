package main

import "fmt"

func main() {
    var a, b int
    fmt.Scan(&a, &b)

    fmt.Println("AND:", a&b)
    fmt.Println("OR:", a|b)
    fmt.Println("XOR:", a^b)
    fmt.Println("NOT A:", ^a)
    fmt.Println("Left Shift:", a<<1)
    fmt.Println("Right Shift:", a>>1)

    var x, y bool
    fmt.Scan(&x, &y)
    fmt.Println("Logical AND:", x && y)
    fmt.Println("Logical OR:", x || y)
    fmt.Println("Logical NOT X:", !x)
}
