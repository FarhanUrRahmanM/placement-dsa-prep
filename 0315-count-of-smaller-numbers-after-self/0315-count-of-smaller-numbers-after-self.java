class Solution {
    int[] ans;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        ans = new int[n];

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i]; // value
            arr[i][1] = i;       // original index
        }

        mergeSort(arr, 0, n - 1);

        List<Integer> result = new ArrayList<>();

        for (int x : ans) {
            result.add(x);
        }

        return result;
    }

    void mergeSort(int[][] arr, int left, int right) {

        if (left >= right)
            return;

        int mid = (left + right) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    void merge(int[][] arr, int left, int mid, int right) {

        int[][] temp = new int[right - left + 1][2];

        int i = left;
        int j = mid + 1;
        int k = 0;
        int smaller = 0;

        while (i <= mid && j <= right) {

            if (arr[j][0] < arr[i][0]) {

                temp[k++] = arr[j++];
                smaller++;

            } else {

                ans[arr[i][1]] += smaller;
                temp[k++] = arr[i++];
            }
        }
        while (i <= mid) {
            ans[arr[i][1]] += smaller;
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        for (int x = 0; x < temp.length; x++) {
            arr[left + x] = temp[x];
        }
    }
}