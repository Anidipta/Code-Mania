#include <iostream>
#include <vector>
using namespace std;

int main() {
    vector<int> arr = {1, 2, 3, 4, 5};
    cout << "Array: ";
    for (int num : arr) cout << num << " ";
    cout << endl;

    string s;
    getline(cin, s);
    cout << "String: " << s << endl;

    return 0;
}
