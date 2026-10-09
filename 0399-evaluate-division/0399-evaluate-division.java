import java.util.*;

class Solution {
    public double[] calcEquation(List<List<String>> equations,
                                 double[] values,
                                 List<List<String>> queries) {

        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());

            graph.get(a).put(b, values[i]);
            graph.get(b).put(a, 1.0 / values[i]);
        }

        double[] answer = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                answer[i] = -1.0;
            } else {
                answer[i] = dfs(graph, start, end, new HashSet<>());
            }
        }

        return answer;
    }

    private double dfs(Map<String, Map<String, Double>> graph,
                       String start,
                       String end,
                       Set<String> visited) {

        if (start.equals(end)) {
            return 1.0;
        }

        visited.add(start);

        for (Map.Entry<String, Double> entry :
                graph.get(start).entrySet()) {

            String next = entry.getKey();
            double value = entry.getValue();

            if (!visited.contains(next)) {
                double result = dfs(graph, next, end, visited);

                if (result != -1.0) {
                    return value * result;
                }
            }
        }

        return -1.0;
    }
}