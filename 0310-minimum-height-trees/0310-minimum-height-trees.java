import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();

        if (n == 1) {
            result.add(0);
            return result;
        }

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] degree = new int[n];

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);

            degree[u]++;
            degree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        // Add all leaf nodes
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }

        int remaining = n;

        while (remaining > 2) {
            int size = queue.size();
            remaining -= size;

            for (int i = 0; i < size; i++) {
                int node = queue.poll();

                for (int neighbor : graph.get(node)) {
                    degree[neighbor]--;

                    if (degree[neighbor] == 1) {
                        queue.offer(neighbor);
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }

        return result;
    }
}