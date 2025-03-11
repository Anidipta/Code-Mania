import 'dart:io';

void main() {
  int a = int.parse(stdin.readLineSync()!);
  int b = int.parse(stdin.readLineSync()!);

  print("AND: ${a & b}");
  print("OR: ${a | b}");
  print("XOR: ${a ^ b}");
  print("NOT A: ${~a}");
  print("Left Shift: ${a << 1}");
  print("Right Shift: ${a >> 1}");

  bool x = stdin.readLineSync()!.toLowerCase() == 'true';
  bool y = stdin.readLineSync()!.toLowerCase() == 'true';
  print("Logical AND: ${x && y}");
  print("Logical OR: ${x || y}");
  print("Logical NOT X: ${!x}");
}
