import java.util.Scanner;

public class PrimsMST {

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

            primMST(graph, vertices);
        }
    }

    public static void primMST(int[][] graph, int vertices) {
        boolean[] visited = new boolean[vertices];
        visited[0] = true;

        int totalCost = 0;

        System.out.println("\nEdges selected in MST:");

        for (int edgeCount = 0; edgeCount < vertices - 1; edgeCount++) {
            int min = Integer.MAX_VALUE;
            int x = 0, y = 0;

            for (int i = 0; i < vertices; i++) {
                if (visited[i]) {
                    for (int j = 0; j < vertices; j++) {
                        if (!visited[j] && graph[i][j] != 0 && graph[i][j] < min) {
                            min = graph[i][j];
                            x = i;
                            y = j;
                        }
                    }
                }
            }

            System.out.println(x + " - " + y + " : " + graph[x][y]);
            totalCost += graph[x][y];
            visited[y] = true;
        }

        System.out.println("Total Cost = " + totalCost);
    }
}