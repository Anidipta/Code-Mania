using System;

class Program {
    static void Main() {
        int a = int.Parse(Console.ReadLine()), b = int.Parse(Console.ReadLine());

        Console.WriteLine("AND: " + (a & b));
        Console.WriteLine("OR: " + (a | b));
        Console.WriteLine("XOR: " + (a ^ b));
        Console.WriteLine("NOT A: " + (~a));
        Console.WriteLine("Left Shift: " + (a << 1));
        Console.WriteLine("Right Shift: " + (a >> 1));

        bool x = bool.Parse(Console.ReadLine()), y = bool.Parse(Console.ReadLine());
        Console.WriteLine("Logical AND: " + (x && y));
        Console.WriteLine("Logical OR: " + (x || y));
        Console.WriteLine("Logical NOT X: " + (!x));
    }
}
