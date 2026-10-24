class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }

        Node curr = head;

        while (curr != null) {
            if (curr.child != null) {
                Node next = curr.next;
                Node child = flatten(curr.child);

                curr.next = child;
                child.prev = curr;
                curr.child = null;

                Node tail = child;
                while (tail.next != null) {
                    tail = tail.next;
                }

                tail.next = next;

                if (next != null) {
                    next.prev = tail;
                }
            }

            curr = curr.next;
        }

        return head;
    }
}