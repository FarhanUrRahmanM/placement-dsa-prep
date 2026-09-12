class Solution {
    public int distinctSubseqII(String s) {
        long MOD = 1000000007;
        long[] dp = new long[26];
        long total = 0;

        for (char c : s.toCharArray()) {
            int x = c - 'a';

            long add = (total + 1) % MOD;

            total = (total + add - dp[x] + MOD) % MOD;

            dp[x] = add;
        }

        return (int) total;
    }
}