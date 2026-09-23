class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, k, n, new ArrayList<>(), result);
        return result;
    }

    public void backtrack(int start, int k, int n, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == k) {
            if (n == 0) {
                result.add(new ArrayList<>(list));
            }
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (i > n) {
                break;
            }

            list.add(i);
            backtrack(i + 1, k, n - i, list, result);
            list.remove(list.size() - 1);
        }
    }
}