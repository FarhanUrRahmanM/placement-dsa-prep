import java.util.*;

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return new int[0];
        }
        
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];
        
        // Map to group elements by their diagonal identifier (row + col)
        Map<Integer, List<Integer>> diagonals = new HashMap<>();
        
        // Step 1: Group elements by row + col
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int diagonalIndex = i + j;
                diagonals.putIfAbsent(diagonalIndex, new ArrayList<>());
                diagonals.get(diagonalIndex).add(mat[i][j]);
            }
        }
        
        // Step 2: Build the final result array
        int index = 0;
        int numDiagonals = m + n - 1; // Total number of diagonals
        
        for (int d = 0; d < numDiagonals; d++) {
            List<Integer> currentDiagonal = diagonals.get(d);
            
            // If the diagonal index is even, we traverse UP (reverse order)
            if (d % 2 == 0) {
                Collections.reverse(currentDiagonal);
            }
            
            // Add the elements to our flat result array
            for (int num : currentDiagonal) {
                result[index++] = num;
            }
        }
        
        return result;
    }
}
