class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n=intervals.length;
        int[] ans=new int[n];
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int i=0;i<n;i++)map.put(intervals[i][0],i);
        for(int i=0;i<n;i++){
            Integer key=map.ceilingKey(intervals[i][1]);
            ans[i]=key==null?-1:map.get(key);
        }
        return ans;
    }
}