class WordFilter {

    String[] words;

    public WordFilter(String[] words) {
        this.words = words;
    }

    public int f(String pref, String suff) {
        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].startsWith(pref) && words[i].endsWith(suff)) {
                return i;
            }
        }

        return -1;
    }
}