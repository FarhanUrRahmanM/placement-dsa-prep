class Solution {
    public NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }

        Stack<NestedInteger> stack = new Stack<>();
        int num = 0;
        int sign = 1;
        boolean hasNum = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '-') {
                sign = -1;
            } 
            else if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
                hasNum = true;
            } 
            else if (c == '[') {
                stack.push(new NestedInteger());
            } 
            else if (c == ',' || c == ']') {
                if (hasNum) {
                    stack.peek().add(new NestedInteger(num * sign));
                    num = 0;
                    sign = 1;
                    hasNum = false;
                }

                if (c == ']' && stack.size() > 1) {
                    NestedInteger current = stack.pop();
                    stack.peek().add(current);
                }
            }
        }

        return stack.pop();
    }
}