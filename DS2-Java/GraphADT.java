import java.util.*;

public class GraphADT {

    static Scanner sc = new Scanner(System.in);

    // BFS using adjacency matrix
    static void bfsMatrix(int[][] graph, int start, int n) {
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        visited[start] = true;
        q.add(start);

        System.out.print("BFS Traversal: ");

        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");

            for (int i = 0; i < n; i++) {
                if (graph[node][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
        System.out.println();
    }

    // DFS using adjacency matrix
    static void dfsMatrix(int[][] graph, boolean[] visited, int node, int n) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int i = 0; i < n; i++) {
            if (graph[node][i] == 1 && !visited[i]) {
                dfsMatrix(graph, visited, i, n);
            }
        }
    }

    // BFS using adjacency list
    static void bfsList(ArrayList<ArrayList<Integer>> graph, int start) {
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> q = new LinkedList<>();

        visited[start] = true;
        q.add(start);

        System.out.print("BFS Traversal: ");

        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");

            for (int adj : graph.get(node)) {
                if (!visited[adj]) {
                    visited[adj] = true;
                    q.add(adj);
                }
            }
        }
        System.out.println();
    }

    // DFS using adjacency list
    static void dfsList(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int node) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int adj : graph.get(node)) {
            if (!visited[adj]) {
                dfsList(graph, visited, adj);
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("1. Graph using Adjacency Matrix");
        System.out.println("2. Graph using Adjacency List");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        switch (choice) {

            case 1 -> {
                int[][] graph = new int[n][n];

                System.out.println("Enter adjacency matrix:");
                System.out.println("(You can enter like 0110 OR 0 1 1 0)");

                for (int i = 0; i < n; i++) {
                    String row = sc.next();

                    if (row.length() == n) {
                        for (int j = 0; j < n; j++) {
                            graph[i][j] = row.charAt(j) - '0';
                        }
                    } else {
                        graph[i][0] = Integer.parseInt(row);
                        for (int j = 1; j < n; j++) {
                            graph[i][j] = sc.nextInt();
                        }
                    }
                }

                System.out.print("Enter starting vertex: ");
                int start = sc.nextInt();

                bfsMatrix(graph, start, n);

                boolean[] visited = new boolean[n];
                System.out.print("DFS Traversal: ");
                dfsMatrix(graph, visited, start, n);
            }

            case 2 -> {
                ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    graph.add(new ArrayList<>());
                }

                System.out.print("Enter number of edges: ");
                int edges = sc.nextInt();

                System.out.println("Enter edges (u v):");
                for (int i = 0; i < edges; i++) {
                    int u = sc.nextInt();
                    int v = sc.nextInt();

                    graph.get(u).add(v);
                    graph.get(v).add(u);
                }

                System.out.print("Enter starting vertex: ");
                int start = sc.nextInt();

                bfsList(graph, start);

                boolean[] visited = new boolean[n];
                System.out.print("DFS Traversal: ");
                dfsList(graph, visited, start);
            }

            default -> System.out.println("Invalid choice!");
        }
    }
}