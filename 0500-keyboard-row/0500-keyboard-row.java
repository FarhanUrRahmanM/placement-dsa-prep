class Solution {
    public String[] findWords(String[] words) {
        String[] rows = {
            "qwertyuiop",
            "asdfghjkl",
            "zxcvbnm"
        };

        List<String> result = new ArrayList<>();

        for (String word : words) {
            String w = word.toLowerCase();

            int row = -1;

            if (rows[0].indexOf(w.charAt(0)) != -1) {
                row = 0;
            } else if (rows[1].indexOf(w.charAt(0)) != -1) {
                row = 1;
            } else {
                row = 2;
            }

            boolean valid = true;

            for (char c : w.toCharArray()) {
                if (rows[row].indexOf(c) == -1) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                result.add(word);
            }
        }

        return result.toArray(new String[0]);
    }
}