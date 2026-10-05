class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(0);
            } else {
                int inside = stack.pop();
                int score = (inside == 0) ? 1 : 2 * inside;

                int outer = stack.pop();
                stack.push(outer + score);
            }
        }

        return stack.pop();
    }
}