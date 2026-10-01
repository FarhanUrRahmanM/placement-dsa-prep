class Solution {
    class TrieNode {
        TrieNode[] child = new TrieNode[2];
    }

    TrieNode root = new TrieNode();

    void insert(int num) {
        TrieNode curr = root;

        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;

            if (curr.child[bit] == null) {
                curr.child[bit] = new TrieNode();
            }

            curr = curr.child[bit];
        }
    }

    int findMaxXor(int num) {
        TrieNode curr = root;
        int result = 0;

        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int opposite = 1 - bit;

            if (curr.child[opposite] != null) {
                result |= (1 << i);
                curr = curr.child[opposite];
            } else {
                curr = curr.child[bit];
            }
        }

        return result;
    }

    public int findMaximumXOR(int[] nums) {
        for (int num : nums) {
            insert(num);
        }

        int ans = 0;

        for (int num : nums) {
            ans = Math.max(ans, findMaxXor(num));
        }

        return ans;
    }
}