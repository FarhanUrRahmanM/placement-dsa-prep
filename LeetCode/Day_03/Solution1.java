class Solution1 {
    public boolean isValidBST(TreeNode root) {
        return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    boolean check(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        return true;
    }
}
