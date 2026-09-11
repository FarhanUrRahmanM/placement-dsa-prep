public class Main {
    public static void main(String[] args) {
        Solution1 solver = new Solution1();
        
        // Test 1: Valid BST
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println("Test 1 (Valid): " + solver.isValidBST(root));
    }
}
