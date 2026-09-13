class Solution {
    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        find(root);
        return ans;
    }

    int find(TreeNode root) {
        if (root == null)
            return 0;

        int left = Math.max(0, find(root.left));
        int right = Math.max(0, find(root.right));

        ans = Math.max(ans, root.val + left + right);

        return root.val + Math.max(left, right);
    }
}