import java.util.*;
class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;

        int[] temp = nums.clone();
        Arrays.sort(temp);

        int mid = (n - 1) / 2;
        int end = n - 1;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = temp[mid--];
            } else {
                nums[i] = temp[end--];
            }
        }
    }
}