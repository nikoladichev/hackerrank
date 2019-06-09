package algocourse.graphs;

import java.util.*;

public class DepthFirstSearch {


    private static final Map<Integer, List<Integer>> edges = new HashMap<>();
    private static boolean[] visited;
    static {
        edges.put(0, new ArrayList<>(Arrays.asList(3, 6)));
        edges.put(1, new ArrayList<>(Arrays.asList(2, 3, 4, 5 ,6)));
        edges.put(2, new ArrayList<>(Arrays.asList(1, 4, 5)));
        edges.put(3, new ArrayList<>(Arrays.asList(0, 1, 5)));
        edges.put(4, new ArrayList<>(Arrays.asList(1, 2, 6)));
        edges.put(5, new ArrayList<>(Arrays.asList(1, 2, 3)));
        edges.put(6, new ArrayList<>(Arrays.asList(0, 1, 4)));

        visited = new boolean[edges.keySet().size()];
    }

    public static void main(String[] args) {
        for (int node: edges.keySet()) {
            System.out.print("Values for " + node + ": ");
            DFS(node);
            visited = new boolean[edges.keySet().size()];
            System.out.println();
        }
    }

    private static void DFS(int node) {

        if (!visited[node]) {
            visited[node] = true;
            for (Integer child: edges.get(node)) {
                DFS(child);
            }

            System.out.print(node + " ");
        }
    }
}
