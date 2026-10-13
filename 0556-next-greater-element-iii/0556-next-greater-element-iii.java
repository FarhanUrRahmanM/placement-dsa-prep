class Solution{
    public int nextGreaterElement(int n){
        char[] a=String.valueOf(n).toCharArray();
        int i=a.length-2;
        while(i>=0&&a[i]>=a[i+1])i--;
        if(i<0)return -1;
        int j=a.length-1;
        while(a[j]<=a[i])j--;
        char t=a[i];
        a[i]=a[j];
        a[j]=t;
        int l=i+1,r=a.length-1;
        while(l<r){
            t=a[l];
            a[l]=a[r];
            a[r]=t;
            l++;
            r--;
        }
        try{
            long ans=Long.parseLong(new String(a));
            return ans<=Integer.MAX_VALUE?(int)ans:-1;
        }catch(Exception e){
            return -1;
        }
    }
}