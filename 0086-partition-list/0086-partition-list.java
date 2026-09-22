class Solution {
    public ListNode partition(ListNode head, int x) {

        // Dummy nodes for the two partitions
        ListNode lessDummy = new ListNode(0);
        ListNode greaterDummy = new ListNode(0);

        ListNode less = lessDummy;
        ListNode greater = greaterDummy;

        ListNode current = head;

        while (current != null) {

            if (current.val < x) {
                less.next = current;
                less = less.next;
            } else {
                greater.next = current;
                greater = greater.next;
            }

            current = current.next;
        }

        // End the greater/equal partition
        greater.next = null;

        // Connect both partitions
        less.next = greaterDummy.next;

        return lessDummy.next;
    }
}