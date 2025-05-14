package main
import ("fmt"; "os"; "strconv"; "bufio"; "strings")
const INF = 1e9
func main() {
    f, _ := os.Open("graph.txt")
    sc := bufio.NewScanner(f)
    sc.Scan(); parts := strings.Fields(sc.Text())
    n, _ := strconv.Atoi(parts[0])
    d := make([][]int, n); nxt := make([][]int, n)
    for i := range d {
        d[i] = make([]int, n); nxt[i] = make([]int, n)
        for j := range d[i] {
            if i == j { d[i][j] = 0 } else { d[i][j] = INF }
        }
    }
    for sc.Scan() {
        p := strings.Fields(sc.Text())
        u, _ := strconv.Atoi(p[0])
        v, _ := strconv.Atoi(p[1])
        w, _ := strconv.Atoi(p[2])
        d[u][v] = w; nxt[u][v] = v
    }
    for k := 0; k < n; k++ {
        for i := 0; i < n; i++ {
            for j := 0; j < n; j++ {
                if d[i][k]+d[k][j] < d[i][j] {
                    d[i][j] = d[i][k] + d[k][j]; nxt[i][j] = nxt[i][k]
                }
            }
        }
    }
    for i := 0; i < n; i++ {
        for j := 0; j < n; j++ {
            if d[i][j] < INF {
                fmt.Printf("From %d to %d: Cost=%d Path=%d", i, j, d[i][j], i)
                u := i; for u != j { u = nxt[u][j]; fmt.Printf(" -> %d", u) }
                fmt.Println()
            }
        }
    }
}
