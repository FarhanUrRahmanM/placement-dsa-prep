import java.util.*;

class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int ans = Integer.MIN_VALUE;
        if (rows > cols) {
            int[][] temp = new int[cols][rows];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    temp[j][i] = matrix[i][j];
                }
            }
            matrix = temp;
            rows = matrix.length;
            cols = matrix[0].length;
        }
        for (int left = 0; left < cols; left++) {
            int[] rowSum = new int[rows];
            for (int right = left; right < cols; right++) {
                for (int r = 0; r < rows; r++) {
                    rowSum[r] += matrix[r][right];
                }
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                int prefix = 0;
                for (int sum : rowSum) {
                    prefix += sum;
                    Integer value = set.ceiling(prefix - k);
                    if (value != null) {
                        ans = Math.max(ans, prefix - value);
                    }
                    set.add(prefix);
                }
            }
        }
        return ans;
    }
}