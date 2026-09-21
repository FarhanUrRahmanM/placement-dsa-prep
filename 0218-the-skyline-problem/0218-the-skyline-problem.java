import java.util.*;

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {

        List<int[]> events = new ArrayList<>();

        // Create start and end events
        for (int[] b : buildings) {
            int left = b[0];
            int right = b[1];
            int height = b[2];

            // Start event: negative height
            events.add(new int[]{left, -height, right});

            // End event: positive height
            events.add(new int[]{right, height, 0});
        }

        // Sort events
        Collections.sort(events, (a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);

            return Integer.compare(a[1], b[1]);
        });

        // Max heap: {height, right}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0], a[0])
        );

        List<List<Integer>> result = new ArrayList<>();

        int prevHeight = 0;

        for (int[] event : events) {

            int x = event[0];
            int height = event[1];

            if (height < 0) {
                // Building starts
                pq.offer(new int[]{-height, event[2]});
            } else {
                // Building ends
                pq.offer(new int[]{0, x});
            }

            // Remove buildings which ended
            while (!pq.isEmpty() && pq.peek()[1] <= x) {
                pq.poll();
            }

            int currentHeight = pq.isEmpty() ? 0 : pq.peek()[0];

            // Height changed
            if (currentHeight != prevHeight) {
                result.add(Arrays.asList(x, currentHeight));
                prevHeight = currentHeight;
            }
        }

        return result;
    }
}