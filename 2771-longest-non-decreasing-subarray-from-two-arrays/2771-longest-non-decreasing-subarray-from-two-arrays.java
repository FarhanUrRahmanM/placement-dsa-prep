class Solution {
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int n = nums1.length;

        int dp1 = 1;
        int dp2 = 1;
        int ans = 1;

        for (int i = 1; i < n; i++) {

            int newDp1 = 1;
            int newDp2 = 1;

            // Previous nums1 -> current nums1
            if (nums1[i] >= nums1[i - 1]) {
                newDp1 = Math.max(newDp1, dp1 + 1);
            }

            // Previous nums2 -> current nums1
            if (nums1[i] >= nums2[i - 1]) {
                newDp1 = Math.max(newDp1, dp2 + 1);
            }

            // Previous nums1 -> current nums2
            if (nums2[i] >= nums1[i - 1]) {
                newDp2 = Math.max(newDp2, dp1 + 1);
            }

            // Previous nums2 -> current nums2
            if (nums2[i] >= nums2[i - 1]) {
                newDp2 = Math.max(newDp2, dp2 + 1);
            }

            dp1 = newDp1;
            dp2 = newDp2;

            ans = Math.max(ans, Math.max(dp1, dp2));
        }

        return ans;
    }
}