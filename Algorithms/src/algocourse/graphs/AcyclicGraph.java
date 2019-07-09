package algocourse.graphs;

import java.util.*;

public class AcyclicGraph {

    private static final Map<Integer, List<Integer>> edges = new TreeMap<>();
    private static boolean[] visited;

    public static void main(String[] args) {

        edges.put(1, new ArrayList<>(Arrays.asList(2, 4, 5)));
        edges.put(2, new ArrayList<>(Arrays.asList(1, 3)));
        edges.put(3, new ArrayList<>(Arrays.asList(2, 5)));
        edges.put(4, new ArrayList<>(Arrays.asList(1)));
        edges.put(5, new ArrayList<>(Arrays.asList(1, 3)));

        edges.put(6, new ArrayList<>(Arrays.asList(7, 8)));
        edges.put(7, new ArrayList<>(Arrays.asList(6, 8)));
        edges.put(8, new ArrayList<>(Arrays.asList(6, 7)));

        visited = new boolean[edges.keySet().size()];

        for (int start: edges.keySet()) {
            List<Integer> children = new ArrayList<>(edges.get(start));
            for (int end: children) {
                if (hasPath(start, end)) {
                    edges.get(start).remove((Object) end);
                    System.out.println(start + " - " + end);
                }
            }
        }
    }

    public static boolean hasPath(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!edges.isEmpty()) {

            Integer currentNode = queue.poll();
            System.out.print(currentNode + " ");

            for (Integer child: edges.get(currentNode)) {
                if (!visited[child]) {
                    visited[child] = true;
                    queue.add(child);

                    if (child == end) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
