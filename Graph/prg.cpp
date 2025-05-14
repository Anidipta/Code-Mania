#include <iostream>
#include <fstream>
#include <vector>
using namespace std;
const int INF = 1e9;
int main() {
    ifstream in("graph.txt");
    int n, m; in >> n >> m;
    vector<vector<int>> d(n, vector<int>(n, INF)), nxt(n, vector<int>(n));
    for (int i = 0; i < n; ++i) d[i][i] = 0;
    for (int i = 0, u, v, w; i < m; ++i) {
        in >> u >> v >> w; d[u][v] = w; nxt[u][v] = v;
    }
    for (int k = 0; k < n; ++k) for (int i = 0; i < n; ++i) for (int j = 0; j < n; ++j)
        if (d[i][k] + d[k][j] < d[i][j]) { d[i][j] = d[i][k] + d[k][j]; nxt[i][j] = nxt[i][k]; }
    for (int i = 0; i < n; ++i) for (int j = 0; j < n; ++j) if (d[i][j] < INF) {
        cout << "From " << i << " to " << j << ": Cost=" << d[i][j] << " Path=" << i;
        for (int u = i; u != j; u = nxt[u][j]) cout << " -> " << nxt[u][j];
        cout << endl;
    }
}
