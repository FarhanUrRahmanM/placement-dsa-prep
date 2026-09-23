class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            Node prev = null;

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();

                if (prev != null) {
                    prev.next = current;
                }

                prev = current;

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            prev.next = null;
        }

        return root;
    }
}