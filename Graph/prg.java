// Java (Floyd-Warshall)
import java.io.*;
import java.util.*;
public class FloydWarshallJava {
    static final int INF = 1000000000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("graph.txt"));
        String[] header = br.readLine().split(" ");
        int V = Integer.parseInt(header[0]);
        int[][] dist = new int[V][V], next = new int[V][V];
        for (int i = 0; i < V; i++)
            Arrays.fill(dist[i], INF);
        for (int i = 0; i < V; i++) dist[i][i] = 0;
        String line;
        while ((line = br.readLine()) != null) {
            String[] t = line.split(" ");
            int u = Integer.parseInt(t[0]), v = Integer.parseInt(t[1]), w = Integer.parseInt(t[2]);
            dist[u][v] = w; next[u][v] = v;
        }
        for (int k = 0; k < V; k++)
            for (int i = 0; i < V; i++)
                for (int j = 0; j < V; j++)
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                if (dist[i][j] < INF) {
                    System.out.print(i + " to " + j + " cost=" + dist[i][j] + " path=" + i);
                    for (int u = i; u != j; u = next[u][j])
                        System.out.print("->" + next[u][j]);
                    System.out.println();
                }
    }
}
