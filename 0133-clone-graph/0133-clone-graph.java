class Solution {
    Map<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;

        if (map.containsKey(node.val))
            return map.get(node.val);

        Node clone = new Node(node.val);
        map.put(node.val, clone);

        for (Node n : node.neighbors)
            clone.neighbors.add(cloneGraph(n));

        return clone;
    }
}