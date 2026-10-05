class Solution {
    public boolean find132pattern(int[] nums) {

        int third = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) {

            // nums[i] is the "1"
            if (nums[i] < third) {
                return true;
            }

            // Find a value that can act as "2"
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                third = stack.pop();
            }

            stack.push(nums[i]);
        }

        return false;
    }
}