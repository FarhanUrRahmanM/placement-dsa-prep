import java.util.*;

class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int area = 0;

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        Set<String> corners = new HashSet<>();

        for (int[] r : rectangles) {
            int x1 = r[0], y1 = r[1];
            int x2 = r[2], y2 = r[3];

            area += (x2 - x1) * (y2 - y1);

            minX = Math.min(minX, x1);
            minY = Math.min(minY, y1);
            maxX = Math.max(maxX, x2);
            maxY = Math.max(maxY, y2);

            String[] points = {
                x1 + "," + y1,
                x1 + "," + y2,
                x2 + "," + y1,
                x2 + "," + y2
            };

            for (String p : points) {
                if (!corners.add(p)) {
                    corners.remove(p);
                }
            }
        }

        int expectedArea = (maxX - minX) * (maxY - minY);

        if (area != expectedArea) {
            return false;
        }

        Set<String> expectedCorners = new HashSet<>();
        expectedCorners.add(minX + "," + minY);
        expectedCorners.add(minX + "," + maxY);
        expectedCorners.add(maxX + "," + minY);
        expectedCorners.add(maxX + "," + maxY);

        return corners.equals(expectedCorners);
    }
}