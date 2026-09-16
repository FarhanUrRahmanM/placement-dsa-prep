class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return result;
    }

    void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }

        path.add(root.val);
        targetSum -= root.val;

        // Leaf node + required sum reached
        if (root.left == null && root.right == null && targetSum == 0) {
            result.add(new ArrayList<>(path));
        }

        dfs(root.left, targetSum);
        dfs(root.right, targetSum);

        // Backtrack
        path.remove(path.size() - 1);
    }
}