import java.util.Scanner;
public class DijkstraAlgo {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter number of vertices: ");
            int vertices = sc.nextInt();
            int[][] graph = new int[vertices][vertices];
            System.out.println("Enter adjacency matrix:");
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    graph[i][j] = sc.nextInt();
                }
            }
            System.out.print("Enter source vertex: ");
            int source = sc.nextInt();
            dijkstra(graph, vertices, source);
        }
    }
    public static void dijkstra(int[][] graph, int vertices, int source) {
        int[] distance = new int[vertices];
        boolean[] visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[source] = 0;
        for (int count = 0; count < vertices - 1; count++) {
            int min = Integer.MAX_VALUE;
            int u = -1;
            for (int i = 0; i < vertices; i++) {
                if (!visited[i] && distance[i] < min) {
                    min = distance[i];
                    u = i;
                }
            }
            visited[u] = true;
            for (int v = 0; v < vertices; v++) {
                if (!visited[v] && graph[u][v] != 0 &&
                    distance[u] != Integer.MAX_VALUE &&
                    distance[u] + graph[u][v] < distance[v]) {
                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }
        System.out.println("\nShortest distances from source vertex " + source + ":");
        for (int i = 0; i < vertices; i++) {
            System.out.println("To vertex " + i + " = " + distance[i]);
        }
    }
}
