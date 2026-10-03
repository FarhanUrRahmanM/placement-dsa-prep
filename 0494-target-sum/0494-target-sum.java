class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (Math.abs(target) > sum) {
            return 0;
        }

        int total = sum + target;

        if (total % 2 != 0) {
            return 0;
        }

        int need = total / 2;

        int[] dp = new int[need + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int j = need; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[need];
    }
}