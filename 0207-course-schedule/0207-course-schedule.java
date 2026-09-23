class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] p : prerequisites) {
            int course = p[0];
            int prerequisite = p[1];

            graph[prerequisite].add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++;

            for (int next : graph[current]) {
                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        return count == numCourses;
    }
}