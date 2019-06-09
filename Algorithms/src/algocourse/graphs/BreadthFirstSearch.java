package algocourse.graphs;

import java.util.*;

public class BreadthFirstSearch {
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

        edges.put(7, new ArrayList<>(Arrays.asList(8, 9)));
        edges.put(8, new ArrayList<>(Arrays.asList(7, 9)));
        edges.put(9, new ArrayList<>(Arrays.asList(7, 8)));

        visited = new boolean[edges.keySet().size()];
    }

    public static void main(String[] args) {
        int connected = 0;
        for (int node: edges.keySet()) {

            if (!visited[node]) {
                System.out.println("Connected component found (" + ++connected + ")");
                System.out.print("Values for component " + connected + ": ");
                BFS(node);
                System.out.println();
                System.out.println();
            }
//            visited = new boolean[edges.keySet().size()];
        }
    }

    private static void BFS(int node) {

        if (visited[node]) return;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            Integer currentNode = queue.poll();
            System.out.print(currentNode + " ");
            for (Integer child: edges.get(currentNode)) {
                if (!visited[child]) {
                    queue.add(child);
                    visited[child] = true;
                }
            }
        }
    }
}
