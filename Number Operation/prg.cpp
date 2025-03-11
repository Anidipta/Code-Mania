#include <iostream>
using namespace std;

int main() {
    int a, b;
    cin >> a >> b;

    cout << "AND: " << (a & b) << endl;
    cout << "OR: " << (a | b) << endl;
    cout << "XOR: " << (a ^ b) << endl;
    cout << "NOT A: " << (~a) << endl;
    cout << "Left Shift: " << (a << 1) << endl;
    cout << "Right Shift: " << (a >> 1) << endl;

    bool x, y;
    cin >> x >> y;
    cout << "Logical AND: " << (x && y) << endl;
    cout << "Logical OR: " << (x || y) << endl;
    cout << "Logical NOT X: " << (!x) << endl;

    return 0;
}
