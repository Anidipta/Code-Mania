using System; using System.IO;
class Program {
    const int INF = 1000000;
    static void Main() {
        var lines = File.ReadAllLines("graph.txt");
        var t = lines[0].Split(' '); int n = int.Parse(t[0]);
        int[,] d = new int[n,n], nxt = new int[n,n];
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) d[i,j] = i == j ? 0 : INF;
        for (int i = 1; i < lines.Length; i++) {
            var p = lines[i].Split(' '); int u = int.Parse(p[0]), v = int.Parse(p[1]), w = int.Parse(p[2]);
            d[u,v] = w; nxt[u,v] = v;
        }
        for (int k = 0; k < n; k++) for (int i = 0; i < n; i++) for (int j = 0; j < n; j++)
            if (d[i,k] + d[k,j] < d[i,j]) { d[i,j] = d[i,k] + d[k,j]; nxt[i,j] = nxt[i,k]; }
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) if (d[i,j] < INF) {
            Console.Write($"From {i} to {j}: Cost={d[i,j]} Path={i}");
            for (int u = i; u != j; u = nxt[u,j]) Console.Write(" -> " + nxt[u,j]);
            Console.WriteLine();
        }
    }
}
