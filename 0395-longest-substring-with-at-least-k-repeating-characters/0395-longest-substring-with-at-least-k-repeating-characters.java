class Solution {
    public int longestSubstring(String s, int k) {
        return solve(s, 0, s.length() - 1, k);
    }

    private int solve(String s, int left, int right, int k) {

        if (right - left + 1 < k) {
            return 0;
        }

        int[] freq = new int[26];

        for (int i = left; i <= right; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // Find a character that occurs less than k times
        for (int i = left; i <= right; i++) {

            if (freq[s.charAt(i) - 'a'] < k) {

                int next = i + 1;

                while (next <= right &&
                       freq[s.charAt(next) - 'a'] < k) {
                    next++;
                }

                return Math.max(
                    solve(s, left, i - 1, k),
                    solve(s, next, right, k)
                );
            }
        }

        // Every character occurs at least k times
        return right - left + 1;
    }
}