public class Main {
    public static void main(String[] args) {
        Solution1 solver = new Solution1();
        
        // Test 1: Valid BST
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println("Test 1 (Valid): " + solver.isValidBST(root));
        
        // Test 2: Invalid BST
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);
        System.out.println("Test 2 (Invalid): " + solver.isValidBST(root2));
    }
}
