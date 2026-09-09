class Problem03 {
public:
    ListNode* reverseKGroup(ListNode* head, int k) {
        ListNode* curr = head;

        // Check if there are at least k nodes
        for (int i = 0; i < k; i++) {
            if (curr == nullptr)
                return head;
            curr = curr->next;
        }

        // Reverse k nodes
        ListNode* prev = nullptr;
        curr = head;

        for (int i = 0; i < k; i++) {
            ListNode* next = curr->next;
            curr->next = prev;
            prev = curr;
            curr = next;
        }

        // head is now the tail of the reversed group
        head->next = reverseKGroup(curr, k);

        return prev;
    }
};