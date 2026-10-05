class Solution {
    public boolean circularArrayLoop(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {

            int slow = i;
            int fast = i;

            boolean direction = nums[i] > 0;

            while (true) {

                slow = next(nums, slow, direction);

                if (slow == -1) {
                    break;
                }

                fast = next(nums, fast, direction);

                if (fast == -1) {
                    break;
                }

                fast = next(nums, fast, direction);

                if (fast == -1) {
                    break;
                }

                if (slow == fast) {

                    // One-element cycle is not allowed
                    if (slow == nextIndex(nums, slow)) {
                        break;
                    }

                    return true;
                }
            }
        }

        return false;
    }

    private int next(int[] nums, int index, boolean direction) {

        // Direction must remain the same
        if ((nums[index] > 0) != direction) {
            return -1;
        }

        int nextIndex = nextIndex(nums, index);

        // Self-loop is invalid
        if (nextIndex == index) {
            return -1;
        }

        return nextIndex;
    }

    private int nextIndex(int[] nums, int index) {

        int n = nums.length;

        return ((index + nums[index]) % n + n) % n;
    }
}