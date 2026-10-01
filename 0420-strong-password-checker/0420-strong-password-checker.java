class Solution {
    public int strongPasswordChecker(String password) {
        int n = password.length();

        boolean lower = false, upper = false, digit = false;

        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) lower = true;
            else if (Character.isUpperCase(c)) upper = true;
            else if (Character.isDigit(c)) digit = true;
        }

        int missing = 0;
        if (!lower) missing++;
        if (!upper) missing++;
        if (!digit) missing++;

        // Find groups of 3 or more repeating characters
        int replace = 0;
        int one = 0; // groups where len % 3 == 0
        int two = 0; // groups where len % 3 == 1

        for (int i = 0; i < n;) {
            int j = i;

            while (j < n && password.charAt(j) == password.charAt(i)) {
                j++;
            }

            int len = j - i;

            if (len >= 3) {
                replace += len / 3;

                if (len % 3 == 0) {
                    one++;
                } else if (len % 3 == 1) {
                    two++;
                }
            }

            i = j;
        }

        // Too short
        if (n < 6) {
            return Math.max(missing, 6 - n);
        }

        // Length is valid
        if (n <= 20) {
            return Math.max(missing, replace);
        }

        // Too long
        int delete = n - 20;

        // First delete from groups where 1 deletion reduces a replacement
        int use = Math.min(delete, one);
        replace -= use;
        delete -= use;

        // Then groups where 2 deletions reduce one replacement
        use = Math.min(delete, two * 2);
        replace -= use / 2;
        delete -= use;

        // Remaining deletions: every 3 deletions reduce one replacement
        replace -= delete / 3;

        return (n - 20) + Math.max(missing, replace);
    }
}