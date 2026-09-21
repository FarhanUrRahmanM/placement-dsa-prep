class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] a = preorder.split(",");
        int slots = 1;

        for (String s : a) {
            if (slots == 0) return false;

            if (s.equals("#")) {
                slots--;
            } else {
                slots++;
            }
        }

        return slots == 0;
    }
}