class Solution {
    public int func(int node, List<List<Integer>> adj, int[] time, int[] dp) {
        if(dp[node] != -1) return dp[node];
        int ans = 0;
        for(int adjNode: adj.get(node)) {
            int val = func(adjNode, adj, time, dp);
            ans = Math.max(ans, val);
        }
        return dp[node] = ans+time[node];
    }
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        for(int[] r : relations) {
            adj.get(r[1]-1).add(r[0] - 1);
        }
        int ans = 0;
        for(int i=0; i<n; i++) {
            int vla = func(i, adj, time, dp);
            ans = Math.max(ans, vla);
        }

        return ans;
    }
}