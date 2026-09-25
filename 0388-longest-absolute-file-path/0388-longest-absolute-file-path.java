class Solution {
    public int lengthLongestPath(String input) {
        String[] lines = input.split("\n");
        int[] depth = new int[lines.length + 1];
        int max = 0;

        for (String line : lines) {
            int level = 0;

            while (line.charAt(level) == '\t') {
                level++;
            }

            String name = line.substring(level);

            if (name.contains(".")) {
                max = Math.max(max, depth[level] + name.length());
            } else {
                depth[level + 1] = depth[level] + name.length() + 1;
            }
        }

        return max;
    }
}